<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Reset Password</title>
    <link rel="stylesheet" href="/css/style.css" >
    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/js/jquery.validate.min.js"></script>
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
    <div align="center">
        <h2>Reset Your Password</h2>
        <p>
        Please enter your login email, we'll send a new random password to your inbox:
        </p>
         
        <form id="resetForm" action="ForgotPassword">
            <table>
                
                 <tr>
                    <td>User:</td>
                    <td><input type="text" name="username" id="username" size="20"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <button type="submit">Send me verification Code</button>
                    </td>
                </tr>    
            </table>
        </form>
    </div>
    
     
<script type="text/javascript">
 
    $(document).ready(function() {
        $("#resetForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                }      
            },
             
            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                }
            }
        });
 
    });
</script>
</body>
</html>