<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Home</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-image: url('images/bg.png');
            background-color: #f2f6ff;
            background-repeat: no-repeat;
            background-size: cover;
            background-position: center;
            backdrop-filter: blur(3px);
            font-family: 'Poppins', sans-serif;
        }

        .card-title {
            color: #1e3a8a;
        }

        .nav-link {
            color: white !important;
        }

        .nav-link:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>


<nav class="navbar navbar-expand-lg px-3 shadow-sm"
     style="background-color: #0b3c5d; min-height: 60px;">
    <div class="container-fluid">

        <a class="navbar-brand d-flex align-items-center gap-2 text-white fw-semibold p-0">
            <img src="images/img_1.png"
                 alt="Logo"
                 width="120"
                 height="45">
        </a>

        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto align-items-center gap-3">
                <li class="nav-item">
                    <span class="nav-link fw-bold">
                        Welcome, ${userName}
                    </span>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="loginPage">Login</a>
                </li>
            </ul>
        </div>

    </div>
</nav>

<div class="container d-flex justify-content-center align-items-center"
     style="min-height: calc(100vh - 60px); padding-top: 40px; padding-bottom: 40px;">

    <div class="card shadow-lg rounded-4 p-4 bg-white w-100"
         style="max-width: 520px;">

        <h5 class="text-center text-success mb-3">${successMsg}</h5>
        <h5 class="text-center text-danger mb-3">${failureMsg}</h5>


        <h4 class="card-title text-center mb-4">
            User Information:
        </h4>

        <hr>


        <c:if test="${userInfo != null}">
            <div class="px-3">
                <p><strong>Name:</strong> ${userInfo.userName}</p>
                <p><strong>Email:</strong> ${userInfo.email}</p>
                <p><strong>Phone:</strong> ${userInfo.phoneNo}</p>
                <p><strong>Age:</strong> ${userInfo.age}</p>
                <p><strong>Gender:</strong> ${userInfo.gender}</p>
                <p><strong>Address:</strong> ${userInfo.address}</p>
            </div>
        </c:if>



    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>

</body>
</html>
