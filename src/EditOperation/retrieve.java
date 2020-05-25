package EditOperation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Conn.Conn;

@WebServlet("/retrieve")
public class retrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int id=Integer.parseInt(request.getParameter("id"));
	
	try {
		Connection con= Conn.getCon();
		PreparedStatement ps = con.prepareStatement("select * from employee where id=?");
		ps.setInt(1, id);
		
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
		    int id1 = rs.getInt(1);
			String uname=rs.getString(2);
			String pass=rs.getString(3);
			String email=rs.getString(4);
			String phone=rs.getString(5);
			
			request.setAttribute("id1", id1);
			request.setAttribute("uname", uname);
			request.setAttribute("pass", pass);
			request.setAttribute("email", email);
			request.setAttribute("phone", phone);
			
			RequestDispatcher rd = request.getRequestDispatcher("editForm.jsp");
			rd.forward(request, response);
				
		}else
		{
			RequestDispatcher rd = request.getRequestDispatcher("ShowAllEmployee");
			rd.forward(request, response);
				
		}
		
	}catch(Exception e) {
		
	}
		
	}

}
