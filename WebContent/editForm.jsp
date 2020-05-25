<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="editform" method="post">
<h2 align="center"><font><strong>Edit User</strong></font></h2>

<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>
<td><b>Id</b></td>
<td><input type="text" name = "id1" value ="${id1}">
</td>
</tr>
<tr>
<td><b>First Name</b></td>
<td><input type="text" name = "uname" value ="${uname}">
</td>
</tr>

<tr>
<td><b>Email</b></td>
<td><input type="text" name = "email" value ="${email}">
</td>
</tr>
<tr>
<td><b>User</b></td>
<td><input type="text" name = "phone" value ="${phone}">
</td>
</tr>
<tr>


<td><b>Operations</b>
<td><b><input type="submit" value="submit"></b>
</td>

</table>
</form>

</body>



