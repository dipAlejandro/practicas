<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<title>Empresa :: Stock manager - Product Details</title>
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
							<li class="nav-item"><a class="nav-link" aria-current="page"
								href="<c:url value='/' />">List all Products</a></li>
							<li class="nav-item"><a class="nav-link"
								href="<c:url value='/products/new' />">Add new Product</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</header>
		<section class="text-bg-primary p-5 rounded mb-4">
			<h2 class="text-center">Product Detail</h2>
		</section>
		<section class="my-4">
			<table class="table table-striped table-hover table-bordered">
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
					<tr>
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td>${product.section}</td>
						<td>&#36; ${product.price}</td>
						<td>${product.description}</td>
					</tr>
				</tbody>
			</table>
		</section>
		<footer class="text-center my-4">
			<p>&copy; 2024 Mi Empresa</p>
		</footer>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>
