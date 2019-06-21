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
            console.log(newobj1);
            if ((newobj1 != null) && (newobj1["userPassword"] == userPassword && newobj1["userEmail"] == userEmail)) {
                document.getElementById('welcomeText').style.display = 'block';
                document.getElementById("userWelecome").innerHTML = "Hi " + newobj1["userName"];
                localStorage.setItem("userEmail", newobj1["userEmail"]);
                localStorage.setItem("userPassword", newobj1["userPassword"]);
                recentActivities(newobj1["userEmail"]);

            } else {
                document.getElementById("loginText").style.display = "block";
                document.getElementById("loginResponse").innerHTML = "Who are you!?!";
            }
        }

    )
}
