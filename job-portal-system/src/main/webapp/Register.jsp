
<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Seeker Registration</title>

    <style>
        body { margin:0; font-family: Arial, Helvetica, sans-serif; background:#f5f5f5; }
        .header {
            height:80px; background:#fff; border-bottom:4px solid #0a66c2;
            padding:15px 30px; display:flex; justify-content:space-between; align-items:center;
        }
        .logo {
            width:40px; height:40px; background:#0a66c2; color:white;
            display:flex; justify-content:center; align-items:center; border-radius:50%;
            font-weight:bold;
        }
        .container { display:flex; justify-content:center; padding:40px; }
        .card {
            width:420px; background:#fff; padding:30px;
            border-radius:6px; box-shadow:0 0 10px rgba(0,0,0,0.1);
        }
        h2 { text-align:center; color:#0a66c2; }
        .form-group { margin-bottom:15px; }
        label { font-weight:bold; display:block; margin-bottom:5px; }
        input, textarea {
            width:100%; padding:10px; border-radius:4px; border:1px solid #ccc;
        }
        textarea { resize:none; }
        .btn {
            width:100%; padding:12px; background:#0a66c2;
            color:white; border:none; font-size:16px; border-radius:4px;
        }
        .btn:hover { background:#084c91; }
        .exp-section { display:none; }
    </style>

    <script>
        function toggleExperience(val){
            document.getElementById("exp").style.display =
                (val === 'true') ? "block" : "none";
        }
    </script>
</head>

<body>

<div class="header">
    <div style="display:flex;align-items:center;gap:10px">
        <div class="logo">JP</div>
        <strong>Job Portal</strong>
    </div>
    <div>
        <a href="Search.jsp">Search</a>
    </div>
</div>

<div class="container">
    <div class="card">

        <h2>Register</h2>

        <form action="register" method="post">

            <div class="form-group">
                <label>Email *</label>
                <input type="email" name="email" required>
            </div>

            <div class="form-group">
                <label>First Name *</label>
                <input type="text" name="firstName" required>
            </div>

            <div class="form-group">
                <label>Last Name *</label>
                <input type="text" name="lastName" required>
            </div>

            <div class="form-group">
                <label>Phone *</label>
                <input type="text" name="phone" required>
            </div>

            <div class="form-group">
                <label>Location</label>
                <input type="text" name="location">
            </div>

            <div class="form-group">
                <label>Professional Summary</label>
                <textarea name="professionalSummary"></textarea>
            </div>

            <div class="form-group">
                <label>Skills</label>
                <input type="text" name="skills">
            </div>

            <div class="form-group">
                <label>Experienced?</label>
                <input type="radio" name="experienced" value="true" onclick="toggleExperience('true')"> Yes
                <input type="radio" name="experienced" value="false" onclick="toggleExperience('false')" checked> No
            </div>

            <div id="exp" class="exp-section">
                <div class="form-group">
                    <label>Company Name</label>
                    <input type="text" name="companyName">
                </div>

                <div class="form-group">
                    <label>Job Title</label>
                    <input type="text" name="jobTitle">
                </div>

                <div class="form-group">
                    <label>From Date</label>
                    <input type="date" name="fromDate">
                </div>

                <div class="form-group">
                    <label>Last Working Date</label>
                    <input type="date" name="lastWorkingDate">
                </div>
            </div>

            <div class="form-group">
                <label>Username *</label>
                <input type="text" name="username" required>
            </div>

            <div class="form-group">
                <label>Password *</label>
                <input type="password" name="password" required>
            </div>

            <input type="submit" class="btn" value="Register">

        </form>

    </div>
</div>

</body>
</html>
