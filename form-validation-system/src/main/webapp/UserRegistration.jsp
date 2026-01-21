<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>

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
    </style>
</head>

<body>

<nav class="navbar navbar-expand-lg px-3 shadow-sm"
     style="background-color: #0b3c5d; min-height: 60px;">
    <div class="container-fluid">
        <a class="navbar-brand text-white fw-semibold">
            <img src="images/img_1.png" width="120" height="45" alt="Logo">
        </a>
    </div>
</nav>

<div class="container d-flex justify-content-center align-items-center"
     style="min-height: calc(100vh - 60px); padding:40px 0;">

    <div class="card shadow-lg rounded-4 p-4 bg-white w-100"
         style="max-width: 520px;">

        <h3 class="text-center mb-4" style="color:#1e3a8a;">
            User Registration
        </h3>

        <!-- GLOBAL MESSAGE -->
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

        <form action="registerUser" method="post">

            <!-- USER NAME -->
            <div class="mb-3">
                <label class="form-label fw-bold">
                    Name <span class="required">*</span>
                </label>
                <input type="text" name="userName"
                       class="form-control"
                       value="${dto.userName}">
                <small class="text-danger">${invaliduserName}</small>
            </div>

            <!-- EMAIL -->
            <div class="mb-3">
                <label class="form-label fw-bold">
                    Email <span class="required">*</span>
                </label>
                <input type="text" name="email"
                       class="form-control"
                       value="${dto.email}">
                <small class="text-danger">${invalidemail}</small>
                <small class="text-danger">${duplicateError}</small>
            </div>

            <!-- PHONE -->
            <div class="mb-3">
                <label class="form-label fw-bold">
                    Phone Number <span class="required">*</span>
                </label>
                <input type="text" name="phoneNo"
                       class="form-control"
                       value="${dto.phoneNo}">
                <small class="text-danger">${invalidphoneNo}</small>
            </div>

            <!-- AGE -->
            <div class="mb-3">
                <label class="form-label fw-bold">
                    Age
                </label>
                <input type="number" name="age"
                       class="form-control"
                       value="${dto.age}">
                <small class="text-danger">${invalidage}</small>
            </div>

            <!-- GENDER -->
            <div class="mb-3">
                <label class="form-label fw-bold">
                    Gender <span class="required">*</span>
                </label>
                <select name="gender" class="form-select">
                    <option value="">Select</option>
                    <option value="Male" ${dto.gender=='Male'?'selected':''} >Male</option>
                    <option value="Female" ${dto.gender=='Female'?'selected':''} >Female</option>
                    <option value="Other" ${dto.gender=='Other'?'selected':''} >Other</option>
                </select>
                <small class="text-danger">${invalidgender}</small>
            </div>

            <!-- ADDRESS -->
            <div class="mb-3">
                <label class="form-label fw-bold">
                    Address <span class="required">*</span>
                </label>
                <textarea name="address"
                          class="form-control"
                          rows="2">${dto.address}</textarea>
                <small class="text-danger">${invalidaddress}</small>
            </div>

            <!-- PASSWORD -->
            <div class="mb-3">
                <label class="form-label fw-bold">
                    Password <span class="required">*</span>
                </label>
                <input type="password" name="password"
                       class="form-control">
                <small class="text-danger">${invalidpassword}</small>
            </div>

            <!-- CONFIRM PASSWORD -->
            <div class="mb-3">
                <label class="form-label fw-bold">
                    Confirm Password <span class="required">*</span>
                </label>
                <input type="password" name="confirmPassword"
                       class="form-control">
                <small class="text-danger">${passwordMismatch}</small>
            </div>

            <!-- SUBMIT -->
            <div class="text-center mt-4">
                <button type="submit" class="btn btn-primary px-5">
                    Register
                </button>
            </div>

        </form>
    </div>
</div>

</body>
</html>
