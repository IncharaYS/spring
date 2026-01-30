<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Member</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-image: url('images/bg.png');
            background-color: #f2f6ff;
            background-size: cover;
            backdrop-filter: blur(3px);
            font-family: 'Poppins', sans-serif;
        }
    </style>
</head>

<body>

<nav class="navbar navbar-expand-lg shadow-sm"
     style="background-color:#0b3c5d;min-height:60px;">
    <div class="container-fluid">
        <a class="navbar-brand text-white fw-semibold">
            <img src="images/img_1.png" width="120" height="45">
        </a>
        <ul class="navbar-nav ms-auto gap-3">
            <li class="nav-item">
                <a class="nav-link text-white" href="viewTeamDetails?teamId=${member.teamId}">
                    Back
                </a>
            </li>
        </ul>
    </div>
</nav>

<div class="container d-flex justify-content-center align-items-center"
     style="min-height: calc(100vh - 60px);">

    <div class="card shadow-lg rounded-4 p-4 bg-white w-100"
         style="max-width:500px;">

        <h4 class="text-center mb-4" style="color:#1e3a8a;">
            Edit Member
        </h4>

        <form action="updateMember" method="post">

            <input type="hidden" name="memberId" value="${member.memberId}">
            <input type="hidden" name="teamId" value="${member.teamId}">

            <div class="mb-3">
                <label class="form-label fw-bold">Member Name</label>
                <input type="text" name="memberName"
                       class="form-control"
                       value="${member.memberName}">
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Email</label>
                <input type="text" name="memberEmail"
                       class="form-control"
                       value="${member.memberEmail}">
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Role</label>
                <input type="text" name="role"
                       class="form-control"
                       value="${member.role}">
            </div>

            <div class="d-grid">
                <button class="btn btn-primary">
                    Update Member
                </button>
            </div>

        </form>
    </div>
</div>

</body>
</html>
