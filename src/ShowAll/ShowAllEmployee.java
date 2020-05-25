package ShowAll;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conn.Conn;
import Model.employee;


@WebServlet("/ShowAllEmployee")
public class ShowAllEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

		Connection con = Conn.getCon();
			List<employee> list=new ArrayList();
			PreparedStatement ps = con.prepareStatement("select id,uname,email,phone from employee");
			ResultSet rs=	ps.executeQuery();
		
		while(rs.next())
		{
			int id = rs.getInt(1);
			String uname=rs.getString(2);
			String email=rs.getString(3);
			String phone=rs.getString(4);
			
			list.add(new employee(id,uname,email,phone));
		}
		if(!list.isEmpty())
		{
			request.setAttribute("emplist", list);
			RequestDispatcher rd=request.getRequestDispatcher("ListOfEmployee.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Record Not Found");
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	}

