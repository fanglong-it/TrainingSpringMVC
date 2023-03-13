<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="/mvcdemo/">Navbar</a>
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

					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li class="nav-item"><a class="nav-link"
							href="/mvcdemo/admin/">Administrator</a></li>

						<li class="nav-item"><a class="nav-link"
							href="/mvcdemo/admin/manageSubject">Manage Subject</a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li class="nav-item"><a class="nav-link"
							href="/mvcdemo/user/">Manager User</a></li>
					</sec:authorize>
					<li class="nav-item"><a class="nav-link"
						href="/mvcdemo/subjects" />Learning</a></li>

				</ul>
				<form class="form-inline my-2 my-lg-0">

					<sec:authorize access="isAuthenticated()">

						<input class="form-control mr-sm-2"
							value="Welcome, <sec:authentication property="principal.username"/>"
							readonly="" type="search" placholder="Search" aria-label="Search">
						<a href="/mvcdemo/dang-xuat"
							class="btn btn-outline-danger my-2 my-sm-0" style="color: red;">
							Logout </a>
					</sec:authorize>

					<sec:authorize access="isAnonymous()">
						<a href="/mvcdemo/dang-nhap"
							class="btn btn-outline-primary my-2 my-sm-0"> Login </a>

						<a href="/mvcdemo/dang-ky"
							class="btn btn-outline-warning my-2 my-sm-0">Register</a>
					</sec:authorize>

				</form>
			</div>
		</nav>
	</header>

</body>
</html>