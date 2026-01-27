<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>OTP Verification</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f2f6ff;
            font-family: 'Poppins', sans-serif;
        }
        .btn-theme {
            background-color: #2563eb;
            color: white;
        }
        .btn-theme:hover {
            background-color: #1d4ed8;
        }
    </style>
</head>

<body>

<nav class="navbar navbar-expand-lg px-3 shadow-sm"
     style="background-color: #0b3c5d; min-height: 60px;">
    <div class="container-fluid">
        <a class="navbar-brand text-white fw-semibold">
            <img src="images/img_1.png" width="120" height="45">
        </a>
    </div>
</nav>

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg rounded-4 p-4 bg-white w-100" style="max-width: 420px;">

        <h4 class="text-center mb-3" style="color:#1e3a8a;">
            OTP Verification
        </h4>

        <p class="text-center text-muted">
            OTP sent to <strong>${email}</strong>
        </p>

        <form action="verifyOtp" method="post">
            <input type="hidden" name="email" value="${email}" />

            <div class="mb-3">
                <label class="form-label fw-bold">Enter OTP</label>
                <input type="text" name="otp" class="form-control"
                       placeholder="Enter 6-digit OTP">
                <small class="text-danger">${failureMsg}</small>
            </div>

            <div class="d-grid mb-2">
                <button type="submit" class="btn btn-theme">
                    Verify OTP
                </button>
            </div>
        </form>

        <div class="text-center mt-3">
            <span class="text-muted">
                Resend OTP in <span id="timer">60</span> seconds
            </span>
        </div>

        <form action="resendOtp" method="post"
              id="resendForm" style="display:none;"
              class="text-center mt-3">

            <input type="hidden" name="email" value="${email}" />

            <button type="submit" class="btn btn-outline-primary">
                Resend OTP
            </button>
        </form>

    </div>
</div>

<script>
    let timeLeft = ${remainingTime != null ? remainingTime : 60};
    const timerEl = document.getElementById("timer");
    const resendForm = document.getElementById("resendForm");

    timerEl.innerText = timeLeft;

    const interval = setInterval(() => {
        timeLeft--;
        timerEl.innerText = timeLeft;

        if (timeLeft <= 0) {
            clearInterval(interval);
            timerEl.innerText = "0";
            resendForm.style.display = "block";
        }
    }, 1000);
</script>

</body>
</html>
