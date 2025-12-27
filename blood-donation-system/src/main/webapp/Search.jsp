<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Search Doner | Blood Services</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
            background: #f5f5f5;
        }

        /* Header */
            .header {
            height: 80px;
            box-sizing: border-box;
            background: #ffffff;
            border-bottom: 4px solid #d71f28;
            padding: 15px 30px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .header-left {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .logo {
            width: 40px;
            height: 40px;
            background: #d71f28;
            color: white;
            font-weight: bold;
            display: flex;
            align-items: center;
            justify-content: center;
            border-radius: 50%;
        }

        .header-right a {
            margin-left: 20px;
            text-decoration: none;
            color: #333;
            font-weight: bold;
        }

        /* Page Layout */
.container {
    min-height: calc(100vh - 80px); /* navbar height */
    display: flex;
    justify-content: center;   /* horizontal center only */
    align-items: flex-start;   /* IMPORTANT: prevents overlap */
    padding-top: 40px;
    padding-bottom: 40px;
    box-sizing: border-box;
}




        .search-box {
            background: #ffffff;
            padding: 30px;
            width: 350px;
            border-radius: 6px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            box-sizing: border-box;   /* added */
        }


        .search-box h2 {
            color: #d71f28;
            margin-bottom: 20px;
            text-align: center;
        }

        .form-group {
            padding-top:2px;
            margin-bottom: 15px;
        }

        .form-group label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .btn {
            background: #d71f28;
            color: white;
            border: none;
            padding: 12px;
            width: 100%;
            font-size: 16px;
            cursor: pointer;
            border-radius: 4px;
        }

        .btn:hover {
            background: #b61b22;
        }

        .error {
            margin-top: 15px;
            color: red;
            text-align: center;
        }
    </style>
</head>

<body>

<!-- Navbar -->
<div class="header">
    <div class="header-left">
        <div class="logo">+</div>
        <strong>American Red Cross | Blood Services</strong>
    </div>
    <div class="header-right">
        <a href="searchNav">Search</a>
        <a href="Register.jsp">Register</a>
    </div>
</div>

<!-- Search Form -->
<div class="container">
    <div class="search-box">
        <c:if test="${not empty updateSuccessMsg}">
            <div class="error">${updateSuccessMsg}</div>
        </c:if>
        <br>
        <h2>Search Doner</h2>

        <form action="search" method="get">
            <div class="form-group">
                <label>Email Address *</label>
                <input type="email" name="email" required>
            </div>

            <input type="submit" class="btn" value="Search">
        </form>

        <c:if test="${not empty emailNotFound}">
            <div class="error">${emailNotFound}</div>
        </c:if>



        <c:if test="${not empty donerInfo}">
            <div style="margin-top:20px; background:#f9f9f9; padding:15px; border-radius:5px;">
                <h3 style="color:#d71f28; text-align:center;">Doner Details</h3>

                <p><strong>Email:</strong> ${donerInfo.donerEmail}</p>
                <p><strong>First Name:</strong> ${donerInfo.donerFirstName}</p>
                <p><strong>Last Name:</strong> ${donerInfo.donerLastName}</p>
                <p><strong>Username:</strong> ${donerInfo.donerUsername}</p>
                <p><strong>ZIP Code:</strong> ${donerInfo.donerZipCode}</p>
                <p><strong>Date of Birth:</strong>
                    ${donerInfo.donerBirthDay}
                    ${donerInfo.donerBirthMonth}
                    ${donerInfo.donerBirthYear}
                </p>
                <p><strong>Donor ID:</strong> ${donerInfo.donorId}</p>


                <c:if test="${not empty updateSuccessMsg}">
                    <div class="success-msg">${updateSuccessMsg}</div>
                </c:if>


                <c:if test="${not empty failed}">
                    <div class="error-msg">${failed}</div>
                </c:if>

                <a class="btn btn-sm btn-outline-primary"
                   style="margin-right:10px;"
                   href="update?email=${donerInfo.donerEmail}">
                    Update
                </a>

                <a class="btn btn-sm btn-outline-primary"
                   href="delete?email=${donerInfo.donerEmail}">
                    Delete
                </a>
            </div>
        </c:if>

    </div>
</div>

</body>
</html>
