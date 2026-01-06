<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home | Job Portal</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
            background: #f5f5f5;
        }

        /* Navbar */
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

        /* Page Content */
        .container {
            height: calc(100vh - 80px);
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .home-card {
            background: #ffffff;
            padding: 40px;
            width: 420px;
            text-align: center;
            border-radius: 8px;
            box-shadow: 0 0 12px rgba(0,0,0,0.12);
        }

        .home-card h1 {
            color: #0a66c2;
            margin-bottom: 15px;
        }

        .home-card p {
            color: #555;
            margin-bottom: 30px;
            font-size: 16px;
        }

        .btn {
            display: inline-block;
            background: #0a66c2;
            color: white;
            text-decoration: none;
            padding: 14px 28px;
            font-size: 16px;
            border-radius: 4px;
            font-weight: bold;
        }

        .btn:hover {
            background: #084c91;
        }
    </style>
</head>

<body>

<!-- Navbar -->
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

<!-- Main Content -->
<div class="container">
    <div class="home-card">
        <h1>Find Your Dream Job</h1>
        <p>
            Register your profile, showcase your skills,
            and get hired by top companies.
        </p>

        <a href="Register.jsp" class="btn">Get Started</a>
    </div>
</div>

</body>
</html>
