

<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Job Seeker | Job Portal</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
            background: #f5f5f5;
        }

        /* ===== NAV BAR ===== */
        .header {
            height: 80px;
            background: #ffffff;
            border-bottom: 4px solid #0a66c2;
            padding: 15px 30px;
            display: flex;
            align-items: center;
            justify-content: space-between;
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
            background: #0a66c2;
            color: white;
            font-weight: bold;
            display: flex;
            align-items: center;
            justify-content: center;
            border-radius: 50%;
            font-size: 18px;
        }

        .header-right a {
            margin-left: 20px;
            text-decoration: none;
            color: #333;
            font-weight: bold;
        }

        /* ===== PAGE CONTENT ===== */
        .container {
            min-height: calc(100vh - 80px);
            display: flex;
            justify-content: center;
            align-items: flex-start;
            padding-top: 40px;
            box-sizing: border-box;
        }

        .card {
            width: 420px;
            background: #ffffff;
            padding: 30px;
            border-radius: 6px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            color: #0a66c2;
        }

        label {
            font-weight: bold;
        }

        input[type="email"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        .btn {
            width: 100%;
            padding: 12px;
            background: #0a66c2;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 15px;
        }

        .btn:hover {
            background: #084c91;
        }

        .error {
            color: red;
            text-align: center;
            margin-top: 10px;
        }

        .success {
            color: green;
            text-align: center;
            margin-top: 10px;
        }

        .details {
            margin-top: 20px;
            background: #f9f9f9;
            padding: 15px;
            border-radius: 5px;
        }

        .action-links a {
            margin-right: 15px;
            text-decoration: none;
            color: #0a66c2;
            font-weight: bold;
        }
    </style>
</head>

<body>

<!-- ===== NAV BAR ===== -->
<div class="header">
    <div class="header-left">
        <div class="logo">JP</div>
        <strong>Job Portal</strong>
    </div>

    <div class="header-right">
        <a href="index.jsp">Home</a>
        <a href="Register.jsp">Register</a>
        <a href="Search.jsp">Search</a>
    </div>
</div>

<!-- ===== SEARCH CONTENT ===== -->
<div class="container">
    <div class="card">

        <h2>Search Job Seeker</h2>

        <form action="search" method="get">
            <label>Email Address *</label>
            <input type="email" name="email" required>

            <input type="submit" class="btn" value="Search">
        </form>

        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>

        <c:if test="${not empty successMsg}">
            <div class="success">${successMsg}</div>
        </c:if>

        <c:if test="${not empty jobSeeker}">
            <div class="details">
                <p><strong>Name:</strong> ${jobSeeker.firstName} ${jobSeeker.lastName}</p>
                <p><strong>Email:</strong> ${jobSeeker.email}</p>
                <p><strong>Phone:</strong> ${jobSeeker.phone}</p>
                <p><strong>Skills:</strong> ${jobSeeker.skills}</p>

                <div class="action-links">
                    <a href="update?email=${jobSeeker.email}">Edit</a>
                    <a href="delete?email=${jobSeeker.email}">Delete</a>
                </div>
            </div>
        </c:if>

    </div>
</div>

</body>
</html>
