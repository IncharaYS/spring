<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Update Profile</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

    <style>
        body {
            background-color: #f2f6ff;
            background-repeat: no-repeat;
            background-size: cover;
            background-position: center;
            backdrop-filter: blur(3px);
            font-family: 'Poppins', sans-serif;
        }
        .card-title { color: #1e3a8a; }
        .nav-link { color: white !important; }
        .nav-link:hover { text-decoration: underline; }
    </style>
</head>

<body>

<nav class="navbar navbar-expand-lg px-3 shadow-sm"
     style="background-color: #0b3c5d; min-height: 60px;">
    <div class="container-fluid">
        <a class="navbar-brand text-white fw-semibold">
            <img src="images/img_1.png" width="120" height="45">
        </a>
        <ul class="navbar-nav ms-auto align-items-center gap-3">

            <li class="nav-item">
                <a class="nav-link d-flex align-items-center" href="homePage">
                    Home
                </a>
            </li>

            <li class="nav-item d-flex align-items-center">
                <a class="nav-link p-0 d-flex align-items-center justify-content-center"
                   href="profilePage"
                   title="Profile"
                   style="height:40px; width:40px;">
                    <i class="bi bi-person-circle fs-3"></i>
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link d-flex align-items-center" href="logout">
                    Logout
                </a>
            </li>

        </ul>

    </div>
</nav>

<div class="container d-flex justify-content-center align-items-center"
     style="min-height: calc(100vh - 60px); padding:40px 0;">

    <div class="card shadow-lg rounded-4 p-4 bg-white w-100"
         style="max-width: 520px;">

        <h4 class="text-center mb-4 card-title">Update Profile</h4>

        <form action="updateUser" method="post"
              onsubmit="return validateUpdateProfile()">

            <input type="hidden" id="oldEmail" value="${userInfo.email}">
            <input type="hidden" id="oldPhone" value="${userInfo.phoneNo}">

            <div class="mb-3">
                <label class="form-label fw-bold">Name</label>
                <input type="text" id="userName" name="userName"
                       class="form-control"
                       value="${userInfo.userName}"
                       oninput="validateUserName(this)">
                <small id="userNameMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Email</label>
                <input type="text" id="email" name="email"
                       class="form-control"
                       value="${userInfo.email}"
                       onblur="validateEmail(this)">
                <small id="emailMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Phone</label>
                <input type="text" id="phoneNo" name="phoneNo"
                       class="form-control"
                       value="${userInfo.phoneNo}"
                       onblur="validatePhoneNo(this)">
                <small id="phoneNoMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Age</label>
                <input type="number" id="age" name="age"
                       class="form-control"
                       value="${userInfo.age}"
                       oninput="validateAge(this)">
                <small id="ageMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Gender</label>
                <select id="gender" name="gender"
                        class="form-select"
                        onchange="validateGender(this)">
                    <option value="">Select</option>
                    <option value="Male"<c:if test="${userInfo.gender=='Male'}">selected</c:if>>Male</option>
                    <option value="Female"<c:if test="${userInfo.gender=='Female'}">selected</c:if>>Female</option>
                    <option value="Other"<c:if test="${userInfo.gender=='Other'}">selected</c:if>>Other</option>
                </select>
                <small id="genderMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Address</label>
                <textarea id="address" name="address"
                          class="form-control"
                          rows="2"
                          oninput="validateAddress(this)">${userInfo.address}</textarea>
                <small id="addressMsg" class="text-danger"></small>
            </div>

            <div class="d-grid">
                <button class="btn btn-primary">
                    Update Profile
                </button>
            </div>
        </form>

        <form action="deleteUser" method="post" class="mt-3"
              onsubmit="return confirm('Are you sure you want to permanently delete your account?');">
            <button class="btn btn-danger w-100">
                Delete Profile
            </button>
        </form>

    </div>
</div>

<script src="${pageContext.request.contextPath}/js/update_user.js"></script>

</body>
</html>
