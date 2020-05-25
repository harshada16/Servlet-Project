package ForgotPassword;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mail")

public class SendMail extends HttpServlet {
private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in mail");

		String host="smtp.gmail.com";
		String port="587";
		String user="attendance2715@gmail.com";
		String pass="attendance2715@gmail";
		
		
		String recipient=request.getParameter("to");
	
		String subject="Password";
		String content="Hi..Your verification code is "+request.getParameter("vcode");
				 
		
		
		try {

			EmailUtility.sendEmail(host, port, user, pass, recipient, subject, content);
		
			request.setAttribute("msg", "Verification code sent to registered mail");
			request.setAttribute("username", request.getParameter("username"));
			RequestDispatcher rd=request.getRequestDispatcher("setNewPass.jsp");
			rd.forward(request, response);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			response.sendRedirect("forgotPassword.jsp?msg=vcode  Not sent Check Internet Connection And Valid Email");

		}

		
	}
}
