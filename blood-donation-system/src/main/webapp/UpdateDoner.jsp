<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Update Doner | Blood Services</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
            background: #f5f5f5;
        }

        /* Header */
        .header {
            background: #ffffff;
            border-bottom: 4px solid #d71f28;
            padding: 15px 30px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            height: 80px;
            box-sizing: border-box;
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
            height: calc(100vh - 80px);
            display: flex;
            justify-content: center;
            align-items: center;
            overflow-y: auto;
        }

        .card {
            background: #ffffff;
            width: 420px;
            padding: 30px;
            border-radius: 6px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        .card h2 {
            text-align: center;
            color: #d71f28;
            margin-bottom: 20px;
        }

        .form-group {
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
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        .btn {
            width: 100%;
            padding: 12px;
            background: #d71f28;
            color: white;
            border: none;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn:hover {
            background: #b61b22;
        }

        .error {
            color: red;
            text-align: center;
            margin-top: 10px;
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


<div class="container">
    <div class="card">
        <h2>Update Doner</h2>

        <form action="updateDoner" method="post">

            <input name = "id" value="${donerInfo.id}" hidden>

            <div class="form-group">
                <label>Email *</label>
                <input type="email" value="${donerInfo.donerEmail}" disabled>
                <input type="hidden" name="donerEmail" value="${donerInfo.donerEmail}">
            </div>

            <div class="form-group">
                <label>First Name *</label>
                <input type="text" name="donerFirstName"
                       value="${donerInfo.donerFirstName}" required>
            </div>

            <div class="form-group">
                <label>Last Name *</label>
                <input type="text" name="donerLastName"
                       value="${donerInfo.donerLastName}" required>
            </div>

            <div class="form-group">
                <label>Username *</label>
                <input type="text" name="donerUsername"
                       value="${donerInfo.donerUsername}" required>
            </div>

            <div class="form-group">
                <label>ZIP Code *</label>
                <input type="text" name="donerZipCode"
                       value="${donerInfo.donerZipCode}" required>
            </div>

            <div class="form-group">
                <label>Password *</label>
                <input type="text" name="donerPassword"
                       value="${donerInfo.donerPassword}" required>
            </div>

            <div class="form-group">
                <label>Donor ID</label>
                <input type="text" name="donorId"
                       value="${donerInfo.donorId}">
            </div>

            <input type="submit" class="btn" name="Update" value="Update">

            <c:if test="${not empty errorMsg}">
                <div class="error">${errorMsg}</div>
            </c:if>

        </form>
    </div>
</div>

</body>
</html>
