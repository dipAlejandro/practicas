<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring forms :: Users details</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/styles.css">
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
			<h1>Users Detail</h1>
			<p>See this user info</p>
		</div>

		<c:choose>
			<c:when test="${not empty user}">
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
			</c:when>
			<c:otherwise>
				<div class="alert warning" role="alert">A User with ID
					specified has not been found. Please, try again.</div>
			</c:otherwise>
		</c:choose>
		<h2>Tasks</h2>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allTasks}" var="task">
					<tr>
						<td>${task.name}</td>
						<td>${task.description}</td>
						<td>
							<a class="link-btn info" href="<c:url value='/tasks/${task.id}' />" title="Detailed info">see detail</a>
							<a class="link-btn success" href="<c:url value='/tasks/update/${task.id}' />" title="Update">Update</a>
							<a class="link-btn danger" href="<c:url value='/tasks/delete/${task.id}' />" title="Delete">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<h2>Add new task</h2>
		
		<c:url var="action" value="/tasks/new"></c:url>
		<sf:form method="post" action="${action}" modelAttribute="newTask">
			<div class="form-group">
				<label for="inputName">Name</label>
				<sf:input id="inputName" path="name"/>
			</div>
			<div class="form-group">
				<label for="inputDesc">Description</label>
				<sf:textarea id="inputDesc" path="description"/>
			</div>
			<div class="form-group">
				<input type="submit" class="sf-button success" value="Add" />
			</div>
		</sf:form>
		
	</div>
	<footer></footer>
</body>
</html>
