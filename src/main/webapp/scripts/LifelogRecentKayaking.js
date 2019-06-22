function recentKayakingActivities() {

    var userEmail = localStorage.getItem("userEmail");
    makeRequest("GET", URLstring + "activities/getActivitiesByCategory/" + userEmail + "/Kayaking", "").then((resolve) => {
        var newobjKayaking = JSON.parse(resolve);
        document.getElementById("recentactivityList").innerHTML = "";
        for (var i = 0; i < newobjKayaking.length; i++) {
            recentKayakingNode(newobjKayaking, i);
        }
    })
}

function recentKayakingNode(newobj1, i) {
    let nodeDiv = document.createElement("DIV");
    nodeDiv.className = "container activitylisting"
    let row1 = document.createElement("DIV");
    row1.className = "row";
    let col1a = document.createElement("DIV");
    col1a.className = "col-xs-8";

    //Route Name
    let titleh2 = document.createElement("h2");
    let AKJStart = document.createElement("input");
    let AKJEnd = document.createElement("input");
    if (newobj1[i]["journeyStart"] != null) {
        titleh2.innerHTML = newobj1[i]["journeyStart"];
        AKJStart.value = newobj1[i]["journeyStart"];
        if (newobj1[i]["journeyEnd"] != null) {
            titleh2.innerHTML += " to " + newobj1[i]["journeyEnd"];
            AKJEnd.value = newobj1[i]["journeyEnd"];
        }
    } else if (newobj1[i]["journeyEnd"] != null) {
        titleh2.innerHTML = newobj1[i]["journeyEnd"];
        AKJEnd.value = newobj1[i]["journeyEnd"];
    }
    AKJStart.type = "text";
    AKJStart.className = "form-control";
    AKJStart.placeholder = "Journey Start";
    AKJStart.style.display = "none";
    AKJEnd.type = "text";
    AKJEnd.className = "form-control";
    AKJEnd.placeholder = "Journey End";
    AKJEnd.style.display = "none";


    let col2a = document.createElement("DIV");
    col2a.className = "col-xs-4";
    col2a.style.paddingTop = '20px';

    //Dates
    let dateh4 = document.createElement("h4");
    let AKDate = document.createElement("input");
    AKDate.style.display = "none";
    AKDate.type = "date";
    AKDate.className = "form-control";
    AKDate.placeholder = "Date";


    if (newobj1[i]["dateCompleted"] != null) {
        dateh4.innerHTML += newobj1[i]["dateCompleted"];
        AKDate.value = newobj1[i]["dateCompleted"];
    }
    dateh4.style.float = "right";

    col1a.appendChild(titleh2);
    col1a.appendChild(AKJStart);
    col1a.appendChild(AKJEnd);
    row1.appendChild(col1a);
    col2a.appendChild(dateh4);
    col2a.appendChild(AKDate);
    row1.appendChild(col2a);
    row1.style.backgroundColor = "#5bc0de";
    row1.style.color = "white";
    nodeDiv.appendChild(row1);


    let row3 = document.createElement("DIV");
    row3.className = "row";
    let col1c = document.createElement("DIV");
    col1c.className = "col-xs-8";
    //Duration
    let h6dur = document.createElement("h5");
    let AKDuration = document.createElement("input");
    AKDuration.style.display = "none";
    AKDuration.type = "number";
    AKDuration.className = "form-control";
    AKDuration.placeholder = "mins";
    if (newobj1[i]["durationMins"] != null) {
        let duration = newobj1[i]["durationMins"];
        if (duration > 59) {
            h6dur.innerHTML = (duration / 60) + " hrs " + (duration % 60) + " mins";
            AKDuration.value = (duration);
        } else {
            h6dur.innerHTML = duration + " mins";
            AKDuration.value = duration;
        }
    } else {
        h6dur.innerHTML = " ";
    }
    let col2c = document.createElement("DIV");
    col2c.className = "col-xs-4";
    //distance
    let h6km = document.createElement("h5");
    let AKLength = document.createElement("input");
    AKLength.style.display = "none";
    AKLength.type = "number";
    AKLength.className = "form-control";
    AKLength.placeholder = "distance";
    if (newobj1[i]["lengthKilometers"] != null) {
        h6km.innerHTML = newobj1[i]["lengthKilometers"] + ' kilometers';
        AKLength.value = newobj1[i]["lengthKilometers"];
    } else {
        h6km.innerHTML = " ";
    }
    h6km.style.float = "right";
    col1c.appendChild(h6dur);
    col1c.appendChild(AKDuration);
    row3.appendChild(col1c);
    col2c.appendChild(h6km);
    col2c.appendChild(AKLength);
    row3.appendChild(col2c);
    nodeDiv.appendChild(row3);


    let row2 = document.createElement("DIV");
    row2.className = "row";
    let col1b = document.createElement("DIV");
    col1b.className = "col-xs-10";
    //description
    let pdesc = document.createElement("p");
    let AKDescription = document.createElement("input");
    AKDescription.style.display = "none";
    AKDescription.type = "text";
    AKDescription.className = "form-control";
    AKDescription.placeholder = "description";
    if (newobj1[i]["description"] != null) {
        pdesc.innerHTML = newobj1[i]["description"];
        AKDescription.value = newobj1[i]["description"];
    } else {
        pdesc.innerHTML = "no description entered";
    }
    pdesc.style.wordWrap = "break-word";
    pdesc.style.maxWidth = "40vw";
    pdesc.style.fontSize = "75%";

    let col2b = document.createElement("DIV");
    col2b.className = "col-xs-2";
    let btnDel = document.createElement('input');
    btnDel.className = "btn btn-danger btn-sm";
    btnDel.type = "button";
    btnDel.value = "Delete";
    btnDel.style.float = "right";
    btnDel.style.margin = "auto";

    let id = newobj1[i]["id"];
    btnDel.onclick = (function () {
        return function () {
            deleteActivity(id);
        }
    })(newobj1[i]["id"]);


    col1b.appendChild(pdesc);
    col1b.appendChild(AKDescription);
    row2.appendChild(col1b);
    col2b.appendChild(btnDel);
    row2.appendChild(col2b);
    nodeDiv.appendChild(row2);

    let row4 = document.createElement("DIV");
    row4.className = "row";
    let col1d = document.createElement("DIV");
    col1d.className = "col-xs-10";
    //file directory
    let fdir = document.createElement("h6");
    let AKLifelog = document.createElement("input");
    AKLifelog.style.display = "none";
    AKLifelog.type = "text";
    AKLifelog.className = "form-control";
    AKLifelog.placeholder = "lifelog file directory";
    if (newobj1[i]["lifelogDirectory"] != null) {
        fdir.innerHTML = "Lifelog: " + newobj1[i]["lifelogDirectory"];
        AKLifelog.value = newobj1[i]["lifelogDirectory"];
    } else {
        fdir.innerHTML = "no lifelog entered";
    }
    let col2d = document.createElement("DIV");
    col2d.className = "col-xs-2";
    let btn = document.createElement('input');
    btn.className = "btn btn-success";
    btn.type = "button";
    btn.value = "Edit";
    btn.style.float = "right";
    let btnUpdate = document.createElement('input');
    btnUpdate.style.display = "none";
    btnUpdate.className = "btn btn-primary";
    btnUpdate.type = "button";
    btnUpdate.value = "Submit";
    btnUpdate.style.float = "right";
    btn.onclick = (function () {
        return function () {
            titleh2.style.display = "none";
            AKJStart.style.display = "block";
            AKJEnd.style.display = "block";


            dateh4.style.display = "none";
            AKDate.style.display = "block";

            AKDuration.style.display = "block";
            h6dur.style.display = "none";

            AKLength.style.display = "block";
            h6km.style.display = "none";

            AKDescription.style.display = "block";
            pdesc.style.display = "none";

            AKLifelog.style.display = "block";
            fdir.style.display = "none";

            btnUpdate.style.display = "block";
            btn.style.display = "none";
        }
    })(newobj1[i]["id"]);


    btnUpdate.onclick = (function () {
        return function () {
            titleh2.style.display = "block";
            AKJStart.style.display = "none";
            AKJEnd.style.display = "none";

            dateh4.style.display = "block";
            AKDate.style.display = "none";

            AKLength.style.display = "none";
            h6km.style.display = "block";

            AKDuration.style.display = "none";
            h6dur.style.display = "block";

            AKDescription.style.display = "none";
            pdesc.style.display = "block";

            AKLifelog.style.display = "none";
            fdir.style.display = "block";

            btnUpdate.style.display = "none";
            btn.style.display = "block";

            let AKbodyJSON = {};
            if (AKJStart.value != "") {
                AKbodyJSON["journeyStart"] = AKJStart.value;
            }
            if (AKJEnd.value != "") {
                AKbodyJSON["journeyEnd"] = AKJEnd.value;
            }
            if (AKDuration.value > 0) {
                AKbodyJSON["durationMins"] = AKDuration.value;
            }
            if (AKLength.value > 0) {
                AKbodyJSON["lengthKilometers"] = AKLength.value;
            }
            if (AKDescription.value != "") {
                AKbodyJSON["description"] = AKDescription.value;
            }
            if (AKDate.value.length > 6) {
                AKbodyJSON["dateCompleted"] = formatDate(AKDate.value.toString());
            }
            if (AKLifelog.value != "") {
                AKbodyJSON["lifelogDirectory"] = AKLifelog;
            }

            updateActivity(id, AKbodyJSON);
        }
    })(newobj1[i]["id"]);

    col1d.appendChild(fdir);
    col1d.appendChild(AKLifelog);
    row4.appendChild(col1d);
    col2d.appendChild(btn);
    col2d.appendChild(btnUpdate);
    row4.appendChild(col2d);
    row4.style.paddingBottom = "10px";
    nodeDiv.appendChild(row4);

    document.getElementById("recentactivityList").appendChild(nodeDiv);
}
