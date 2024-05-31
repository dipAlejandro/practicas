<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring forms :: add new user</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
    <nav>
        <a href="#" class="brand">Users App</a>
        <ul>
            <li><a href="<c:url value="/users" />" title="View Users">View
                    users</a></li>
            <li><a href="#" title="New User">New User</a></li>
        </ul>
    </nav>
    <div class="container">
        <div class="jumbotron">
            <h1>New user</h1>
            <p>See this user info</p>
        </div>

        <sf:form method="POST" modelAttribute="user" action="${pageContext.request.contextPath}/users/new">

            <div class="form-group">
                <label for="login">Login</label>
                <sf:input path="login" class="sf-input" placeholder="Login" />
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <sf:password path="password" class="sf-password"
                    placeholder="Password" />
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <sf:input path="description" class="sf-input"
                    placeholder="Description" />
            </div>
            <div class="form-group">
                <button type="submit" class="sf-button success">Submit</button>
            </div>

        </sf:form>
    </div>
    <footer>
        <p>&copy; 2024 Users App. All rights reserved.</p>
        <p>Contact: info@usersapp.com</p>
    </footer>
</body>
</html>
