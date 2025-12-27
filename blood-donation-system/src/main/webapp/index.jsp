<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home | Blood Services</title>

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
            border-bottom: 4px solid #d71f28;
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
            background: #d71f28;
            color: white;
            font-weight: bold;
            display: flex;
            align-items: center;
            justify-content: center;
            border-radius: 50%;
            font-size: 22px;
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
            width: 400px;
            text-align: center;
            border-radius: 8px;
            box-shadow: 0 0 12px rgba(0,0,0,0.12);
        }

        .home-card h1 {
            color: #d71f28;
            margin-bottom: 15px;
        }

        .home-card p {
            color: #555;
            margin-bottom: 30px;
            font-size: 16px;
        }

        .btn {
            display: inline-block;
            background: #d71f28;
            color: white;
            text-decoration: none;
            padding: 14px 28px;
            font-size: 16px;
            border-radius: 4px;
            font-weight: bold;
        }

        .btn:hover {
            background: #b61b22;
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
        <a href="index.jsp">Home</a>
        <a href="searchNav">Search</a>
        <a href="Register.jsp">Register</a>
    </div>
</div>

<!-- Main Content -->
<div class="container">
    <div class="home-card">
        <h1>Donate Blood</h1>
        <p>
            Your blood donation can save lives.
            Join us in making a difference today.
        </p>

        <a href="Register.jsp" class="btn">Donate Blood</a>
    </div>
</div>

</body>
</html>
