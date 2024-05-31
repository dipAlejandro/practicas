<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring forms :: Users details</title>
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
</div>
<footer></footer>
</body>
</html>
