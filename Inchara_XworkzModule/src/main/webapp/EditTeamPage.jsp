<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Team</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

    <style>
        body {
            background-color: #f2f6ff;
            backdrop-filter: blur(3px);
            font-family: 'Poppins', sans-serif;
        }

        .card-title { color: #1e3a8a; }

        .nav-link {
            color: white !important;
        }

        .nav-link:hover {
            text-decoration: underline;
        }

        /* SIDEBAR */
        .sidebar {
            position: fixed;
            top: 60px;
            left: -280px;
            width: 280px;
            height: calc(100% - 60px);
            background-color: rgba(255,255,255,0.95);
            box-shadow: 2px 0 12px rgba(0,0,0,0.25);
            transition: left 0.3s ease-in-out;
            z-index: 1050;
            padding: 15px;
        }

        .sidebar.active {
            left: 0;
        }
    </style>
</head>

<body>

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg shadow-sm"
     style="background-color: #0b3c5d; min-height: 60px;">
    <div class="container-fluid d-flex align-items-center">

        <!-- DASHBOARD BUTTON -->
        <button class="btn text-white p-0 me-3"
                type="button"
                onclick="toggleSidebar()"
                style="font-size: 1.6rem;">
            <i class="bi bi-list"></i>
        </button>

        <!-- LOGO -->
        <a class="navbar-brand d-flex align-items-center text-white fw-semibold p-0">
            <img src="images/img_1.png" width="120" height="45">
        </a>

        <!-- RIGHT NAV -->
        <ul class="navbar-nav ms-auto align-items-center gap-3">
            <li class="nav-item">
                <a class="nav-link" href="homePage">Home</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="viewTeamsPage">View Teams</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<!-- SIDEBAR -->
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

<!-- CONTENT -->
<div class="container d-flex justify-content-center align-items-center"
     style="min-height: calc(100vh - 60px); padding:40px 0;">

    <div class="card shadow-lg rounded-4 p-4 bg-white w-100"
         style="max-width: 520px;">

        <h4 class="text-center mb-4 card-title">Edit Team</h4>

        <!-- UPDATE FORM -->
        <form action="updateTeam" method="post"
              onsubmit="return validateAllTeam()">

            <input type="hidden" name="teamId" value="${teamDTO.teamId}">

            <div class="mb-3">
                <label class="form-label fw-bold">Team Name</label>
                <input type="text" id="teamName" name="teamName"
                       class="form-control"
                       value="${teamDTO.teamName}"
                       oninput="validateTeamName(this)">
                <small id="teamNameMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Team Lead</label>
                <input type="text" id="teamLead" name="teamLead"
                       class="form-control"
                       value="${teamDTO.teamLead}"
                       oninput="validateTeamLead(this)">
                <small id="teamLeadMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Project Name</label>
                <input type="text" id="projectName" name="projectName"
                       class="form-control"
                       value="${teamDTO.projectName}"
                       oninput="validateProjectName(this)">
                <small id="projectMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Department</label>
                <input type="text" id="department" name="department"
                       class="form-control"
                       value="${teamDTO.department}"
                       oninput="validateDepartment(this)">
                <small id="departmentMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Contact Email</label>
                <input type="text" id="contactEmail" name="contactEmail"
                       class="form-control"
                       value="${teamDTO.contactEmail}"
                       readonly>
                <small id="emailMsg" class="text-danger"></small>
            </div>

            <div class="d-grid">
                <button class="btn btn-primary">
                    Update Team
                </button>
            </div>

        </form>

        <!-- DELETE FORM -->
        <form action="deleteTeam" method="get"
              onsubmit="return confirm('Are you sure you want to permanently delete this team?');">

            <input type="hidden" name="id" value="${teamDTO.teamId}">

            <div class="d-grid mt-3">
                <button class="btn btn-danger">
                    <i class="bi bi-trash"></i> Delete Team
                </button>
            </div>
        </form>

    </div>
</div>

<script src="${pageContext.request.contextPath}/js/update_team.js"></script>

<script>
    function toggleSidebar() {
        document.getElementById("sidebar").classList.toggle("active");
    }
</script>

</body>
</html>
