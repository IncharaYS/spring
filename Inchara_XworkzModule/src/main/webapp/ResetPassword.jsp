<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Reset Password</title>

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
                    <a class="nav-link text-white fw-medium py-0" href="loginPage">
                        Login
                    </a>
                </li>
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
    <div class="card shadow-lg rounded-4 p-4 bg-white w-100"
         style="max-width: 420px;">

        <h4 class="text-center mb-4" style="color:#1e3a8a;">
            Reset Password
        </h4>

        <c:if test="${not empty failureMsg}">
            <div class="alert alert-danger text-center">
                ${failureMsg}
            </div>
        </c:if>

        <c:if test="${not empty successMsg}">
            <div class="alert alert-success text-center">
                ${successMsg}
            </div>
        </c:if>

        <form action="resetPassword" method="post">

            <input type="hidden" name="email" value="${email}"/>

            <div class="mb-3">
                <label class="form-label fw-bold">
                    Email
                </label>
                <input type="text"
                       class="form-control"
                       value="${email}"
                       readonly>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">
                    New Password <span class="required">*</span>
                </label>
                <input type="password"
                       id="password"
                       name="password"
                       class="form-control"
                       onkeyup="checkPasswordMatch()">
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">
                    Confirm Password <span class="required">*</span>
                </label>
                <input type="password"
                       id="confirmPassword"
                       name="confirmPassword"
                       class="form-control"
                       onkeyup="checkPasswordMatch()">

                <small id="passwordError" class="text-danger"></small>
            </div>

            <div class="d-grid pt-2">
                <button type="submit"
                        id="resetBtn"
                        class="btn btn-theme px-3 py-2 rounded-3"
                        disabled>
                    Reset Password
                </button>
            </div>

        </form>
    </div>
</div>

<script>
    const passwordInput = document.getElementById("password");
    const confirmPasswordInput = document.getElementById("confirmPassword");
    const errorMsg = document.getElementById("passwordError");
    const submitBtn = document.getElementById("resetBtn");

    function checkPasswordMatch() {
        const password = passwordInput.value;
        const confirmPassword = confirmPasswordInput.value;

        if (confirmPassword.length === 0) {
            errorMsg.innerText = "";
            submitBtn.disabled = true;
            return;
        }

        if (password !== confirmPassword) {
            errorMsg.innerText = "Passwords do not match";
            submitBtn.disabled = true;
        } else {
            errorMsg.innerText = "";
            submitBtn.disabled = false;
        }
    }
</script>

</body>
</html>
