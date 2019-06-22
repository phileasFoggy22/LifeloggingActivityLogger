function logIn() {
    document.getElementById("loginText").style.display = "none";
    let userEmail = document.getElementById("useremailText").value;
    let userPassword = document.getElementById("pwd").value;
    if (userEmail != "" && userPassword != "") {
        showUser(userEmail, userPassword);
    } else {
        document.getElementById("loginText").style.display = "block";
        document.getElementById("loginResponse").innerHTML = "I don't think I know you";
    }
}


function showUser(userEmail, userPassword) {
    makeRequest("GET", URLstring + "users/fetchUser/" + userEmail, "").then((resolve) => {

            var newobj1 = JSON.parse(resolve);
            if ((newobj1 != null) && (newobj1["userPassword"] == userPassword && newobj1["userEmail"] == userEmail)) {
                document.getElementById('welcomeText').style.display = 'block';
                document.getElementById("userWelcome").innerHTML = "Hi " + newobj1["userName"];
                localStorage.setItem("userName", newobj1["userName"]);
                localStorage.setItem("userEmail", newobj1["userEmail"]);
                localStorage.setItem("userPassword", newobj1["userPassword"]);
                userWelcomeDetails.addEventListener("click", updateUserDetails);
                userWelcomeDetails.style.cursor = "pointer";
                showRecentActivities();

            } else {
                document.getElementById("loginText").style.display = "block";
                document.getElementById("loginResponse").innerHTML = "Who are you!?!";
            }
        }

    )
}

function updateUserDetails() {
    document.getElementById("loginText").style.display = "block";
    document.getElementById("loginResponse").innerHTML = "You've changed.";
    document.getElementById('welcomeText').style.display = 'none';
    document.getElementById('login-add').style.display = 'none';
    document.getElementById('login-btn').style.display = 'none';
    document.getElementById('login-Reg').style.display = 'none';
    document.getElementById('login-Upd').style.display = 'block';
    document.getElementById('usernameText').style.display = 'block';
    document.getElementById('useremailText').value = localStorage.getItem("userEmail");
    document.getElementById('useremailText').readOnly = true;
    document.getElementById('usernameText').value = localStorage.getItem("userName");
    document.getElementById('pwd').placeholder = 'new password?';

}

function updateUserRegistrationInformation() {
    let newName = document.getElementById('usernameText').value;
    let newEmail = document.getElementById('useremailText').value;
    let newPassword = document.getElementById('pwd').value;
    if (newName != "" && newEmail != "" && newPassword != "") {
        let UserbodyJSON = {};
        UserbodyJSON["userName"] = newName;
        UserbodyJSON["userEmail"] = newEmail;
        UserbodyJSON["userPassword"] = newPassword;
        if (UserbodyJSON["userEmail"] != localStorage.getItem("userEmail")) {
            makeRequest("GET", URLstring + "users/fetchUser/" + UserbodyJSON["userEmail"], "").then((resolve) => {
                var newUserObjectEmailsDup = JSON.parse(resolve);
                if (newUserObjectEmailsDup != null) {
                    document.getElementById("loginResponse").innerHTML = "Username already taken";
                } else {
                    completeUserUpdate(UserbodyJSON, newEmail, newPassword)
                }
            })
        } else {
            completeUserUpdate(UserbodyJSON, newEmail, newPassword)
        }
    } else {
        document.getElementById("loginResponse").innerHTML = "Enter all the fields please";
    }

}

function completeUserUpdate(UserbodyJSON, newEmail, newPassword) {
    makeRequest("PUT", URLstring + "users/updateUser/" + localStorage.getItem("userEmail"), JSON.stringify(UserbodyJSON)).then((resolve) => {
        var newUserObjectEmails = JSON.parse(resolve);
        if (newUserObjectEmails["message"] == "email successfully updated") {
            console.log("hi2")
        } else if (newUserObjectEmails["message"] == "user successfully updated") {
            document.getElementById('login-Upd').style.display = 'none';
            document.getElementById('usernameText').style.display = 'none';
            document.getElementById('loginText').style.display = 'none';
            showUser(newEmail, newPassword)
        }
    })
}
