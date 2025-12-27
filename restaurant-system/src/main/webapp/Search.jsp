<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Index Page</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

    <style>
        body {
            background: linear-gradient(135deg, #eef3fb, #ffffff);
        }

        .navbar {
            background: rgba(44, 82, 130, 0.9); /* light navy */
            backdrop-filter: blur(6px);
        }

        .navbar .nav-link {
            color: #ffffff !important;
        }

        .navbar-brand {
            color: #ffffff !important;
        }

        .card {
            background-color: #f7faff;
        }

        .card h1 {
            color: #2c5282; /* soft navy */
        }

        .card h5 {
            color: #4a6fa5; /* lighter navy */
        }

        .btn-danger{
            background-color: #2c5282;
            border-color: #2c5282;
        }

        .btn-danger:hover {
            background-color: #4a6fa5;
            border-color: #4a6fa5;
        }

        strong,h3{
        color:#2c5282;
    </style>



</head>
<body>

<nav class="navbar navbar-expand-lg p-1">
    <div class="container-fluid">
        <a class="navbar-brand fs-3">Zapp</a>

        <div class="collapse navbar-collapse" id="nav">
            <ul class="navbar-nav ms-auto fs-5">
                <li class="nav-item"><a class="nav-link" href="index">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="registerpage">Register</a></li>
                <li class="nav-item"><a class="nav-link" href="search">Search</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg rounded-4 p-4  w-75" style="max-width: 600px;">

        <form action="search">
        <div class="">
            <label class="form-label fw-bold">Enter Restaurant Name:<span class="required">*</span></label>
            <input type="text" name="name" class="form-control"
                   placeholder="Enter restaurant name" >
        </div>
            <br>
            <div class="d-flex align-items-center justify-content-center">
                <input type="submit" value="Search"
                       class="btn btn-danger btn-lg px-5 py-3 rounded-3">
            </div>

        </form>
        <br>

        <c:if test="${not empty restaurant}">
            <h3>Restaurant details are:</h3> <br>
            <ul style="list-style-type: none;">
                <li><strong>Restaurant Name :</strong> ${restaurant.name}</li>
                <li><strong>Owner Name :</strong> ${restaurant.owner}</li>
                <li><strong>Contact Number :</strong> ${restaurant.contactNumber}</li>
                <li><strong>Address :</strong> ${restaurant.address}</li>
                <li><strong>Email :</strong> ${restaurant.contactEmail}</li>
                <li><strong>Type :</strong> ${restaurant.type}</li>
                <li><strong>Rating :</strong> ${restaurant.rating}</li>
                <li><strong>Established Year :</strong> ${restaurant.establishedYear}</li>
                <li><strong>Opening Time :</strong> ${restaurant.openingTime}</li>
                <li><strong>Closing Time :</strong> ${restaurant.closingTime}</li>
            </ul>
        </c:if>




        <h4 style="color:red;">${restaurantNotFound}</h4>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>
</body>
</html>
