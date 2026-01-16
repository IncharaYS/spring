function validateLoginEmail(input) {
    const msg = document.getElementById("emailMsg");
    const value = input.value.trim();
    const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (value === "") {
        msg.textContent = "Email is required";
    } else if (!pattern.test(value)) {
        msg.textContent = "Enter a valid email address";
    } else {
        msg.textContent = "";
    }
}

function validateLoginPassword(input) {
    const msg = document.getElementById("passwordMsg");
    const value = input.value.trim();

    const pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

    if (value === "") {
        msg.textContent = "Password is required";
    } else if (!pattern.test(value)) {
        msg.textContent =
            "Password must be at least 8 characters and include uppercase, lowercase, number & special character";
    } else {
        msg.textContent = "";
    }
}




function validateLoginAll() {

    validateLoginEmail(document.getElementById("email"));
    validateLoginPassword(document.getElementById("password"));

    const errors = document.querySelectorAll("small.text-danger");

    for (let e of errors) {
        if (e.textContent.trim() !== "") {
            return false;
        }
    }
    return true;
}
