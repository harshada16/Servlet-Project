package operation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conn.Conn;

@WebServlet("/deleteUSer")
public class DeleteUSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");

		try {
			Connection con= Conn.getCon();
			
			PreparedStatement ps=con.prepareStatement("delete from employee where uname=?");
			ps.setString(1, uname);
			
			int result=ps.executeUpdate();
			
			if(result>0)
			{
				request.setAttribute("msg", "User Deleted");
				RequestDispatcher rd=request.getRequestDispatcher("ShowAllEmployee");
				rd.forward(request, response);
						
			}
			else
			{
				request.setAttribute("msg", "User Not Deleted");
				RequestDispatcher rd=request.getRequestDispatcher("ShowAllEmployee");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
