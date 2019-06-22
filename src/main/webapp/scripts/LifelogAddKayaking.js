function addNewKayakingActivity() {
    document.getElementById("KayakingInput").style.display = "block";
    document.getElementById("HikingInput").style.display = "none";
}

function addPaddle() {
    let AKJStart = document.getElementById("AddKayakJourneyStart").value;
    let AKJEnd = document.getElementById("AddKayakJourneyEnd").value;
    let AKDuration = document.getElementById("AddKayakDuration").value;
    let AKLength = document.getElementById("AddKayakLength").value;
    let AKDate = document.getElementById("AddKayakDate").value;
    let AKDescription = document.getElementById("AddKayakDescription").value;
    let AKLifelog = document.getElementById("AddKayakLifelog").value;

    let AKbodyJSON = {};
    if (AKJStart != "") {
        AKbodyJSON["journeyStart"] = AKJStart;
    }
    if (AKJEnd != "") {
        AKbodyJSON["journeyEnd"] = AKJEnd;
    }
    if (AKDuration > 0) {
        AKbodyJSON["durationMins"] = AKDuration;
    }
    if (AKLength > 0) {
        console.log("AKLength")
        console.log(AKLength)
        AKbodyJSON["lengthKilometers"] = AKLength;
    }
    if (AKDescription != "") {
        AKbodyJSON["description"] = AKDescription;
    }
    if (AKDate.length > 6) {
        AKbodyJSON["dateCompleted"] = formatDate(AKDate);
    }
    if (AKLifelog != "") {
        AKbodyJSON["lifelogDirectory"] = AKLifelog;
    }
    if (JSON.stringify(AKbodyJSON).length > 2) {
        AKbodyJSON["activityType"] = "Kayaking";
    }

    makeRequest("PUT", URLstring + "activities/createActivity/" + userEmail, JSON.stringify(AKbodyJSON)).then((resolve) => {
        var newobj4 = JSON.parse(resolve);
        console.log(resolve);
        if (newobj4["message"] != "Activity type not found") {
            document.getElementById("KayakingInput").style.display = "none";
            document.getElementById("AddNewContainer").style.display = "none";
            recentKayakingActivities();
        }

    }).catch((reject) => {
        console.log(reject);
    })

}
