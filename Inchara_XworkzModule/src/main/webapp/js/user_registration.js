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

async function validateEmail(input) {
    const email = input.value.trim();
    const msg = document.getElementById("emailMsg");
    const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (email === "") {
        msg.textContent = "Email is required";
        return;
    }

    else  if (!pattern.test(email)) {
        msg.textContent = "Entered email is not valid";
        return;
    }

    else{try {
        const response = await axios(
            "http://localhost:8082/Inchara_XworkzModule/checkEmailExists?email="+email);

        if (response.data === true) {
            msg.textContent = "Your email is already registered";
        } else {
            msg.textContent = "";
        }

    } catch (e) {
        console.error(e);
        msg.textContent = "Server error";
    }
    }
}


async function validatePhoneNo(input) {
    const phoneNo=input.value.trim();
    const msg = document.getElementById("phoneNoMsg");
    const pattern = /^[6-9][0-9]{9}$/;

    if (phoneNo === "") {
        msg.textContent = "Phone number is required";
    } else if (!pattern.test(phoneNo)) {
        msg.textContent = "Phone must start with 6,7,8 or 9 and be 10 digits";
    }
     else{  try {
              const response = await axios(
                  "http://localhost:8082/Inchara_XworkzModule/checkPhoneNoExists?phoneNo="+phoneNo);

              if (response.data === true) {
                  msg.textContent = "Your phone number is already registered";
              } else {
                  msg.textContent = "";
              }

          } catch (e) {
              console.error(e);
              msg.textContent = "Server error";
          }
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
    } else if (input.value.trim().length<10){
        msg.textContent = "Address must be at least 10 characters";
        }
        else{
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

