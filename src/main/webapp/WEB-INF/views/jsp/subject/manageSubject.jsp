<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html" charset="ISO-8859-1">
<title>Admin Manage Subject</title>
<title>DataTables in Spring MVC Framework and Spring Data JPA</title>
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

	<jsp:include page="/WEB-INF/views/jsp/navbar.jsp"></jsp:include>

	<div class="container">

		<div class="card p-4">
			<div class="card-header">Quote</div>
			<div class="card-body">
				<blockquote class="blockquote mb-0">
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Integer posuere erat a ante.</p>
					<footer class="blockquote-footer">
						Someone famous in <cite title="Source Title">Source Title</cite>
					</footer>
				</blockquote>
			</div>
		</div>
		<div class="p-3"></div>
		<div class="row">

			<div class="col-sm-8 border">

				<div class="form-group">
					<div class="row">
						<a class="form-control" href="${pageContext.request.contextPath}/admin/exportSubject">Export
							To Excel</a>
					</div>
					<div class="row">
						<a class="form-control" href="${pageContext.request.contextPath}/admin/exportPDF">Export
							To PDF</a>
					</div>
				</div>

				<div class="row form-control">

					<form class=""
						action="${pageContext.request.contextPath}/admin/manageSubject">
						<div class="row">
							<div class="col-8">

								<input class="form-control" type="text" name="searchBy"
									value="${searchBy}" /> <input type="hidden" name="size"
									value="${size}" /> <input type="hidden" name="page"
									value="${page}" /> <input type="hidden" name="sortBy"
									value="${sortBy}" />

							</div>
							<div class="col-4">
								<input type="submit" class="form-control btn btn-success"
									value="search" />
							</div>

						</div>
					</form>

				</div>

				<div class="table-reponsive">
					<table class="table">

						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Description</th>
								<th>ImageUrl</th>
								<th>Date</th>
								<th>Action</th>

							</tr>
						</thead>
						<tbody>

							<c:forEach varStatus="counter" var="s" items="${subjectList}">
								<tr>
									<td>${counter.count}</td>
									<td>${s.name }</td>
									<td>${s.description }</td>
									<td><input type="text" value="${s.urlImage}"
										name="urlImage" /></td>
									<td>${s.date}</td>
									<td><a href="" class="btn btn-primary">Detail</a></td>
								</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>

				<form
					action="${pageContext.request.contextPath}/admin/manageSubject?page=${page}&searchBy=${searchBy}&sortBy=${sortBy}">

					<select id="totalRecord" name="size" onchange="this.form.submit();">
						<option value="${size}" selected="">${size}</option>
						<c:forEach var="s" step="10" begin="5" end="100">
							<option value="${s}">${s}</option>
						</c:forEach>

					</select>

				</form>
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-end">
						<li class="page-item disabled"><span class="page-link">Previous</span>
						</li>
						<c:forEach var="index" begin="0" end="${totalPage}">
							<c:if test="${page eq index}">
								<li class="page-item active"><span class="page-link">
										${index + 1}<span class="sr-only">(current)</span>
								</span></li>
							</c:if>
							<c:if test="${page ne index}">
								<li class="page-item"><a class="page-link"
									href="${pageContext.request.contextPath}/admin/manageSubject?page=${index}&size=${size}&searchBy=${searchBy}&sortBy=${sortBy}">${index + 1}</a>
								</li>
							</c:if>
						</c:forEach>
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
					</ul>
				</nav>

			</div>
			<div class="col-sm-1"></div>

			<div class="col-sm-3 border"></div>
		</div>
	</div>
	<div class="row p-3"></div>
	<div class="footer">
		<div class="card bg-dark text-white">
			<img class="card-img" src="..." alt="Card image">
			<div class="card-img-overlay">
				<h5 class="card-title">Card title</h5>
				<p class="card-text">This is a wider card with supporting text
					below as a natural lead-in to additional content. This content is a
					little bit longer.</p>
				<p class="card-text">Last updated 3 mins ago</p>
			</div>
		</div>
	</div>



</body>
</html>