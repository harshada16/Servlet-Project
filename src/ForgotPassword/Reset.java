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
import Login.HashGenerateUtils;

/**
 * Servlet implementation class Reset
 */
@WebServlet("/reset")
public class Reset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vcode=request.getParameter("vcode");
		String newpass=request.getParameter("pass");
		
		String uname = request.getParameter("username");
		System.out.println(uname + "44444444444444444");
		Connection con = Conn.getCon();
		try {
			PreparedStatement ps = con.prepareStatement("select pass from employee where uname=?");
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				String pass=rs.getString("pass");
				
				if(pass.equals(vcode))
				{
					PreparedStatement pst=con.prepareStatement("update employee set pass=? where uname=?");
					String encryptedpwd = HashGenerateUtils.generateSHA256(newpass);

					pst.setString(1, encryptedpwd);
					pst.setString(2, uname);
				
					int result=pst.executeUpdate();
					
					if(result>0)
					{
						request.setAttribute("msg", "New Passwoed "+newpass);
						RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
						rd.forward(request, response);
								
					}
					else
					{
						request.setAttribute("msg", "Something Wrong password nott updated");
						RequestDispatcher rd=request.getRequestDispatcher("ForgotPassword.jsp");
						rd.forward(request, response);
					}
				}
				else
				{
					request.setAttribute("msg", "Invalid Verification Code");
					RequestDispatcher rd=request.getRequestDispatcher("setNewPass.jsp");
					rd.forward(request, response);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
