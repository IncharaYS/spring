<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Update Cloth</title>
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

        nav.navbar .navbar-brand,
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

        .btn-brand {
            background-color: #6f42c1;
            color: #fff;
            border: none;
        }

        .btn-brand:hover {
            background-color: #5932a1;
            color: #fff;
        }

        .required {
            color: red;
        }
    </style>
</head>

<body>

<nav class="navbar navbar-expand-lg p-2">
    <div class="container-fluid">
        <a class="navbar-brand fs-3">Clothing Company</a>
        <ul class="navbar-nav ms-auto">
            <li class="nav-item">
                <a class="nav-link" href="searchPage">Search</a>
                <a class="nav-link" href="addClothPage">Add Cloth</a>
                <a class="nav-link" href="index.jsp">Index</a>
            </li>
        </ul>
    </div>
</nav>


<div class="container mt-5 d-flex justify-content-center">
    <div class="card brand-card p-4 w-100" style="max-width: 520px;">

        <h3 class="text-center mb-4" style="font-weight:700;">Update Cloth Details</h3>

        <form action="updateCloth" method="post">


            <input type="hidden" name="clothId" value="${clothDto.clothId}"/>
            <input type="hidden" name="clothName" value="${clothDto.clothName}"/>

            <div class="mb-3">
                <label class="form-label fw-bold">
                    Cloth Name <span class="required">*</span>
                </label>
                <input type="text"  class="form-control" disabled
                       value="${clothDto.clothName}" required>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">
                    Brand Name <span class="required">*</span>
                </label>
                <input type="text" name="brandName" class="form-control"
                       value="${clothDto.brandName}" required>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">
                    Category Name <span class="required">*</span>
                </label>
                <input type="text" name="categoryName" class="form-control"
                       value="${clothDto.categoryName}" required>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">
                    Size <span class="required">*</span>
                </label>
                <input type="text" name="size" class="form-control"
                       value="${clothDto.size}" required>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">
                    Color <span class="required">*</span>
                </label>
                <input type="text" name="color" class="form-control"
                       value="${clothDto.color}" required>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">
                    Price <span class="required">*</span>
                </label>
                <input type="number" step="0.01" name="price" class="form-control"
                       value="${clothDto.price}" required>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">
                    Stock Quantity <span class="required">*</span>
                </label>
                <input type="number" name="stockQuantity" class="form-control"
                       value="${clothDto.stockQuantity}" required>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">
                    Availability Status <span class="required">*</span>
                </label>
                <select name="availabilityStatus" class="form-select" required>
                    <option value="">Select availability</option>

                    <c:choose>
                        <c:when test="${clothDto.availabilityStatus eq 'Available'}">
                            <option value="Available" selected>Available</option>
                            <option value="Out of Stock">Out of Stock</option>
                        </c:when>

                        <c:when test="${clothDto.availabilityStatus eq 'Out of Stock'}">
                            <option value="Available">Available</option>
                            <option value="Out of Stock" selected>Out of Stock</option>
                        </c:when>

                        <c:otherwise>
                            <option value="Available">Available</option>
                            <option value="Out of Stock">Out of Stock</option>
                        </c:otherwise>
                    </c:choose>
                </select>



            </div>



            <c:if test="${not empty errorMsg}">
                <h6 class="text-danger text-center mb-3">${errorMsg}</h6>
            </c:if>

            <div class="text-center">
                <button type="submit"
                        class="btn btn-brand btn-lg px-5 py-2 rounded-3">
                    Update Cloth
                </button>
            </div>

        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
