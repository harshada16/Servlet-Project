package Signup;

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
import Login.HashGenerateUtils;


@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		
		try {
			Connection con = Conn.getCon();
			PreparedStatement ps = con.prepareStatement("insert into employee (uname,pass,email,phone)" +" values(?,?,?,?)");
			
			String encryptedpwd = HashGenerateUtils.generateSHA256(pass);

			ps.setString(1, uname);
			ps.setString(2, encryptedpwd);
			ps.setString(3, email);
			ps.setString(4, phone);
		
			int i=ps.executeUpdate();
			if(i>0) {
				request.setAttribute("msg", "Registration Succesful login now"); 
				RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
		    	rd.forward(request, response);

		       
		    } else {
		    	
		    	request.setAttribute("msg", "Regiostration failed!!!");
		    	RequestDispatcher rd= request.getRequestDispatcher("SignUp.jsp");
		    	rd.forward(request, response);
		        
		    }
			
		} 
		catch(Exception e){
			e.printStackTrace();
		}
	}
	


}
