<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>List User here</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Username</th>
				<th>Password</th>
				<th>Role</th>
				<th>enable</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="user" items="${USERS_LIST}">
				<tr>
					<td>
						<c:out value="${status.count + 1}"></c:out>
					</td>
					<td>
						<c:out value="${user.username}"></c:out>
					
					</td>
					<td>${user.password}</td>
					<td>${user.role}</td>
					<td>${user.enabled}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>