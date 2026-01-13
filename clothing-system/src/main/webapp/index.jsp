<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Index page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: url('images/img.png');
            background-color: #f2f6ff;
            background-repeat: no-repeat;
            background-size: cover;
            background-position: center;
            backdrop-filter: blur(3px);
            font-family: 'Poppins', sans-serif;
        }

        .brand-card {
            background: rgba(245, 245, 245, 0.85);
            border-radius: 1rem;
            backdrop-filter: blur(6px);
            box-shadow: 0 8px 20px rgba(0,0,0,0.15);
            border: 1px solid rgba(200, 200, 200, 0.3);
        }

        .brand-card h1,
        .brand-card h5 {
            color: #383838;
        }

        .btn-brand {
            background-color: #6f42c1;
            color: #fff;
            border: none;
        }

        .btn-brand:hover {
            background-color: #5932a1;
            color: #fff;
        }

    nav.navbar {
        background: rgba(111, 66, 193, 0.9);
        border-bottom: 3px solid #5a2f88;
    }

    nav.navbar a.navbar-brand,
    nav.navbar .nav-link {
        color: #ffffff;
        font-weight: 500;
    }

    nav.navbar .nav-link:hover {
        color: #f0eaff;
    }

    nav.navbar .navbar-brand {
        font-size: 1.8rem;
        font-weight: bold;
    }
    </style>


</head>
<body style="background-color: #f2f6ff;">

<nav class="navbar navbar-expand-lg p-1"
     style=" backdrop-filter: blur(6px); font-family: 'Poppins', sans-serif;">
    <div class="container-fluid">
        <a class="navbar-brand fs-3">Clothing Company</a>

        <div class="collapse navbar-collapse" id="nav">
            <ul class="navbar-nav ms-auto fs-5">
                <li class="nav-item"><a class="nav-link" href="addClothPage">Add cloths</a></li>
                <li class="nav-item"><a class="nav-link" href="searchPage">Search</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container d-flex justify-content-center align-items-center vh-100 ">
    <div class="card brand-card shadow-lg rounded-4 p-4 text-center w-75"
         style="max-width: 450px;">
        <h1 class="mb-4">Welcome to the Clothing Company</h1>
        <h5 class="mb-4">Click the button below to add cloth</h5>
        <a href="addClothPage" class="btn btn-brand btn-lg px-5 py-3 rounded-3">
            Add Cloth
        </a>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>
</body>
</html>
