function validateUserName(input) {
    const msg = document.getElementById("userNameMsg");
    const pattern = /^[A-Za-z\s]+$/;

    if (input.value.trim() === "") {
        msg.textContent = "Name is required";
    } else if (!pattern.test(input.value)) {
        msg.textContent = "Only alphabets allowed";
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

    else{
    try {
        const response = await axios(
            "http://localhost:8082/Inchara_XworkzModule/checkEmailAndTries?email="+email);

        const data = response.data;

        if (data.exists) {
            msg.textContent = "Email not available";
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
    }
     else if (!pattern.test(phoneNo)) {
        msg.textContent = "Phone must start with 6,7,8 or 9 and be 10 digits";
    }
     else{
       try {
              const response = await axios(
                  "http://localhost:8082/Inchara_XworkzModule/checkPhoneNoExists?phoneNo="+phoneNo);

              if (response.data === true) {
                  msg.textContent = "Phone number not available";
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
    const age = parseInt(input.value);

    if (age <= 18 || age > 100) {
        msg.textContent = "Age must be between 19 and 100";
    } else {
        msg.textContent = "";
    }
}

function validateGender(input) {
    document.getElementById("genderMsg").textContent =
        input.value === "" ? "Please select gender" : "";
}


function validateAddress(input) {
    const msg = document.getElementById("addressMsg");
    msg.textContent =
        input.value.trim().length < 10
            ? "Address must be at least 10 characters"
            : "";
}



function validateUpdateProfile() {

    validateUserName(document.getElementById("userName"));
    validateAge(document.getElementById("age"));
    validateGender(document.getElementById("gender"));
    validateAddress(document.getElementById("address"));

    const errors = document.querySelectorAll("small.text-danger");
    for (let e of errors) {
        if (e.textContent.trim() !== "") {
            return false;
        }
    }
    return true;
}
