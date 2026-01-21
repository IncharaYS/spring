console.log("user_login.js loaded");

async function validateLoginEmail(input) {
    const email = input.value.trim();
    const msg = document.getElementById("emailMsg");
    const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (email === "") {
        msg.textContent = "Email is required";
        return;
    }

    else  if (!pattern.test(email)) {
        console.log("inside else if");
        msg.textContent = "Entered email is not valid";
        return;
    }
    else{
    console.log("inside else");
    try {

        const response = await axios(
            "http://localhost:8082/Inchara_XworkzModule/checkEmailExists?email="+email);

        console.log(response);
        if (response.data === false) {
            msg.textContent = "Your email is not registered";
                    return;
        } else {
            msg.textContent = "";
                    return;
        }

    } catch (e) {
        console.error(e);
        msg.textContent = "Server error";
                return;
    }
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
