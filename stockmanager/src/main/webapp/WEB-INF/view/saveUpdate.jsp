<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<title>Empresa :: Stock manager</title>
</head>
<body>
	<div class="container">
		<header class="my-4">
			<h1>Mi Empresa</h1>
			<h2>Stock Manager</h2>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
						aria-controls="navbarNavAltMarkup" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="<c:url value='/' />">List all
									Products</a></li>
							<li class="nav-item"><a class="nav-link"
								href="<c:url value='/products/new' />">Add new Product</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</header>
		<section class="text-bg-primary p-5 rounded mb-4">
			<h2 class="text-center">All products</h2>
		</section>
		<section class="my-4">
			<table class="table table-striped table-hover">
				<thead class="table-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Name</th>
						<th scope="col">Section</th>
						<th scope="col">Price</th>
						<th scope="col">Description</th>
					</tr>
				</thead>
				<tbody>
				<c:if test="${not empty productUpdated }"></c:if>
					<tr>
						<td>${productUpdated.id}</td>
						<td>${productUpdated.name}</td>
						<td>${productUpdated.section}</td>
						<td> &#36; ${productUpdated.price}</td>
						<td>${productUpdated.description}</td>
					</tr>
				</tbody>
			</table>
		</section>
	</div>
</body>
</html>