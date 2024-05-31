<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
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
			<h2 class="text-center">Products list</h2>
		</section>
		<section class="my-4">
		<div class="my-3 fs-5">
		<c:url var="topdf" value="/products/convert/pdf"></c:url>
			<strong>Copy information to PDF</strong><a class="btn btn-link btn-warning fs-3" href="${topdf}" title="Create a new PDF document with the information from the table."><i class="bi bi-filetype-pdf"></i></a>
		</div>
			<table class="table table-striped table-hover">
				<thead class="table-dark">
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Section</th>
						<th scope="col">Price</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:if test="${empty products}">
						<h4 class="display-6 text-center">
							<c:out value="No product was added"></c:out>
						</h4>
					</c:if>
					<c:forEach items="${products}" var="product">
						<tr>
							<td>${product.name}</td>
							<td>${product.section}</td>
							<td>&#36; ${product.price}</td>
							<td><a href="<c:url value='/products/${product.id}' />"
								class="btn btn-sm btn-primary" title="See detail">See detail</a>
								<a href="<c:url value='/products/update/${product.id}' />"
								class="btn btn-sm btn-success">Edit</a>
								<button class="btn btn-sm btn-danger"
									onclick="confirmDelete(${product.id})">Delete</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
		<footer class="text-center my-4">
			<p>&copy; 2024 Mi empresa</p>
		</footer>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="deleteModal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="deleteModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="deleteModalLabel">Confirm
						Deletion</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">Are you sure you want to delete this
					product?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cancel</button>
					<sf:form id="deleteForm" method="post" style="display: inline;">
						<button type="submit" class="btn btn-danger">Delete</button>
					</sf:form>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>

	<!-- El script tiene que ser ejecutado desde un archivo .js externo -->
	<script>
        function confirmDelete(productId) {
            const deleteForm = document.getElementById('deleteForm');
            deleteForm.action = '/stockmanager/products/delete/' + productId;
            const deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'));
            deleteModal.show();
        }
    </script>
</body>
</html>
