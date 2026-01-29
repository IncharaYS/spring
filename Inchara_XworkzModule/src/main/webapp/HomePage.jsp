<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>

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

        .card-title {
            color: #1e3a8a;
        }

        .nav-link {
            color: white !important;
        }

        .nav-link:hover {
            text-decoration: underline;
        }

        /* SIDEBAR */
        .sidebar {
            position: fixed;
            top: 60px; /* exactly below navbar */
            left: -260px;
            width: 260px;
            height: calc(100% - 60px);
            background-color: rgba(255, 255, 255, 0.92);
            backdrop-filter: blur(6px);
            box-shadow: 2px 0 12px rgba(0,0,0,0.15);
            transition: left 0.3s ease-in-out;
            z-index: 1040;
            padding: 16px;
        }

        .sidebar.active {
            left: 0;
        }

        .sidebar-header {
            color: #1e3a8a;
        }

        .sidebar .list-group-item {
            background-color: transparent;
            border: none;
            padding-left: 0;
        }

        .sidebar .list-group-item:hover {
            background-color: rgba(37, 99, 235, 0.08);
            border-radius: 6px;
        }
    </style>
</head>

<body>

<nav class="navbar navbar-expand-lg shadow-sm"
     style="background-color: #0b3c5d; min-height: 60px;">
    <div class="container-fluid d-flex align-items-center">

        <button class="btn text-white p-0 me-2"
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
                <span class="nav-link fw-bold">
                    Welcome, ${userName}
                </span>
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

    <div class="sidebar-header d-flex justify-content-between align-items-center">
        <h5 class="mb-0">Dashboard</h5>
        <button class="btn p-0 border-0"
                onclick="toggleSidebar()"
                title="Close">
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
     style="min-height: calc(100vh - 60px); padding: 40px 0;">

    <div class="card shadow-lg rounded-4 p-4 bg-white w-100"
         style="max-width: 720px;">

        <h4 class="card-title text-center mb-4">
            Welcome to X-Workz
        </h4>

        <div class="row g-4">

            <div class="col-md-6">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">
                        <h5 class="card-title">View Profile</h5>
                        <p class="card-text">
                            Check and manage your personal information.
                        </p>
                        <a href="profilePage" class="btn btn-primary">
                            Go to Profile
                        </a>
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">
                        <h5 class="card-title">Reset Password</h5>
                        <p class="card-text">
                            Change your account password securely.
                        </p>
                        <a href="forgotPasswordPage" class="btn btn-primary">
                            Reset Password
                        </a>
                    </div>
                </div>
            </div>

        </div>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>

<script>
    function toggleSidebar() {
        document.getElementById("sidebar").classList.toggle("active");
    }
</script>

</body>
</html>
