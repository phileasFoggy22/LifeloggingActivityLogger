const URLstring = "http://localhost:8080/LifeloggingActivityLogV3/api/";


function setUpPage() {

    var images = ['T0010081.jpg', 'T0010086.JPG', 'T0020021.JPG', 'T0020046.jpg', 'T0020101.jpg', 'T0020114.jpg', 'T0040145.jpg', 'T0040160.jpg', 'T0040166.jpg', 'T0040174.jpg', 'T0040189.jpg', 'T0040215.jpg', 'T0040226.jpg', 'T0070114.jpg', 'T0070127.jpg', 'T0070132.jpg', 'T0070153.jpg', 'T0070171.jpg', 'T0070201.jpg', 'T0070234.jpg', 'T0070339.jpg'];
    var dir = '../images/';
    var randomCount = Math.round(Math.random() * (images.length - 1));
    document.getElementById("imageBanner").style.backgroundImage = "url(" + dir + images[randomCount] + ")";
    //    document.getElementById("imageBanner").innerHTML = "url(" + dir + images[randomCount] + ")";

}

function logIn() {
    document.getElementById("loginText").style.display = "none";
    let userName = document.getElementById("usernameText").value;
    let userPassword = document.getElementById("pwd").value;
    showUser(userName, userPassword);

}

function showUser(userName, userPassword) {
    makeRequest("GET", URLstring + "users/fetchUser/" + userName, "").then((resolve) => {
            document.getElementById('welcomeText').style.display = 'block';
            var newobj1 = JSON.parse(resolve);
            console.log(newobj1);
            document.getElementById("userWelecome").innerHTML = "Hi " + newobj1["userName"];
            localStorage.setItem("userEmail", newobj1["userEmail"]);
            recentActivities(newobj1["userEmail"]);

        }

    )
}






function makeRequest(method, url, body) {
    return new Promise(
        (resolve, reject) => {
            const req = new XMLHttpRequest();
            if ("withCredentials" in req) {
                // Check if the XMLHttpRequest object has a "withCredentials" property.
                // "withCredentials" only exists on XMLHTTPRequest2 objects.
                req.open(method, url, true);
                req.setRequestHeader('Content-Type', 'application/json');
                req.send(body);
            } else if (typeof XDomainRequest != "undefined") {
                // Otherwise, check if XDomainRequest.
                // XDomainRequest only exists in IE, and is IE's way of making CORS requests.
                req = new XDomainRequest();
                req.open(method, url);
                req.setRequestHeader('Content-Type', 'application/json');
                req.send(body);
            } else {
                // Otherwise, CORS is not supported by the browser.
                throw new Error('CORS not supported');
                req = null;
            }

            req.onload = () => {
                if (req.status >= 200 && req.status <= 299) {
                    resolve(req.responseText);
                } else {
                    console.log(req.responseText)
                    const reason = new Error("Rejected");
                    reject(reason);
                }
            }

        });

}
