<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Restaurant Registration</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #eef3fb, #ffffff);
            font-family: 'Poppins', sans-serif;
        }

        .navbar {
            background: rgba(44, 82, 130, 0.9);
            backdrop-filter: blur(6px);
        }

        .navbar-brand {
            color: #fff !important;
            font-weight: 600;
        }

        .page-wrapper {
            margin: 40px 0;
        }

        .register-card {
            background-color: #f7faff;
            border-radius: 20px;
            padding: 40px;
            box-shadow: 0px 12px 28px rgba(0, 0, 0, 0.15);
            max-width: 1100px;
            width: 80%;
        }

        .form-label {
            color: #2c5282;
        }

        .required {
            color: red;
        }

        .btn-primary {
            background-color: #2c5282;
            border: none;
        }

        .btn-primary:hover {
            background-color: #4a6fa5;
        }

        small.text-danger {
            font-size: 0.85rem;
        }
    </style>


    <script>
        function validateRestaurantForm() {

    const name = document.querySelector('input[name="name"]').value.trim();
    const owner = document.querySelector('input[name="owner"]').value.trim();
    const contactNumber = document.querySelector('input[name="contactNumber"]').value.trim();
    const contactEmail = document.querySelector('input[name="contactEmail"]').value.trim();
    const address = document.querySelector('textarea[name="Address"]').value.trim();
    const type = document.querySelector('input[name="type"]').value.trim();
    const rating = document.querySelector('input[name="rating"]').value.trim();
    const establishedYear = document.querySelector('input[name="establishedYear"]').value.trim();
    const openingTime = document.querySelector('input[name="openingTime"]').value;
    const closingTime = document.querySelector('input[name="closingTime"]').value;

    // Restaurant Name
    if (name === "") {
        alert("Restaurant name is required");
        return false;
    }

    // Owner Name
    if (owner === "") {
        alert("Owner name is required");
        return false;
    }

    // Contact Number (10 digits)
    const phoneRegex = /^[6-9]\d{9}$/;
    if (!phoneRegex.test(contactNumber)) {
        alert("Enter a valid 10-digit contact number");
        return false;
    }

    // Email Validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(contactEmail)) {
        alert("Enter a valid email address");
        return false;
    }

    // Address
    if (address.length < 10) {
        alert("Address must be at least 10 characters");
        return false;
    }

    // Restaurant Type
    if (type === "") {
        alert("Restaurant type is required");
        return false;
    }

    // Rating (0–5)
    if (rating !== "") {
        if (isNaN(rating) || rating < 0 || rating > 5) {
            alert("Rating must be between 0 and 5");
            return false;
        }
    }

    // Established Year (YYYY)
    const yearRegex = /^(19|20)\d{2}$/;
    if (!yearRegex.test(establishedYear)) {
        alert("Enter a valid established year (YYYY)");
        return false;
    }

    // Opening & Closing Time
    if (openingTime === "" || closingTime === "") {
        alert("Opening and Closing times are required");
        return false;
    }

    if (openingTime >= closingTime) {
        alert("Closing time must be later than opening time");
        return false;
    }

    // All validations passed
    return true;
}



function validateEmail() {
    const input = document.getElementById("email");
    const msg = document.getElementById("emailMsg");
    const email = input.value.trim();

    const pattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.(com|in|org|net|edu|gov|co\.in)$/;

    if (email === "") {
        msg.textContent = "Email is required.";
    }
    else if (pattern.test(email)) {
        msg.textContent = "";
    }
    else {
        msg.textContent = "Entered email is not valid.";
    }
}

function validatePhoneNo() {
    const input = document.getElementById("phoneNo");
    const msg = document.getElementById("phoneNoMsg");
    const phoneNo = input.value.trim();

    const pattern = /^[6-9]\d{9}$/;

    if (phoneNo === "") {
        msg.textContent = "Phone number is required.";
    }
    else if (pattern.test(phoneNo)) {
        msg.textContent = "";
    }
    else {
        msg.textContent = "Enter a valid 10-digit phone number";
    }
}


    </script>


</head>


<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg shadow-sm">
    <div class="container-fluid">
        <a class="navbar-brand fs-3">Zapp</a>
        <li class="nav-item"><a class="nav-link" href="index">Home</a></li>
    </div>
</nav>

<!-- Form Container -->
<div class="container d-flex justify-content-center align-items-center min-vh-100 p-4">

    <div class="register-card">
        <h3 class="mb-4 text-center" style="color:#2c5282;">Restaurant Registration</h3>

        <form action="addrestaurant" method="post" onsubmit="return validateRestaurantForm()">

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label class="form-label fw-bold">Restaurant Name<span class="required">*</span></label>
                    <input type="text" name="name" class="form-control"
                           placeholder="Enter restaurant name" >
                </div>

                <div class="col-md-6 mb-3">
                    <label class="form-label fw-bold">Owner Name<span class="required">*</span></label>
                    <input type="text" name="owner" class="form-control"
                           placeholder="Enter owner name" >
                </div>

                <div class="col-md-6 mb-3">
                    <label class="form-label fw-bold">Contact Number<span class="required">*</span></label>
                    <input type="text"
                           id="phoneNo"
                           name="contactNumber"
                           class="form-control"
                           oninput="validatePhoneNo()">

                    <small id="phoneNoMsg" class="text-danger"></small>


                </div>

                <div class="col-md-6 mb-3">
                    <label class="form-label fw-bold">Contact Email<span class="required">*</span></label>
                    <input type="email" id="email" name="contactEmail"
                           class="form-control" oninput="validateEmail()">
                    <small id="emailMsg" class="text-danger"></small>
                </div>

                <div class="col-md-12 mb-3">
                    <label class="form-label fw-bold">Address<span class="required">*</span></label>
                    <textarea name="Address" class="form-control" rows="2"
                              placeholder="Enter restaurant address"></textarea>
                </div>

                <div class="col-md-6 mb-3">
                    <label class="form-label fw-bold">Restaurant Type</label>
                    <input type="text" name="type" class="form-control"
                           placeholder="Enter type" >
                </div>

                <div class="col-md-6 mb-3">
                    <label class="form-label fw-bold">Rating</label>
                    <input type="number" step="0.1" name="rating" class="form-control"
                           placeholder="Enter rating" >
                </div>

                <div class="col-md-4 mb-3">
                    <label class="form-label fw-bold">Established Year</label>
                    <input type="text" name="establishedYear" class="form-control"
                           placeholder="Enter establisher year" >
                </div>

                <div class="col-md-4 mb-3">
                    <label class="form-label fw-bold">Opening Time</label>
                    <input type="time" name="openingTime" class="form-control"
                           placeholder="Enter opening time">
                </div>

                <div class="col-md-4 mb-3">
                    <label class="form-label fw-bold">Closing Time</label>
                    <input type="time" name="closingTime" class="form-control"
                           placeholder="Enter closing time">
                </div>
            </div>

            <div class="text-center mt-4">
                <button type="submit" class="btn btn-primary px-5 py-2 rounded-3">
                    Register Restaurant
                </button>
            </div>

        </form>
    </div>
</div>

<!--<script src="js/restaurantValidation.js"></script>-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
