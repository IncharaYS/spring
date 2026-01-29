function validateTeamName(input) {
    const msg = document.getElementById("teamNameMsg");
    const pattern = /^[A-Za-z\s]+$/;

    if (input.value.trim() === "") {
        msg.textContent = "Team name is required";
    } else if (!pattern.test(input.value)) {
        msg.textContent = "Only alphabets allowed";
    } else {
        msg.textContent = "";
    }
}

function validateTeamLead(input) {
    const msg = document.getElementById("teamLeadMsg");
    const pattern = /^[A-Za-z\s]+$/;

    if (input.value.trim() === "") {
        msg.textContent = "Team lead is required";
    } else if (!pattern.test(input.value)) {
        msg.textContent = "Only alphabets allowed";
    } else {
        msg.textContent = "";
    }
}


function validateProjectName(input) {
    const msg = document.getElementById("projectMsg");

    if (input.value.trim().length < 3) {
        msg.textContent = "Project name must be at least 3 characters";
    } else {
        msg.textContent = "";
    }
}

function validateDepartment(input) {
    const msg = document.getElementById("departmentMsg");

    if (input.value.trim() === "") {
        msg.textContent = "Department is required";
    } else {
        msg.textContent = "";
    }
}

function validateAllTeam() {

    validateTeamName(document.getElementById("teamName"));
    validateTeamLead(document.getElementById("teamLead"));
    validateProjectName(document.getElementById("projectName"));
    validateDepartment(document.getElementById("department"));

    const errors = document.querySelectorAll("small.text-danger");
    for (let e of errors) {
        if (e.textContent.trim() !== "") {
            return false;
        }
    }
    return true;
}
