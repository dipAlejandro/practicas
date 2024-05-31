<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring forms :: New user created</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
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
			<h1>User updated</h1>
		</div>
		<div class="alert alert-success" role="alert">The following user
			has been updated successfully.</div>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Login</th>
					<th>Description</th>
					<th>Password</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${user.id}</td>
					<td>${user.login}</td>
					<td>${user.description}</td>
					<td>${user.password}</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>
