<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration Portal</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(to right, #e3f2fd, #f8f9fa);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: 'Segoe UI', sans-serif;
        }
        .card {
            border-radius: 16px;
        }
        .btn {
            width: 100%;
        }
    </style>
</head>

<body>

<div class="container">
    <div class="card shadow-lg p-4">
        <h3 class="text-center mb-4 text-primary">
            Registration Forms Portal
        </h3>

        <div class="row g-3">

            <div class="col-md-6">
                <a href="userRegistration" class="btn btn-outline-primary">
                    User Registration
                </a>
            </div>

            <!-- FORM 2 -->
            <div class="col-md-6">
                <a href="EmployeeRegister" class="btn btn-outline-secondary">
                    Employee Registration
                </a>
            </div>

            <!-- FORM 3 -->
            <div class="col-md-6">
                <a href="StudentRegister" class="btn btn-outline-success">
                    Student Registration
                </a>
            </div>

            <!-- FORM 4 -->
            <div class="col-md-6">
                <a href="VendorRegister" class="btn btn-outline-danger">
                    Vendor Registration
                </a>
            </div>

            <!-- FORM 5 -->
            <div class="col-md-6">
                <a href="AdminRegister" class="btn btn-outline-warning">
                    Admin Registration
                </a>
            </div>

            <!-- FORM 6 -->
            <div class="col-md-6">
                <a href="TrainerRegister" class="btn btn-outline-info">
                    Trainer Registration
                </a>
            </div>

            <!-- FORM 7 -->
            <div class="col-md-6">
                <a href="CustomerRegister" class="btn btn-outline-dark">
                    Customer Registration
                </a>
            </div>

            <!-- FORM 8 -->
            <div class="col-md-6">
                <a href="ManagerRegister" class="btn btn-outline-primary">
                    Manager Registration
                </a>
            </div>

            <!-- FORM 9 -->
            <div class="col-md-6">
                <a href="DoctorRegister" class="btn btn-outline-success">
                    Doctor Registration
                </a>
            </div>

            <!-- FORM 10 -->
            <div class="col-md-6">
                <a href="SellerRegister" class="btn btn-outline-danger">
                    Seller Registration
                </a>
            </div>

        </div>
    </div>
</div>

</body>
</html>
