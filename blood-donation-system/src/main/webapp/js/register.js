// ===============================
// Populate Date of Birth Dropdowns
// ===============================
window.onload = function () {
    populateYears();
    populateMonths();
    populateDays();
};

// Years (current year - 100)
function populateYears() {
    const yearSelect = document.querySelector(".dob select:nth-child(1)");
    const currentYear = new Date().getFullYear();

    for (let y = currentYear; y >= currentYear - 100; y--) {
        let option = document.createElement("option");
        option.value = y;
        option.text = y;
        yearSelect.appendChild(option);
    }
}

// Months
function populateMonths() {
    const monthSelect = document.querySelector(".dob select:nth-child(2)");
    const months = [
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    ];

    months.forEach((month, index) => {
        let option = document.createElement("option");
        option.value = index + 1;
        option.text = month;
        monthSelect.appendChild(option);
    });
}

// Days
function populateDays() {
    const daySelect = document.querySelector(".dob select:nth-child(3)");

    for (let d = 1; d <= 31; d++) {
        let option = document.createElement("option");
        option.value = d;
        option.text = d;
        daySelect.appendChild(option);
    }
}

// ===============================
// Password Strength Checker
// ===============================
const passwordInput = document.querySelector("input[name='password']");
const strengthText = document.querySelector(".password-strength");

passwordInput.addEventListener("input", function () {
    const password = passwordInput.value;
    let strength = "Weak";
    let color = "red";

    if (password.length >= 8 &&
        /[A-Z]/.test(password) &&
        /[0-9]/.test(password) &&
        /[!@#$%^&*]/.test(password)) {
        strength = "Strong";
        color = "green";
    } else if (password.length >= 6) {
        strength = "Medium";
        color = "orange";
    }

    strengthText.textContent = "Strength: " + strength;
    strengthText.style.color = color;
});

// ===============================
// Confirm Password Validation
// ===============================
const confirmPasswordInput = document.querySelector("input[name='confirmPassword']");

confirmPasswordInput.addEventListener("input", function () {
    if (confirmPasswordInput.value !== passwordInput.value) {
        confirmPasswordInput.style.borderColor = "red";
    } else {
        confirmPasswordInput.style.borderColor = "#ccc";
    }
});

// ===============================
// ZIP Code Validation (US ZIP)
// ===============================
const zipInput = document.querySelector("input[name='zip']");

zipInput.addEventListener("input", function () {
    zipInput.value = zipInput.value.replace(/[^0-9]/g, "");

    if (zipInput.value.length !== 5) {
        zipInput.style.borderColor = "red";
    } else {
        zipInput.style.borderColor = "#ccc";
    }
});

// ===============================
// Form Submit Validation
// ===============================
document.querySelector("form").addEventListener("submit", function (e) {
    if (passwordInput.value !== confirmPasswordInput.value) {
        alert("Passwords do not match!");
        e.preventDefault();
    }
});
