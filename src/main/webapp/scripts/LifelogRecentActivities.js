function showRecentActivities() {
    var userEmail = localStorage.getItem("userEmail");
    makeRequest("GET", URLstring + "activities/getAllActivities/" + userEmail, "").then((resolve) => {
        var newobj1 = JSON.parse(resolve);
        document.getElementById("recentactivityList").innerHTML = "";
        for (var i = 0; i < newobj1.length; i++) {
            if (newobj1[i]["activityType"] == "Hiking") {
                recentHikingNode(newobj1, i);
            }
            if (newobj1[i]["activityType"] == "Kayaking") {
                recentKayakingNode(newobj1, i);
            }
        }
    })
}
