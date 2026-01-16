function validateUserName(input) {
    const msg = document.getElementById("userNameMsg");
    const pattern = /^[A-Za-z\s]+$/;

    if (input.value.trim() === "") {
        msg.textContent = "Name is required";
    } else if (!pattern.test(input.value)) {
        msg.textContent = "Name should contain only alphabets";
    } else {
        msg.textContent = "";
    }
}

function validateEmail(input) {
    const msg = document.getElementById("emailMsg");
    const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (input.value.trim() === "") {
        msg.textContent = "Email is required";
    } else if (!pattern.test(input.value)) {
        msg.textContent = "Invalid email format";
    } else {
        msg.textContent = "";
    }
}

function validatePhoneNo(input) {
    const msg = document.getElementById("phoneNoMsg");
    const pattern = /^[6-9][0-9]{9}$/;

    if (input.value.trim() === "") {
        msg.textContent = "Phone number is required";
    } else if (!pattern.test(input.value)) {
        msg.textContent = "Phone must start with 6,7,8 or 9 and be 10 digits";
    } else {
        msg.textContent = "";
    }
}

function validateAge(input) {
    const msg = document.getElementById("ageMsg");

    if (input.value !== "" && (input.value <= 18 || input.value > 100)) {
        msg.textContent = "Age must be between 19 and 100";
    } else {
        msg.textContent = "";
    }
}

function validateGender(input) {
    const msg = document.getElementById("genderMsg");

    if (input.value === "") {
        msg.textContent = "Please select gender";
    } else {
        msg.textContent = "";
    }
}

function validateAddress(input) {
    const msg = document.getElementById("addressMsg");

    if (input.value.trim() === "") {
        msg.textContent = "Address is required";
    } else {
        msg.textContent = "";
    }
}

function validatePassword(input) {
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

function validateConfirmPassword(input) {
    const msg = document.getElementById("confirmPasswordMsg");
    const password = document.getElementById("password").value;

    if (input.value !== password) {
        msg.textContent = "Passwords do not match";
    } else {
        msg.textContent = "";
    }
}

function validateAll() {

    validateUserName(document.getElementById("userName"));
    validateEmail(document.getElementById("email"));
    validatePhoneNo(document.getElementById("phoneNo"));
    validateAge(document.getElementById("age"));
    validateGender(document.getElementById("gender"));
    validateAddress(document.getElementById("address"));
    validatePassword(document.getElementById("password"));
    validateConfirmPassword(document.getElementById("confirmPassword"));

    const errorMessages = document.querySelectorAll("small.text-danger");

    for (let msg of errorMessages) {
        if (msg.textContent.trim() !== "") {
            return false;
        }
    }

    return true;
}

