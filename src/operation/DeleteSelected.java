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

@WebServlet("/deleteSelected")
public class DeleteSelected extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get data
		String id[]= request.getParameterValues("id");

		// connection
		Connection con = Conn.getCon();

		// Query
		try {
			int result = 0;
			for(int i=0;i<id.length;i++)
			{
				PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
				ps.setString(1, id[i]);
				
				result=ps.executeUpdate();
				
			}
			if(result>0)
			{
				request.setAttribute("msg", "Deleted");
				RequestDispatcher rd=request.getRequestDispatcher("ShowAllEmployee");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "Not Updated");
				RequestDispatcher rd=request.getRequestDispatcher("ShowAllEmployee");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
