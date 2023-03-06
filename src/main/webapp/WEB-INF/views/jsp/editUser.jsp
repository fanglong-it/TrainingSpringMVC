<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ page isELIgnored="false"%>
<title>Insert title here</title>
<!-- resource start -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<!-- resource end -->
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<form:form action="${pageContext.request.contextPath}/user/saveUser"
			modelAttribute="user" method="POST">
			<div class="form-group">
				username
				<form:input class="form-control" path="username" />
			</div>
			<div class="form-group">
				password
				<form:input class="form-control" path="password"/>
			</div>
			<div class="form-group">
				Re-Password
				<input class="form-control" name="repassword"/>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-3">enabled</div>
					<div class="col-3">
						<form:checkbox class="form-control" path="enabled" value="true" />
					</div>

				</div>
			</div>
	</div>

	<input type="submit" class="btn btn-primary form-control"
		value="Submit" />
	</form:form>

	</div>
</body>
</html>