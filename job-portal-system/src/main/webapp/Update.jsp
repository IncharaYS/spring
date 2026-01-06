
<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Job Seeker</title>

    <style>
        body { margin:0; font-family:Arial; background:#f5f5f5; }
        .container { display:flex; justify-content:center; padding:40px; }
        .card {
            width:420px; background:#fff; padding:30px;
            border-radius:6px; box-shadow:0 0 10px rgba(0,0,0,0.1);
        }
        h2 { text-align:center; color:#0a66c2; }
        .btn { width:100%; padding:10px; background:#0a66c2; color:white; border:none; }
    </style>
</head>

<body>

<div class="container">
    <div class="card">

        <h2>Update Profile</h2>

        <form action="update" method="post">

            <input type="hidden" name="email" value="${jobSeeker.email}">

            <label>First Name</label>
            <input type="text" name="firstName" value="${jobSeeker.firstName}">

            <label>Last Name</label>
            <input type="text" name="lastName" value="${jobSeeker.lastName}">

            <label>Skills</label>
            <input type="text" name="skills" value="${jobSeeker.skills}">

            <label>Password</label>
            <input type="text" name="password" value="${jobSeeker.password}">

            <br><br>
            <input type="submit" class="btn" value="Update">

        </form>

    </div>
</div>

</body>
</html>
