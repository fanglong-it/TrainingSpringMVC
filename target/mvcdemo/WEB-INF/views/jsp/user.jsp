<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false"%>
<meta charset="ISO-8859-1">
<title>List User here</title>

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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>


</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>


	<div class="container">

		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Username</th>
					<th scope="col">Password</th>
				
					<th scope="col">enable</th>
					<th scope="col">Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="user" items="${USERS_LIST}" varStatus="counter">
					<tr>
						<td scope="row"><c:out value="${counter.count}"></c:out></td>

						<td><c:out value="${user.username}"></c:out></td>
						<td>${user.password}</td>
					
						<td>${user.enabled}</td>
						<td><a
							href="${pageContext.request.contextPath}/user/edit?username=${user.username}"
							class="btn btn-primary">Edit</a> <a
							href="${pageContext.request.contextPath}/user/delete/${user.username}"
							class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<c:if test="${not empty message}">

		<script type="text/javascript">
			swal({
				title : 'error',
				text : '${message}.',
				timer : 2000,
				button : false
			});
		</script>
	</c:if>
</body>
</html>