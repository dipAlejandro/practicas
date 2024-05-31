<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/styles.css">
<title>Spring forms :: update user</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Update User</h1>
		</div>

		<c:url var="action" value="/users/saveupdate" />
		<sf:form method="post" modelAttribute="user" action="${action}">

			<sf:hidden path="id" />
			<div class="form-group">
				<label for="login">Login</label>
				<sf:input path="login" placeholder="Login" class="sf-input" />
			</div>
			<div class="form-group">
				<label for="password">Password</label>
				<sf:password path="password" placeholder="Password"
					class="sf-password" />
			</div>
			<div class="form-group">
				<label for="description">Description</label>
				<sf:input path="description" placeholder="Description"
					class="sf-input" />
			</div>
			<div class="form-group">
				<sf:button class="sf-button success">Update</sf:button>
			</div>

		</sf:form>
	</div>
</body>
</html>