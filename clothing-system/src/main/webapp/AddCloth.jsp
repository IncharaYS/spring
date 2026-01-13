<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Add Cloth</title>
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

        .required {
            color: red;
        }
    </style>
</head>
<script src="js/cloth-validation.js"></script>

<body>

<nav class="navbar navbar-expand-lg p-2 navbar-custom">
    <div class="container-fluid">
        <a class="navbar-brand fs-3">Clothing Company</a>
        <li class="nav-item"><a class="nav-link" href="searchPage">Search</a></li>
    </div>
</nav>

<div class="container mt-5 d-flex justify-content-center">
    <div class="card  brand-card card-form p-4 w-100" style="max-width: 520px;">
        <h3 class="text-center mb-4 form-title">Add Cloth Details</h3>

        <form action="addCloth" method="post">


            <div class="mb-3">
                <label for="clothName" class="form-label fw-bold">
                    Cloth Name:<span class="required">*</span>
                </label>
                <input type="text" id="clothName" name="clothName" class="form-control"
                       placeholder="Enter cloth name" value="${clothDto.clothName}" required>
                <small id="clothNameMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label for="brandName" class="form-label fw-bold">
                    Brand Name:<span class="required">*</span>
                </label>
                <input type="text" id="brandName" name="brandName" class="form-control"
                       placeholder="Enter brand name" value="${clothDto.brandName}" required>
                <small id="brandNameMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label for="categoryName" class="form-label fw-bold">
                    Category Name:<span class="required">*</span>
                </label>
                <input type="text" id="categoryName" name="categoryName" class="form-control"
                       placeholder="Enter category" value="${clothDto.categoryName}" required>
                <small id="categoryNameMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label for="size" class="form-label fw-bold">
                    Size:<span class="required">*</span>
                </label>
                <input type="text" id="size" name="size" class="form-control"
                       placeholder="Enter size" value="${clothDto.size}" required>
                <small id="sizeMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label for="color" class="form-label fw-bold">
                    Color:<span class="required">*</span>
                </label>
                <input type="text" id="color" name="color" class="form-control"
                       placeholder="Enter color" value="${clothDto.color}" required>
                <small id="colorMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label for="price" class="form-label fw-bold">
                    Price:<span class="required">*</span>
                </label>
                <input type="number" step="0.01" id="price" name="price" class="form-control"
                       placeholder="Enter price" value="${clothDto.price}" required>
                <small id="priceMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label for="stockQuantity" class="form-label fw-bold">
                    Stock Quantity:<span class="required">*</span>
                </label>
                <input type="number" id="stockQuantity" name="stockQuantity" class="form-control"
                       placeholder="Enter stock quantity" value="${clothDto.stockQuantity}" required>
                <small id="stockQuantityMsg" class="text-danger"></small>
            </div>

            <div class="mb-3">
                <label for="availabilityStatus" class="form-label fw-bold">
                    Availability Status:<span class="required">*</span>
                </label>
                <select id="availabilityStatus" name="availabilityStatus"
                        class="form-select" required>
                    <option value="">Select availability</option>
                    <option value="Available" >Available
                    </option>
                    <option value="Out of Stock">Out of Stock
                    </option>
                </select>
                <small id="availabilityStatusMsg" class="text-danger"></small>
            </div>

            <c:if test="${failureMsg != null}">
                <h5 class="text-danger d-block mb-3">${failureMsg}</h5>
            </c:if>



            <div class="text-center">
                <button type="submit" class="btn btn-brand btn-lg px-5 py-2 rounded-3  ">Submit</button>
            </div>

        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
