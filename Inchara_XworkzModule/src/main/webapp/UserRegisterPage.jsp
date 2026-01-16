<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="js/user_registration.js"></script>

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

        .form-label { color: #1e3a8a; }
        .required { color: red; }
    </style>
</head>

<body>

<nav class="navbar navbar-expand-lg px-3 shadow-sm"
     style="background-color: #0b3c5d; min-height: 60px;">
    <div class="container-fluid">
        <a class="navbar-brand text-white fw-semibold">
            User Management
        </a>
        <ul class="navbar-nav ms-auto">
            <li class="nav-item">
                <a class="nav-link text-white" href="loginPage">Login</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container d-flex justify-content-center align-items-center"
     style="min-height: calc(100vh - 60px); padding:40px 0;">

    <div class="card shadow-lg rounded-4 p-4 bg-white w-100"
         style="max-width: 520px;">

        <h3 class="text-center mb-4" style="color:#1e3a8a;">User Registration</h3>

        <form action="register" method="post" onsubmit="return validateAll()">

            <div class="mb-3">
                <label for="userName" class="form-label fw-bold">
                    Name <span class="required">*</span>
                </label>
                <input type="text" id="userName" name="userName"
                       class="form-control"
                       placeholder="Enter your name"
                       value="${dto.userName}"
                       oninput="validateUserName(this)">
                <small id="userNameMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label for="email" class="form-label fw-bold">
                    Email <span class="required">*</span>
                    <small id="dupEmailMsg" class="text-danger">${dupEmail}</small>
                </label>
                <input type="text" id="email" name="email"
                       class="form-control"
                       placeholder="Enter your email"
                       value="${dto.email}"
                       oninput="validateEmail(this)">
                <small id="emailMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label for="phoneNo" class="form-label fw-bold">
                    Phone Number <span class="required">*</span>
                </label>
                <input type="text" id="phoneNo" name="phoneNo"
                       class="form-control"
                       placeholder="Enter 10-digit phone number"
                       value="${dto.phoneNo}"
                       oninput="validatePhoneNo(this)">
                <small id="phoneNoMsg" class="text-danger"></small>
            </div>


            <div class="mb-3">
                <label for="age" class="form-label fw-bold">Age</label>
                <input type="number" id="age" name="age"
                       class="form-control"
                       value="${dto.age}"
                       oninput="validateAge(this)">
                <small id="ageMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label for="gender" class="form-label fw-bold">
                    Gender <span class="required">*</span>
                </label>
                <select id="gender" name="gender"
                        class="form-select"
                        oninput="validateGender(this)">
                    <option value="">Select</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                </select>
                <small id="genderMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label for="address" class="form-label fw-bold">
                    Address <span class="required">*</span>
                </label>
                <textarea id="address" name="address"
                          class="form-control"
                          rows="2"
                          oninput="validateAddress(this)">${dto.address}</textarea>
                <small id="addressMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label for="password" class="form-label fw-bold">
                    Password <span class="required">*</span>
                </label>
                <input type="password" id="password" name="password"
                       class="form-control"
                       oninput="validatePassword(this)">
                <small id="passwordMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label for="confirmPassword" class="form-label fw-bold">
                    Confirm Password <span class="required">*</span>
                </label>
                <input type="password" id="confirmPassword"
                       name="confirmPassword"
                       class="form-control"
                       oninput="validateConfirmPassword(this)">
                <small id="confirmPasswordMsg" class="text-danger"></small>
            </div>

            <div class="text-center mt-4">
                <button type="submit" class="btn btn-primary px-5">
                    Register
                </button>
            </div>


            <small class="text-danger d-block mb-2">${invalidField}</small>

        </form>
    </div>
</div>

</body>
</html>
