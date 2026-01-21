<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>User Login</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">



    <style>
        body {
            background-color: #f2f6ff;
            background-repeat: no-repeat;
            background-size: cover;
            background-position: center;
            backdrop-filter: blur(3px);
            font-family: 'Poppins', sans-serif;
        }

        .form-label { color: #1e3a8a; }
        .required { color: red; }

        .btn-theme {
            background-color: #2563eb;
            color: white;
        }
        .btn-theme:hover {
            background-color: #1d4ed8;
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
            <ul class="navbar-nav ms-auto align-items-center">
                <li class="nav-item">
                    <a class="nav-link text-white fw-medium py-0" href="registerPage">
                        Register
                    </a>
                </li>
            </ul>
        </div>

    </div>
</nav>

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg rounded-4 p-4 bg-white w-100" style="max-width: 420px;">

        <h4 class="text-center mb-4" style="color:#1e3a8a;">Login</h4>

        <form action="login" method="post" onsubmit="return validateLoginAll()">



            <div class="mb-3">
                <label for="email" class="form-label fw-bold">
                    Email <span class="required">*</span>
                </label>
                <input type="text" id="email" name="email"
                       class="form-control"
                       placeholder="Enter your email"
                       value="${userInfo.email}"
                       oninput="validateLoginEmail(this)">
                <small id="emailMsg" class="text-danger"></small>
                <span style="color:red">${emailError}</span>

            </div>

            <div class="mb-3">
                <label for="password" class="form-label fw-bold">
                    Password <span class="required">*</span>
                </label>
                <input type="password"
                       id="password"
                       name="password"
                       class="form-control"
                       placeholder="Enter your password"
                       oninput="validateLoginPassword(this)">

                <small id="passwordMsg" class="text-danger"></small>

            </div>




            <h6 class="text-danger d-block mb-2">${failureMsg}</h6>

            <c:if test="${triesLeft!=null}">
                <h6 class="text-danger">${passwordError} Tries left: ${triesLeft}</h6>
            </c:if>

            <div class="text-center mt-3">
                <button type="submit"
                        class="btn btn-theme px-4 py-2 rounded-3"
                <c:if test="${enableOtp}">disabled</c:if>>
                Login
                </button>
            </div>
            <br>

            <c:if test="${enableOtp}">
                <small class="text-danger" >Too many failed attempts. Verify with OTP to continue.</small>
                <a href="resetPasswordPage">Send Otp</a>
            </c:if>

        </form>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="${pageContext.request.contextPath}/js/user_login.js"></script>
</body>
</html>
