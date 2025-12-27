function validateRestaurantForm() {

    const name = document.querySelector('input[name="name"]').value.trim();
    const owner = document.querySelector('input[name="owner"]').value.trim();
    const contactNumber = document.querySelector('input[name="contactNumber"]').value.trim();
    const contactEmail = document.querySelector('input[name="contactEmail"]').value.trim();
    const address = document.querySelector('textarea[name="Address"]').value.trim();
    const type = document.querySelector('input[name="type"]').value.trim();
    const rating = document.querySelector('input[name="rating"]').value.trim();
    const establishedYear = document.querySelector('input[name="establishedYear"]').value.trim();
    const openingTime = document.querySelector('input[name="openingTime"]').value;
    const closingTime = document.querySelector('input[name="closingTime"]').value;

    // Restaurant Name
    if (name === "") {
        alert("Restaurant name is required");
        return false;
    }

    // Owner Name
    if (owner === "") {
        alert("Owner name is required");
        return false;
    }

    // Contact Number (10 digits)
    const phoneRegex = /^[6-9]\d{9}$/;
    if (!phoneRegex.test(contactNumber)) {
        alert("Enter a valid 10-digit contact number");
        return false;
    }

    // Email Validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(contactEmail)) {
        alert("Enter a valid email address");
        return false;
    }

    // Address
    if (address.length < 10) {
        alert("Address must be at least 10 characters");
        return false;
    }

    // Restaurant Type
    if (type === "") {
        alert("Restaurant type is required");
        return false;
    }

    // Rating (0–5)
    if (rating !== "") {
        if (isNaN(rating) || rating < 0 || rating > 5) {
            alert("Rating must be between 0 and 5");
            return false;
        }
    }

    // Established Year (YYYY)
    const yearRegex = /^(19|20)\d{2}$/;
    if (!yearRegex.test(establishedYear)) {
        alert("Enter a valid established year (YYYY)");
        return false;
    }

    // Opening & Closing Time
    if (openingTime === "" || closingTime === "") {
        alert("Opening and Closing times are required");
        return false;
    }

    if (openingTime >= closingTime) {
        alert("Closing time must be later than opening time");
        return false;
    }

    // All validations passed
    return true;
}



function validateEmail() {
    const input = document.getElementById("email");
    const msg = document.getElementById("emailMsg");
    const email = input.value.trim();

    const pattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.(com|in|org|net|edu|gov|co\.in)$/;

    if (email === "") {
        msg.textContent = "Email is required.";
    }
    else if (pattern.test(email)) {
        msg.textContent = "";
    }
    else {
        msg.textContent = "Entered email is not valid.";
    }
}

function validatePhoneNo() {
    const input = document.getElementById("phoneNo");
    const msg = document.getElementById("phoneNoMsg");
    const phoneNo = input.value.trim();

    const pattern = /^[6-9]\d{9}$/;

    if (phoneNo === "") {
        msg.textContent = "Phone number is required.";
    }
    else if (pattern.test(phoneNo)) {
        msg.textContent = "";
    }
    else {
        msg.textContent = "Enter a valid 10-digit phone number";
    }
}

