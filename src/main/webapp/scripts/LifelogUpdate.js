var userEmail = localStorage.getItem("userEmail");

function updateActivity(id, bodyJSON) {
    var realJSON = JSON.stringify(bodyJSON)
    console.log("here" + realJSON);
    makeRequest("PUT", URLstring + "activities/updateActivity/" + userEmail + "/" + id, realJSON).then((resolve) => {
        var newobj1 = JSON.parse(resolve);
        console.log(newobj1);
        if (newobj1["ActivityUpdated"] === "Hiking") {
            recentHikingActivities();
        }
        if (newobj1["ActivityUpdated"] === "Kayaking") {
            recentKayakingActivities();
        }
    })
}

function deleteActivity(id) {
    makeRequest("DELETE", URLstring + "activities/removeActivity/" + userEmail + "/" + id, "").then((resolve) => {
        var newobj1 = JSON.parse(resolve);
        console.log(newobj1);
        if (newobj1["ActivityRemoved"] === "Hiking") {
            recentHikingActivities();
        }
        if (newobj1["ActivityRemoved"] === "Kayaking") {
            recentKayakingActivities();
        }
    })
}
