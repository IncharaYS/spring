<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Search & Filter Cloths</title>
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
       .form-label {
           color: #000080;
           font-weight: bold;
       }


    </style>
</head>

<body>

<nav class="navbar navbar-expand-lg p-2" >
    <div class="container-fluid">
        <a class="navbar-brand fs-3 fw-bold text-white">Clothing Store</a>
        <ul class="navbar-nav ms-auto fs-5">
            <li class="nav-item"><a class="nav-link text-white" href="addClothPage">Add Cloth</a></li>
        </ul>
    </div>
</nav>




<div class="container d-flex justify-content-center py-5">
    <div class="card shadow-lg rounded-4 p-4 w-100" style="max-width:900px;">

        <h3 class="text-center mb-4" style="color:#000080;">Search  Cloths</h3>

        <form action="searchCloth" method="get">

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label class="form-label">Search  By</label>
                    <select class="form-select" name="searchBy" required>
                        <option value="">-- Select --</option>
                        <option value="clothName">Cloth Name</option>
                        <option value="size">Size</option>
                        <option value="color">Color</option>
                        <option value="category">Category</option>
                        <option value="brand">Brand</option>
                        <option value="availability">Availability Status</option>
                        <option value="price">Price</option>
                        <option value="stock">Stock Quantity</option>
                    </select>
                </div>

                <div class="col-md-6 mb-3">
                    <label class="form-label">Enter Value</label>
                    <input type="text" name="searchValue" class="form-control"
                           placeholder="Enter value to search" required>
                </div>
            </div>



            <div class="text-center">
                <input type="submit" value="Search" class="btn  btn-brand btn-primary px-5 py-2 rounded-4">
                <a href="searchPage" class="btn btn-secondary px-5 py-2 rounded-4 ms-3">Clear</a>
            </div>

            <h5 class="text-center text-danger mt-3">${errorMsg}</h5>
            <h5 class="text-center text-success mt-3">${successfulDelete}</h5>
        </form>





        <c:if test="${not empty cloth}">
            <hr>
            <h4 class="text-center" style="color:#000080;">Cloth Details</h4>

            <table class="table table-bordered text-center">
                <tr><th>Name</th><td>${cloth.clothName}</td></tr>
                <tr><th>Category</th><td>${cloth.categoryName}</td></tr>
                <tr><th>Brand</th><td>${cloth.brandName}</td></tr>
                <tr><th>Size</th><td>${cloth.size}</td></tr>
                <tr><th>Color</th><td>${cloth.color}</td></tr>
                <tr><th>Price</th><td>${cloth.price}</td></tr>
                <tr><th>Stock</th><td>${cloth.stockQuantity}</td></tr>
                <tr><th>Status</th><td>${cloth.availabilityStatus}</td></tr>
                <tr><th>Update</th>
                <td>
                    <a class="btn btn-sm btn-outline-primary"
                       href="update?id=${cloth.clothId}">
                        Update
                    </a>
                </td></tr>
                <tr><th>Delete</th>
                <td>
                    <a class="btn btn-sm btn-outline-primary"
                       href="delete?id=${cloth.clothId}">
                        Delete
                    </a>
                </td></tr>
            </table>
        </c:if>


        <c:if test="${not empty clothList}">
            <hr>
            <h4 class="text-center" style="color:#000080;">Cloths Details</h4>

            <table class="table table-bordered table-striped text-center">
                <thead class="table-primary">
                <tr>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Brand</th>
                    <th>Size</th>
                    <th>Color</th>
                    <th>Price</th>
                    <th>Stock</th>
                    <th>Status</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${clothList}" var="c">
                    <tr>
                        <td>${c.clothName}</td>
                        <td>${c.categoryName}</td>
                        <td>${c.brandName}</td>
                        <td>${c.size}</td>
                        <td>${c.color}</td>
                        <td>${c.price}</td>
                        <td>${c.stockQuantity}</td>
                        <td>${c.availabilityStatus}</td>
                        <td>
                            <a class="btn btn-sm btn-outline-primary"
                               href="update?id=${c.clothId}">
                                Update
                            </a>
                        </td>
                        <td>
                            <a class="btn btn-sm btn-outline-primary"
                               href="delete?id=${c.clothId}">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
