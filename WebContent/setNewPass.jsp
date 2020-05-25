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
<form action="reset">
<center>
<input type="hidden" name="username" value="${username}">
verification Code:<input type="text" name="vcode">
New Password:<input type="text" name="pass"><br>
<input type="submit" value="Reset">
</center>
</form>
</body>
</html>