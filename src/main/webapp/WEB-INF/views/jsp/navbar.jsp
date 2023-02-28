<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
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
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="/mvcdemo/">Home <span class="sr-only">(current)</span></a></li>

					<li class="nav-item"><sec:authorize access="hasRole('ADMIN')">
							<a class="nav-link" href="/mvcdemo/admin/">Administrator</a>
						</sec:authorize></li>

					<li class="nav-item"><sec:authorize access="isAuthenticated()">
							<a class="nav-link" href="/mvcdemo/user/">Manager User</a>
						</sec:authorize></li>

					<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
					</li>
				</ul>
				<form class="form-inline my-2 my-lg-0">
					<sec:authorize access="isAuthenticated()">
						<sec:authentication property="pricipal" var="user"/>
						
						<input class="forme-control mr-sm-2" value="Welcome, ${user.username}" readonly=""
							type="search" placholder="Search" aria-label="Search">
						
						
						<a href="/mvcdemo/logout" class="btn btn-outline-danger my-2 my-sm-0"
							style="color: red;"> Logout </a>
					</sec:authorize>
				</form>
			</div>
		</nav>




	</header>
</body>
</html>