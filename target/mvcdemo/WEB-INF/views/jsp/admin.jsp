<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<%@ page isELIgnored="false"%>
<meta charset="ISO-8859-1">
<title>Admin Manage</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>


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
	<h1>Manager Admin</h1>

	<div class="container">


		<table class="table">
			<thead>
				<tr>
					<td>count</td>
					<td>Username</td>
					<td>Role</td>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="role" varStatus="counter" items="${ROLES}">
					<tr>
						<td>${counter.count}</td>
						<td>${role.user.username}</td>
						<td>${role.authority}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script type="text/javascript">
		(function($) {
			showSwal = function(type) {
				'use strict';
				if (type === 'auto-close') {
					swal({
						title : 'Auto close alert!',
						text : 'I will close in 2 seconds.',
						timer : 2000,
						button : false
					}).then(function() {
					},
					// handling the promise rejection
					function(dismiss) {
						if (dismiss === 'timer') {
							console.log('I was closed by the timer')
						}
					})
				} else {
					swal("Error occured !");
				}
			}

		})(jQuery);
	</script>

</body>
</html>