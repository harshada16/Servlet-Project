package ForgotPassword;

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

import sun.security.pkcs11.Secmod.DbMode;

@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("username");
		Connection con = Conn.getCon();
		try {
			PreparedStatement ps = con.prepareStatement("select * from employee where uname=?");
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				String vcode=rs.getString("pass");
				String to=rs.getString("email");
				RequestDispatcher rd=request.getRequestDispatcher("mail?vcode="+vcode+" &to="+to+"&username="+uname);
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "User Does Not Exists");
				RequestDispatcher rd=request.getRequestDispatcher("ForgotPassword.jsp");
				rd.forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
