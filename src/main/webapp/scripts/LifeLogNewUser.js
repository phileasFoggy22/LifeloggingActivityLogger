function addUser() {
    document.getElementById("usernameText").style.display = "block";
    document.getElementById("login-btn").style.display = "none";
    document.getElementById("login-Reg").style.display = "block";
    document.getElementById("login-add").style.display = "none";
}

function RegisterUser() {
    let userEmail = document.getElementById("useremailText").value;
    let userName = document.getElementById("usernameText").value;
    let userPassword = document.getElementById("pwd").value;
    var newUserJSON = {
        userName: userName,
        userEmail: userEmail,
        userPassword: userPassword
    };
    var newUserJSONString = JSON.stringify(newUserJSON);
    console.log(newUserJSONString);
    makeRequest("GET", URLstring + "users/fetchUser/" + userEmail, "").then((resolve) => {
        var newobj2 = JSON.parse(resolve);
        console.log(newobj2);
        if (newobj2 != null) {
            document.getElementById("loginResponse").innerHTML = "Email already in use";
        } else {
            makeRequest("POST", URLstring + "users/createUser", newUserJSONString).then((resolve) => {
                document.getElementById("loginText").style.display = "none";
                showUser(userEmail, userPassword);
            })
        }

    }).catch((reject) => {
        makeRequest("POST", URLstring + "users/createUser", newUserJSONString).then((resolve) => {
            showUser(userEmail, userPassword);
        })
    })

}

