<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inchara | Xworkz Modules</title>

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
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        .navbar {
    padding-top: 0.25rem !important;
    padding-bottom: 0.25rem !important;
        }


        .content-wrapper {
            flex: 1;
        }

        .welcome-card {
            background: rgba(255, 255, 255, 0.95);
            border-radius: 1.5rem;
        }

        footer {
            background-color: #0ea5e9;
            color: white;
            font-size: 0.95rem;
        }

        footer a {
            color: #eaf6ff;
            text-decoration: none;
        }

        footer a:hover {
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
                 height="45"
                 class="d-inline-block align-text-top">
        </a>

        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto align-items-center">
                <li class="nav-item">
                    <a class="nav-link text-white fw-medium py-0" href="loginPage">
                        Login
                    </a>
                </li>
            </ul>
        </div>

    </div>
</nav>




<div class="content-wrapper">
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="card shadow-lg p-4 text-center welcome-card"
             style="max-width: 480px; width: 100%;">
            <h1 class="mb-3 fw-bold">Welcome</h1>
            <h4 class="mb-3 text-muted">

            </h4>


            <a href="registerPage"
               class="btn  btn-lg px-5 py-3 rounded-3" style="background-color:#1d4ed8; color:white;">
                Register Now
            </a>
        </div>
    </div>
</div>


<footer class="py-3">
    <div class="container text-center">
        <div class="mb-1">
            © 2026 User management module. All Rights Reserved.
        </div>
        <div>
            <a href="#">Privacy Policy</a> |
            <a href="#">Terms & Conditions</a> |
            <a href="#">Contact Us</a>
        </div>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>

</body>
</html>
