<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
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
        <form method="post" action="SignUp">
        
            <table  border="1" width="30%" cellpadding="5"> 
                <thead>
                    <tr>
                        <th colspan="2">SignUp Form</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="uname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Phone No</td>
                        <td><input type="text" name="phone" value="" /></td>
                    </tr>
                   
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="index.jsp">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
            
        </form>
    </body>
</html>
