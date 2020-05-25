<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="deleteSelected">
		<%
			String msg = (String) request.getAttribute("msg");

			if (msg != null) {
		%>

		<script type="text/javascript">
			alert("${msg}");
		</script>
		<%
			}
		%>


		<h2 align="center">
			<font><strong>Retrieve data from database in jsp</strong></font>
		</h2>

		<table align="center" cellpadding="5" cellspacing="5" border="1">
			<tr>
				<td>#</td>
								
				<td><b>Id</b></td>
				<td><b>User Name</b></td>
				<td><b>Email</b></td>
				<td><b>Phone</b></td>
				<td><b>Edit</b></td>
				<td><b>Delete</b></td>

			</tr>
			<c:forEach var="employee" items="${emplist}">
				<tr>
				<td>
				<input type="checkbox" name="id" value="${employee.id}">
				</td>
					<td><c:out value="${employee.id}" /></td>
					<td><c:out value="${employee.uname}" /></td>
					<td><c:out value="${employee.email}" /></td>
					<td><c:out value="${employee.phone}" /></td>

					<td><a href="retrieve?id=${employee.id}">Edit</a></td>
					<td><a href="deleteUSer?id=${employee.id}">Delete</a></td>
					
				</tr>
			</c:forEach>
			<tr><td><input type="submit" value="Delete Selected"></td></tr>
					
					
		</table>
	</form>
</body>
</html>