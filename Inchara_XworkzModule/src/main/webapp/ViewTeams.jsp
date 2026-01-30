<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Teams</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

    <style>
        body {
            background-image: url('images/bg.png');
            background-color: #d1dbea; /* darker page background */
            background-repeat: no-repeat;
            background-size: cover;
            background-position: center;
            backdrop-filter: blur(3px);
            font-family: 'Poppins', sans-serif;
        }

        .nav-link {
            color: #ffffff !important;
            font-weight: 500;
        }

        .nav-link:hover {
            text-decoration: underline;
        }


        .sidebar {
            position: fixed;
            top: 60px;
            left: -280px;
            width: 280px;
            height: calc(100% - 60px);
            background-color: rgba(255, 255, 255, 0.96);
            box-shadow: 4px 0 18px rgba(0, 0, 0, 0.25);
            transition: left 0.3s ease-in-out;
            z-index: 1050;
            padding: 15px;
        }

        .sidebar.active {
            left: 0;
        }

        .card-title {
            color: #06263d;
            font-weight: 700;
        }

        .team-card {
            position: relative;

            background: linear-gradient(
                180deg,
                #e1e9f5 0%,
                #cfdaf0 100%
            );

            border-radius: 1.2rem;

            /* STRONG BORDER */
            border: 3px solid #0b3c5d;

            /* HEAVY SHADOW */
            box-shadow:
                0 22px 48px rgba(0, 0, 0, 0.35),
                0 10px 22px rgba(0, 0, 0, 0.28);

            transition: transform 0.25s ease,
                        box-shadow 0.25s ease;
        }

        /* LEFT ACCENT STRIP */
        .team-card::before {
            content: "";
            position: absolute;
            left: 0;
            top: 0;
            width: 4px;
            height: 100%;
            background: linear-gradient(
                180deg,
                #06263d,
                #0b3c5d
            );
            border-radius: 1.2rem 0 0 1.2rem;
        }

        /* HOVER EFFECT */
        .team-card:hover {
            transform: translateY(-12px);
            box-shadow:
                0 36px 70px rgba(0, 0, 0, 0.45),
                0 18px 36px rgba(0, 0, 0, 0.35);
        }


        .team-card .card-body {
            padding: 1.6rem;
        }

        .team-card .card-title {
            color: #06263d;
            letter-spacing: 0.5px;
        }

        .team-card p,
        .team-card strong {
            color: #0a2540;
        }

        .team-card .btn {
            border-radius: 0.6rem;
            font-weight: 500;
        }


        .alert {
            border-radius: 0.75rem;
            font-weight: 500;
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
                <a class="nav-link" href="homePage">Home</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="addTeamPage">Add Team</a>
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
                <a class="nav-link" href="logout">Logout</a>
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

<div class="container"
     style="min-height: calc(100vh - 60px); padding:40px 0;">

    <div class="card shadow-lg rounded-4 p-4 bg-white">

        <h3 class="card-title text-center mb-4">All Teams</h3>

        <c:if test="${not empty successMsg}">
            <div class="alert alert-success text-center">${successMsg}</div>
        </c:if>

        <c:if test="${not empty failureMsg}">
            <div class="alert alert-danger text-center">${failureMsg}</div>
        </c:if>

        <c:if test="${empty teams}">
            <p class="text-center text-muted">No teams available</p>
        </c:if>

        <c:if test="${not empty teams}">
            <div class="row g-4">

                <c:forEach items="${teams}" var="team">
                    <div class="col-md-6 col-lg-4">

                        <div class="card team-card shadow-sm h-100 rounded-4 border-0">
                            <div class="card-body d-flex flex-column">

                                <h5 class="card-title text-center fw-bold mb-3">
                                    ${team.teamName}
                                </h5>

                                <p class="mb-1">
                                    <strong>Team Lead:</strong> ${team.teamLead}
                                </p>

                                <p class="mb-3">
                                    <strong>Contact:</strong> ${team.contactEmail}
                                </p>

                                <!-- ACTIONS -->
                                <div class="mt-auto">

                                    <div class="d-flex gap-2 mb-2">
                                        <a href="editTeamPage?id=${team.teamId}"
                                           class="btn btn-outline-primary btn-sm w-100">
                                            <i class="bi bi-pencil"></i> Edit
                                        </a>

                                        <a href="addMemberPage?teamId=${team.teamId}"
                                           class="btn btn-outline-success btn-sm w-100">
                                            <i class="bi bi-person-plus"></i> Add Member
                                        </a>
                                    </div>

                                    <a href="viewTeamDetails?teamId=${team.teamId}"
                                       class="btn btn-outline-dark btn-sm w-100">
                                        <i class="bi bi-eye"></i> View Team
                                    </a>

                                </div>

                            </div>
                        </div>

                    </div>
                </c:forEach>

            </div>
        </c:if>

    </div>
</div>

<script>
    function toggleSidebar() {
        document.getElementById("sidebar").classList.toggle("active");
    }
</script>

</body>
</html>
