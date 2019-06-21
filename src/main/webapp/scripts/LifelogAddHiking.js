function addNewHikingActivity() {
    document.getElementById("HikingInput").style.display = "block";
}

function addHike() {
    let AHtitleh2Input = document.getElementById("AddHikeRouteName").value;
    let AHh6locInput = document.getElementById("AddHikeLocation").value;
    let AHh6milesInput = document.getElementById("AddHikeDistance").value;
    let AHpdescInput = document.getElementById("AddHikeDescription").value;
    let AHfdirInput = document.getElementById("AddHikeLifelog").value;
    let AHdateStart = document.getElementById("AddHikeStartDate").value;
    let AHdateEnd = document.getElementById("AddHikeEndDate").value;
    let AHbodyJSON = {};
    if (AHtitleh2Input != "") {
        AHbodyJSON.officialRouteName = AHtitleh2Input;
    }
    if (AHh6locInput != "") {
        AHbodyJSON["location"] = AHh6locInput;
    }
    if (AHh6milesInput != "") {
        AHbodyJSON["lengthMiles"] = AHh6milesInput;
    }
    if (AHpdescInput != "") {
        AHbodyJSON["description"] = AHpdescInput;
    }
    if (AHfdirInput != "") {
        AHbodyJSON["lifelogDirectory"] = AHfdirInput.value;
    }
    if (AHdateStart.length > 6) {
        AHbodyJSON["startDate"] = formatDate(AHdateStart);
    }
    if (AHdateEnd.length > 6) {
        AHbodyJSON["endDate"] = formatDate(AHdateEnd);
    }
    makeRequest("PUT", URLstring + "activities/createActivity/" + userEmail, JSON.stringify(AHbodyJSON)).then((resolve) => {})

    recentHikingActivities()
}
