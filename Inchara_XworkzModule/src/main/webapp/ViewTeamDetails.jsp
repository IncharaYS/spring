<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Team Details</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

    <style>
        body {
            background-image: url('images/bg.png');
            background-color: #f2f6ff;
            background-repeat: no-repeat;
            background-size: cover;
            backdrop-filter: blur(3px);
            font-family: 'Poppins', sans-serif;
        }
        .nav-link { color: white !important; }

        .sidebar {
            position: fixed;
            top: 60px;
            left: -280px;
            width: 280px;
            height: calc(100% - 60px);
            background-color: rgba(255,255,255,0.92);
            box-shadow: 2px 0 10px rgba(0,0,0,0.15);
            transition: left 0.3s ease-in-out;
            padding: 15px;
            z-index: 1050;
        }
        .sidebar.active { left: 0; }
    </style>
</head>

<body>

<nav class="navbar navbar-expand-lg shadow-sm"
     style="background-color:#0b3c5d;min-height:60px;">
    <div class="container-fluid">

        <button class="btn text-white me-3"
                onclick="toggleSidebar()"
                style="font-size:1.6rem;">
            <i class="bi bi-list"></i>
        </button>

        <a class="navbar-brand text-white fw-semibold">
            <img src="images/img_1.png" width="120" height="45">
        </a>

        <ul class="navbar-nav ms-auto gap-3 align-items-center">
            <li class="nav-item"><a class="nav-link" href="homePage">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="viewTeamsPage">Teams</a></li>
            <li class="nav-item">
                <a class="nav-link" href="profilePage">
                    <i class="bi bi-person-circle fs-4"></i>
                </a>
            </li>
            <li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
        </ul>
    </div>
</nav>

<div id="sidebar" class="sidebar">
    <div class="d-flex justify-content-between align-items-center mb-2">
        <h5>Dashboard</h5>
        <button class="btn p-0" onclick="toggleSidebar()">
            <i class="bi bi-x-lg"></i>
        </button>
    </div>
    <hr>
    <div class="list-group list-group-flush">
        <a href="addTeamPage" class="list-group-item list-group-item-action">Add Team</a>
        <a href="viewTeamsPage" class="list-group-item list-group-item-action">View Teams</a>
    </div>
</div>

<div class="container py-5">
    <div class="card shadow-lg rounded-4 p-4 bg-white">

        <h4 class="text-center mb-4" style="color:#1e3a8a;">
            ${team.teamName}  Team Details
        </h4>

        <p class="text-success text-center">${successMsg}</p>
        <p class="text-danger text-center">${failureMsg}</p>

        <div class="row mb-4">
            <div class="col-md-6">
                <p><strong>Team Lead:</strong> ${team.teamLead}</p>
                <p><strong>Contact Email:</strong> ${team.contactEmail}</p>
            </div>
            <div class="col-md-6">
                <p><strong>Project:</strong> ${team.projectName}</p>
                <p><strong>Department:</strong> ${team.department}</p>
            </div>
        </div>

        <hr>

        <div class="d-flex justify-content-between align-items-center mb-3">
            <h5 style="color:#1e3a8a;">Member Details</h5>
            <a href="addMemberPage?teamId=${team.teamId}"
               class="btn btn-primary">
                + Add Member
            </a>
        </div>


        <table class="table table-bordered table-hover text-center align-middle">
            <thead class="table-light">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Role</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${members}" var="m">
                <tr>
                    <td>${m.memberName}</td>
                    <td>${m.memberEmail}</td>
                    <td>${m.role}</td>
                    <td>
                        <a href="editMemberPage?memberId=${m.memberId}&teamId=${team.teamId}"
                           class="btn btn-sm btn-warning">
                            Edit
                        </a>

                        <form action="deleteMember"
                              method="post"
                              style="display:inline;"
                              onsubmit="return confirm('Delete this member?');">
                            <input type="hidden" name="memberId" value="${m.memberId}">
                            <input type="hidden" name="teamId" value="${team.teamId}">
                            <button class="btn btn-sm btn-danger">
                                Delete
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>

            <c:if test="${empty members}">
                <tr>
                    <td colspan="4" class="text-muted">
                        No members added yet
                    </td>
                </tr>
            </c:if>
            </tbody>
        </table>

    </div>
</div>

<script>
    function toggleSidebar() {
        document.getElementById("sidebar").classList.toggle("active");
    }
</script>

</body>
</html>
