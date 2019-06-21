function addNewKayakingActivity() {
    document.getElementById("HikingInput").style.display = "block";
}

function addPaddle() {
    let AKtitleh2Input = document.getElementById("AddHikeRouteName").value;
    let AKh6locInput = document.getElementById("AddHikeLocation").value;
    let AKh6milesInput = document.getElementById("AddHikeDistance").value;
    let AKpdescInput = document.getElementById("AddHikeDescription").value;
    let AKfdirInput = document.getElementById("AddHikeLifelog").value;
    let AKdateStart = document.getElementById("AddHikeStartDate").value;
    let AKdateEnd = document.getElementById("AddHikeEndDate").value;


    let AKbodyJSON = {};
    if (AKtitleh2Input != "") {
        AKbodyJSON.officialRouteName = AKtitleh2Input;
    }
    if (AKh6locInput != "") {
        AKbodyJSON["location"] = AKh6locInput;
    }
    if (AKh6milesInput != "") {
        AKbodyJSON["lengthMiles"] = AKh6milesInput;
    }
    if (AKpdescInput != "") {
        AKbodyJSON["description"] = AKpdescInput;
    }
    if (AKfdirInput != "") {
        AKbodyJSON["lifelogDirectory"] = AKfdirInput.value;
    }
    if (AKdateStart.length > 6) {
        AKbodyJSON["startDate"] = formatDate(AKdateStart);
    }
    if (AKdateEnd.length > 6) {
        AKbodyJSON["endDate"] = formatDate(AKdateEnd);
    }
    makeRequest("PUT", URLstring + "activities/createActivity/" + userEmail, JSON.stringify(AKbodyJSON)).then((resolve) => {})

    recentHikingActivities()
}
