let emailValid = false;
const submitBtn = document.getElementById("submitBtn");


async function validateEmail() {

    console.log("email validation")

    const email = document.getElementById("email").value.trim();
    const msg = document.getElementById("emailMsg");

    const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    emailValid = false;


    if (!pattern.test(email)) {
        msg.textContent = "Entered email is not valid";
        updateSubmitButton();
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
            updateSubmitButton();
            return;
        }
         else {
            emailValid = true;
        }

    } catch (e) {
        console.error(e);
        msg.textContent = "Server error";
    }

    updateSubmitButton();
}

function updateSubmitButton() {
    submitBtn.disabled = !(emailValid);
}