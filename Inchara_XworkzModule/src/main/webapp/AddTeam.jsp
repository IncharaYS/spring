<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Team</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="js/team_registration.js"></script>

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

        /* SIDEBAR */
        .sidebar {
            position: fixed;
            top: 60px;
            left: -280px;
            width: 280px;
            height: calc(100% - 60px);
            background-color: rgba(255,255,255,0.92);
            box-shadow: 2px 0 10px rgba(0,0,0,0.15);
            transition: left 0.3s ease-in-out;
            z-index: 1050;
            padding: 15px;
        }

        .navbar .nav-link,
        .navbar .nav-link:visited,
        .navbar .nav-link:focus {
            color: #ffffff !important;
        }

        .navbar .nav-link:hover {
            color: #ffffff !important;
            text-decoration: underline;
        }


        .sidebar.active {
            left: 0;
        }
    </style>
</head>

<body>

<nav class="navbar navbar-expand-lg shadow-sm"
     style="background-color: #0b3c5d; min-height: 60px;">
    <div class="container-fluid d-flex align-items-center">

        <button class="btn text-white p-0 me-3"
                type="button"
                onclick="toggleSidebar()"
                style="font-size: 1.6rem;">
            <i class="bi bi-list"></i>
        </button>

        <a class="navbar-brand d-flex align-items-center text-white fw-semibold p-0">
            <img src="images/img_1.png" width="120" height="45">
        </a>

        <ul class="navbar-nav ms-auto align-items-center gap-3">

            <li class="nav-item">
                <a class="nav-link d-flex align-items-center" href="homePage">
                    Home
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link d-flex align-items-center" href="viewTeamsPage">
                    View Teams
                </a>
            </li>

            <li class="nav-item d-flex align-items-center">
                <a class="nav-link p-0 d-flex align-items-center justify-content-center"
                   href="profilePage"
                   title="Profile"
                   style="height:40px;width:40px;">
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

<div id="sidebar" class="sidebar">

    <div class="d-flex justify-content-between align-items-center mb-2">
        <h5 class="mb-0">Dashboard</h5>
        <button class="btn p-0 border-0" onclick="toggleSidebar()">
            <i class="bi bi-x-lg fs-5"></i>
        </button>
    </div>

    <hr>

    <div class="list-group list-group-flush">
        <a href="addTeamPage" class="list-group-item list-group-item-action">
            Add Team
        </a>
        <a href="viewTeamsPage" class="list-group-item list-group-item-action">
            View Teams
        </a>
    </div>
</div>

<div class="container d-flex justify-content-center align-items-center"
     style="min-height: calc(100vh - 60px); padding:40px 0;">

    <div class="card shadow-lg rounded-4 p-4 bg-white w-100"
         style="max-width: 520px;">

        <h3 class="text-center mb-4" style="color:#1e3a8a;">Add Team</h3>

        <span class="text-success">${successMsg}</span>
        <span class="text-danger">${failureMsg}</span>

        <br>

        <form action="addTeam" method="post" onsubmit="return validateAllTeam()">

            <div class="mb-3">
                <label class="form-label fw-bold">
                    Team Name <span class="required">*</span>
                </label>
                <input type="text" id="teamName" name="teamName"
                       class="form-control"
                       placeholder="Enter team name"
                       value="${dto.teamName}"
                       oninput="validateTeamName(this)">
                <small id="teamNameMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">
                    Team Lead <span class="required">*</span>
                </label>
                <input type="text" id="teamLead" name="teamLead"
                       class="form-control"
                       placeholder="Enter team lead name"
                       value="${dto.teamLead}"
                       oninput="validateTeamLead(this)">
                <small id="teamLeadMsg" class="text-danger"></small>
            </div>


            <div class="mb-3">
                <label class="form-label fw-bold">
                    Project Name <span class="required">*</span>
                </label>
                <input type="text" id="projectName" name="projectName"
                       class="form-control"
                       placeholder="Enter project name"
                       value="${dto.projectName}"
                       oninput="validateProjectName(this)">
                <small id="projectMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">
                    Department <span class="required">*</span>
                </label>
                <input type="text" id="department" name="department"
                       class="form-control"
                       placeholder="Enter department name"
                       value="${dto.department}"
                       oninput="validateDepartment(this)">
                <small id="departmentMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">
                    Contact Email <span class="required">*</span>
                </label>
                <input type="text" id="contactEmail" name="contactEmail"
                       class="form-control"
                       placeholder="Enter team contact email"
                       value="${dto.contactEmail}"
                       onblur="validateTeamEmail(this)">
                <small id="emailMsg" class="text-danger"></small>
            </div>

            <div class="text-center mt-4">
                <button type="submit" class="btn btn-primary px-5">
                    Add Team
                </button>
            </div>

        </form>
    </div>
</div>

<script>
    function toggleSidebar() {
        document.getElementById("sidebar").classList.toggle("active");
    }
</script>

</body>
</html>
