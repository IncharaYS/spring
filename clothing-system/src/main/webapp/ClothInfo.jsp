<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Cloth Details</title>
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

        nav.navbar {
            background: rgba(111, 66, 193, 0.9);
            border-bottom: 3px solid #5a2f88;
        }

        nav.navbar .navbar-brand {
            color: #fff;
            font-size: 1.8rem;
            font-weight: bold;
        }

        .detail-label {
            font-weight: 600;
            color: #383838;
        }

                    .btn-brand {
                background-color: #6f42c1;
                color: #fff;
                border: none;
            }
    </style>
</head>

<body>

<nav class="navbar navbar-expand-lg p-2">
    <div class="container-fluid">
        <a class="navbar-brand fs-3">Clothing Company</a>
        <li class="nav-item"><a class="nav-link" href="searchPage">Search</a></li>
    </div>sf
</nav>

<div class="container py-5 d-flex justify-content-center">
    <div class="card brand-card p-4 w-100" style="max-width: 520px;">

        <c:if test="${successMsg != null}">
            <h4 class="text-center text-success mb-4">${successMsg}</h4>

        </c:if>

        <c:if test="${clothDto != null}">
            <h3 class="mb-3" style="font-weight:700;">Cloth Details</h3>
            <hr>

            <div class="ps-2">
                <p><span class="detail-label">Cloth Name:</span> ${clothDto.clothName}</p>
                <p><span class="detail-label">Brand Name:</span> ${clothDto.brandName}</p>
                <p><span class="detail-label">Category:</span> ${clothDto.categoryName}</p>
                <p><span class="detail-label">Size:</span> ${clothDto.size}</p>
                <p><span class="detail-label">Color:</span> ${clothDto.color}</p>
                <p><span class="detail-label">Price:</span>${clothDto.price}</p>
                <p><span class="detail-label">Stock Quantity:</span> ${clothDto.stockQuantity}</p>
                <p><span class="detail-label">Availability:</span> ${clothDto.availabilityStatus}</p>
            </div>
        </c:if>

        <div class="text-center mt-4">
            <a href="addClothPage" class="btn btn-brand btn-lg px-5 py-2 rounded-3 ">
                Add Another Cloth
            </a>
        </div>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
