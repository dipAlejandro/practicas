<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring forms :: Users</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
<!-- Agregamos el archivo CSS externo -->
</head>
<body>
	<nav>
		<a href="#" class="brand">Users App</a>
		<ul>
			<li><a href="<c:url value="/users/" />" title="View Users">View
					users</a></li>
			<li><a href="<c:url value="/users/new" />" title="New User">New
					User</a></li>
		</ul>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h1>Users list</h1>
			<p>There are the users currently in the system.</p>
		</div>

		<table>
			<thead>
				<tr>
					<th>Login</th>
					<th>Description</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.login}</td>
						<td>${user.description}</td>
						<td>
							<a class="link-btn info" href="<c:url value='/users/${user.id}' />" title="Detailed info">see detail</a>
							<a class="link-btn success" href="<c:url value='/users/update/${user.id}' />" title="Update">Update</a>
							<a class="link-btn danger" href="<c:url value='/users/delete/${user.id}' />" title="Delete">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<footer>
		<ul>
			<li><a href="#">Privacy Policy</a></li>
			<li><a href="#">Terms of Service</a></li>
			<li><a href="#">Contact Us</a></li>
		</ul>
		<p>&copy; 2024 Users App. All rights reserved.</p>
	</footer>
</body>
</html>