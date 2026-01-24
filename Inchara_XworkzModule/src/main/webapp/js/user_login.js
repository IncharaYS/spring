console.log("user_login.js loaded");
const loginBtn = document.getElementById("loginButton");

let emailValid = false;
let passwordValid = false;
let blockedByAttempts = false;

validateLoginEmail();


async function validateLoginEmail() {
    const email = document.getElementById("email").value.trim();
    const msg = document.getElementById("emailMsg");

    const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    emailValid = false;
    blockedByAttempts = false;


     if (email === "") {
            msg.textContent = "";
            updateLoginButton();
            return;
        }

    if (!pattern.test(email)) {
        msg.textContent = "Entered email is not valid";
        updateLoginButton();
        return;
    }

    msg.textContent = "";

    try {
        const response = await axios(
            "http://localhost:8082/Inchara_XworkzModule/checkEmailAndTries?email=" + email
        );

        const data = response.data;

        if (!data.exists) {
            msg.textContent = "Your email is not registered";
            updateLoginButton();
            return;
        }

        if (data.attempts >= 3) {
            blockedByAttempts = true;
            msg.textContent = "Too many failed attempts. Reset password.";
        } else {
            emailValid = true;
        }

    } catch (e) {
        console.error(e);
        msg.textContent = "Server error";
    }

    updateLoginButton();
}


function validateLoginPassword(input) {
    const msg = document.getElementById("passwordMsg");
    const value = input.value.trim();

    const pattern =
        /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

    passwordValid = false;

    if (!pattern.test(value)) {
        msg.textContent =
            "Password must be at least 8 characters and include uppercase, lowercase, number & special character";
    } else {
        msg.textContent = "";
        passwordValid = true;
    }

    updateLoginButton();
}

function updateLoginButton() {
    loginBtn.disabled = !(emailValid && passwordValid && !blockedByAttempts);
}



