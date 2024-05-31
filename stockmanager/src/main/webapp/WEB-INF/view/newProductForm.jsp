<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
    crossorigin="anonymous">
<title>Empresa :: Stock manager - Add new Product</title>
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
                            <li class="nav-item"><a class="nav-link active" href="#">Add
                                    new Product</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <section class="text-bg-primary p-5 rounded mb-4">
            <h2 class="text-center">Add new product</h2>
        </section>
        <section class="my-4">
            <c:if test="${not empty message}">
                <div class="alert ${alertClass} alert-dismissible fade show"
                    role="alert">
                    ${message}
                    <button type="button" class="btn btn-close" data-bs-dismiss="alert"
                        aria-label="Close"></button>
                </div>
            </c:if>
            <c:url var="action" value="/products/new/"></c:url>
            <sf:form method="post" action="${action}" modelAttribute="product">

                <div class="mb-3">
                    <label for="nameInput" class="form-label">Name</label>
                    <sf:input id="nameInput" path="name" placeholder="Product name"
                        class="form-control" />
                </div>

                <div class="mb-3">
                    <label for="sectionInput" class="form-label">Section</label>
                    <sf:select path="section" id="sectionInput" class="form-section">
                        <sf:options items="${sections}" />
                    </sf:select>
                </div>

                <div class="mb-3">
                    <label for="priceInput" class="form-label">Price</label>
                    <sf:input id="priceInput" path="price" type="number"
                        placeholder="Product price" class="form-control" />
                </div>

                <div class="mb-3">
                    <label for="descriptionInput" class="form-label"></label>
                    <sf:textarea id="descriptionInput" path="description"
                        placeholder="Product description" class="form-control" />
                </div>

                <div class="mb-3">
                    <input type="submit" class="btn btn-success" value="Add" />
                    <input type="reset" class="btn btn-danger" value="Reset">
                </div>

            </sf:form>
        </section>
    </div>
    
    <!-- Scripts de Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" 
            integrity="sha384-oBqDVmMz4fnFO9gyb2vF1Ld1er/uHP73lZWIVr9872Az8mIFIHLY3hA4hlhgi2H" 
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" 
            integrity="sha384-cu9UFY1kj41/8C7dOcZjlBDj10uFXL9GFP5bbGZfTq4QQuB8KA3LpYZyVpXhExIu" 
            crossorigin="anonymous"></script>
</body>
</html>
