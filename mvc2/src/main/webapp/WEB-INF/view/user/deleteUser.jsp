<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/styles.css">
<title>Spring forms :: delete user</title>
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
			<h1>User deleted</h1>
		</div>
		<div class="alert alert-success" role="alert">The user ${userId}
			has been removed successfully.</div>
	</div>

</body>
</html>