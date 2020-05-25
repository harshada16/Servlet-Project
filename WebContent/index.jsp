<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String msg=(String)request.getAttribute("msg");

if(msg!=null)
{
%>

<script type="text/javascript">
alert("${msg}");
</script>
<%
}

%>

<form action="loginServlet" method="post">
<center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Login</th>
                    </tr>
                </thead>
                <tbody>
					 <tr>
                        <td align="center">User Name <input type="text" name="uname" value="" /></td>
                    </tr>
                    <tr>
                        <td align="center">Password <input type="password" name="pass" value="" /></td>
                    </tr>
                    <tr>
                        <td align="center"><input type="submit" value="Submit" />
                        <input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="6"><a href="SignUp.jsp">SignUp new user</a>
                    <a href="ForgotPassword.jsp">Forgot Password</a></td>
                    </tr>
				</tbody>

</table>
</center>
</form>
</body>
</html>