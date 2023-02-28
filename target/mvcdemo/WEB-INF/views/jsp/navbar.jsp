<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<header>


		<a href="/mvcdemo/">Home</a>

		<sec:authorize access="isAuthenticated()">

			<a href="user"> User manager </a>
			<a href="logout" style="color: red;"> Logout </a>

		</sec:authorize>


		<sec:authorize access="hasRole('ADMIN')">
			<a href="admin">Administrator</a>
		</sec:authorize>

	</header>
</body>
</html>