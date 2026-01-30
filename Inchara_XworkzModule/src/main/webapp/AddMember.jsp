<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Member</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

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
    </style>
</head>

<body>

<nav class="navbar navbar-expand-lg shadow-sm"
     style="background-color: #0b3c5d; min-height: 60px;">
    <div class="container-fluid">

        <a class="navbar-brand text-white fw-semibold">
            <img src="images/img_1.png" width="120" height="45">
        </a>

        <ul class="navbar-nav ms-auto gap-3 align-items-center">
            <li class="nav-item"><a class="nav-link text-white" href="homePage">Home</a></li>
            <li class="nav-item"><a class="nav-link text-white" href="viewTeamsPage">View Teams</a></li>
            <li class="nav-item">
                <a class="nav-link text-white" href="profilePage">
                    <i class="bi bi-person-circle fs-4"></i>
                </a>
            </li>
            <li class="nav-item"><a class="nav-link text-white" href="logout">Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container d-flex justify-content-center align-items-center"
     style="min-height: calc(100vh - 60px); padding:40px 0;">

    <div class="card shadow-lg rounded-4 p-4 bg-white w-100"
         style="max-width: 520px;">

        <h4 class="text-center mb-2" style="color:#1e3a8a;">
            Add Member
        </h4>

        <p class="text-center text-muted mb-4">
            Team: <strong>${team.teamName}</strong>
        </p>

        <p class="text-danger text-center">${failureMsg}</p>

        <form action="addMember" method="post">

            <input type="hidden" name="teamId" value="${team.teamId}">

            <div class="mb-3">
                <label class="form-label fw-bold">Member Name</label>
                <input type="text" name="memberName"
                       class="form-control"
                       placeholder="Enter member name"
                       value="${memberDTO.memberName}">
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Member Email</label>
                <input type="text" name="memberEmail"
                       class="form-control"
                       placeholder="Enter member email"
                       value="${memberDTO.memberEmail}">
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Role</label>
                <input type="text" name="role"
                       class="form-control"
                       placeholder="Developer / Tester / Lead"
                       value="${memberDTO.role}">
            </div>

            <div class="d-grid">
                <button class="btn btn-primary">
                    Add Member
                </button>
            </div>

        </form>
    </div>
</div>

</body>
</html>
