package Login;

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


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		try {
				Connection con=Conn.getCon();
				PreparedStatement ps=con.prepareStatement("select * from employee where uname=? and pass=?");
				String encryptedpwd = HashGenerateUtils.generateSHA256(pass);
				ps.setString(1, uname);
			 ps.setString(2, encryptedpwd);
			ResultSet rs=ps.executeQuery();
			if (rs.next()){
				System.out.println(rs.getString("uname")+ " " + rs.getString("pass"));
				RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
				}
			else
			{
				request.setAttribute("msg", "Wrong username or password");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	}


