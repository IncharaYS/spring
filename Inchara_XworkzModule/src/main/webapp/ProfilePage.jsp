<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>

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
            <img src="images/img_1.png" alt="Logo" width="120" height="45">
        </a>

        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto align-items-center gap-3">

                <li class="nav-item">
                    <span class="nav-link fw-bold">
                        ${userInfo.userName}
                    </span>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="homePage">Home</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="logout">Logout</a>
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
            User Profile
        </h4>



        <form action="updateUser" method="post">

            <div class="mb-3">
                <label class="form-label fw-bold">Name</label>
                <input type="text" name="userName"
                       class="form-control"
                       value="${userInfo.userName}">
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Email</label>
                <input type="text"
                       class="form-control"
                       value="${userInfo.email}"
                       disabled>
                <input value="${userInfo.email}" name="email" hidden>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Phone</label>
                <input type="text"
                       class="form-control"
                       value="${userInfo.phoneNo}" disabled>
                <input value="${userInfo.phoneNo}" name="phoneNo" hidden>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Age</label>
                <input type="number" name="age"
                       class="form-control"
                       value="${userInfo.age}">
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Gender</label>
                <input type="text" name="gender"
                       class="form-control"
                       value="${userInfo.gender}">
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Address</label>
                <textarea name="address"
                          class="form-control"
                          rows="2">${userInfo.address}</textarea>
            </div>

            <div class="d-grid mb-3">
                <button type="submit" class="btn btn-primary">
                    Update Profile
                </button>
            </div>

        </form>


        <form action="deleteUser" method="post"
              onsubmit="return confirm('Are you sure you want to delete your account?');">

            <div class="d-grid">
                <button type="submit" class="btn btn-danger">
                    Delete Account
                </button>
            </div>

        </form>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>

</body>
</html>
