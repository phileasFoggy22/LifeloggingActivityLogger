function recentHikingActivities() {


    var userEmail = localStorage.getItem("userEmail");
    makeRequest("GET", URLstring + "activities/getActivitiesByCategory/" + userEmail + "/Hiking", "").then((resolve) => {
        var newobjHiking = JSON.parse(resolve);
        document.getElementById("recentactivityList").innerHTML = "";
        for (var i = 0; i < newobjHiking.length; i++) {
            recentHikingNode(newobjHiking, i);
        }
    })
}


function recentHikingNode(newobj1, i) {

    let nodeDiv = document.createElement("DIV");
    nodeDiv.className = "container activitylisting"
    let row1 = document.createElement("DIV");
    row1.className = "row";
    let col1a = document.createElement("DIV");
    col1a.className = "col-xs-8";

    //Route Name
    let titleh2 = document.createElement("h2");
    let titleh2Input = document.createElement("input");
    if (newobj1[i]["officialRouteName"] != null) {
        titleh2.innerHTML = newobj1[i]["officialRouteName"];
        titleh2Input.value = newobj1[i]["officialRouteName"];
    }
    titleh2Input.type = "text";
    titleh2Input.className = "form-control";
    titleh2Input.placeholder = "Route Name";
    titleh2Input.style.display = "none";


    let col2a = document.createElement("DIV");
    col2a.className = "col-xs-4";
    col2a.style.paddingTop = '10px';

    //Dates
    let dateh4 = document.createElement("h6");
    dateh4.style.textAlign = "center";
    dateh4.style.fontWeight = "bold";

    let dateh4Input = document.createElement("input");
    dateh4Input.style.display = "none";
    dateh4Input.type = "date";
    dateh4Input.className = "form-control";
    dateh4Input.placeholder = "Start Date";
    let dateh4Input2 = document.createElement("input");
    dateh4Input2.style.display = "none";
    dateh4Input2.type = "date";
    dateh4Input2.className = "form-control";
    dateh4Input2.placeholder = "End Date";


    dateh4.innerHTML = "";
    if (newobj1[i]["startDate"] != null) {
        dateh4.innerHTML += newobj1[i]["startDate"]["day"] + ' ' + monthNames[newobj1[i]["startDate"]["month"]] + ' ' + newobj1[i]["startDate"]["year"];
        dateh4Input.value = newobj1[i]["startDate"];
        if (newobj1[i]["endDate"] != null) {
            dateh4.innerHTML += ' to ' + newobj1[i]["endDate"]["day"] + ' ' + monthNames[newobj1[i]["endDate"]["month"]] + ' ' + newobj1[i]["endDate"]["year"];
            dateh4Input2.value = newobj1[i]["endDate"];
        }
    } else if (newobj1[i]["endDate"] != null) {
        dateh4.innerHTML += newobj1[i]["endDate"]["day"] + ' ' + monthNames[newobj1[i]["endDate"]["month"]] + ' ' + newobj1[i]["endDate"]["year"];
        dateh4Input2.value = newobj1[i]["endDate"];
    }
    if ((newobj1[i]["endDate"] == null) && (newobj1[i]["startDate"] == null)) {
        dateh4.innerHTML = " ";
    }
    dateh4.style.float = "right";


    col1a.appendChild(titleh2);
    col1a.appendChild(titleh2Input);
    row1.appendChild(col1a);
    col2a.appendChild(dateh4);
    col2a.appendChild(dateh4Input);
    col2a.appendChild(dateh4Input2);
    row1.appendChild(col2a);
    row1.style.backgroundColor = "#5cb85c";
    row1.style.color = "white";
    nodeDiv.appendChild(row1);


    let row3 = document.createElement("DIV");
    row3.className = "row";
    let col1c = document.createElement("DIV");
    col1c.className = "col-xs-8";
    //location
    let h6loc = document.createElement("h5");
    let h6locInput = document.createElement("input");
    h6locInput.style.display = "none";
    h6locInput.type = "text";
    h6locInput.className = "form-control";
    h6locInput.placeholder = "Location";
    if (newobj1[i]["location"] != null) {
        h6loc.innerHTML = newobj1[i]["location"];
        h6locInput.value = newobj1[i]["location"];
    } else {
        h6loc.innerHTML = " ";
    }
    let col2c = document.createElement("DIV");
    col2c.className = "col-xs-4";
    //distance
    let h6miles = document.createElement("h5");
    let h6milesInput = document.createElement("input");
    h6milesInput.style.display = "none";
    h6milesInput.type = "number";
    h6milesInput.className = "form-control";
    h6milesInput.placeholder = "distance";
    if (newobj1[i]["lengthMiles"] != null) {
        h6miles.innerHTML = newobj1[i]["lengthMiles"] + ' miles';
        h6milesInput.value = newobj1[i]["lengthMiles"];
    } else {
        h6miles.innerHTML = " ";
    }
    h6miles.style.float = "right";
    col1c.appendChild(h6loc);
    col1c.appendChild(h6locInput);
    row3.appendChild(col1c);
    col2c.appendChild(h6miles);
    col2c.appendChild(h6milesInput);
    row3.appendChild(col2c);
    nodeDiv.appendChild(row3);


    let row2 = document.createElement("DIV");
    row2.className = "row";
    let col1b = document.createElement("DIV");
    col1b.className = "col-xs-10";
    //description
    let pdesc = document.createElement("p");
    let pdescInput = document.createElement("input");
    pdescInput.style.display = "none";
    pdescInput.type = "text";
    pdescInput.className = "form-control";
    pdescInput.placeholder = "description";
    if (newobj1[i]["description"] != null) {
        pdesc.innerHTML = newobj1[i]["description"];
        pdescInput.value = newobj1[i]["description"];
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
    col1b.appendChild(pdescInput);
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
    let fdirInput = document.createElement("input");
    fdirInput.style.display = "none";
    fdirInput.type = "text";
    fdirInput.className = "form-control";
    fdirInput.placeholder = "lifelog file directory";
    if (newobj1[i]["lifelogDirectory"] != null) {
        fdir.innerHTML = "Lifelog: " + newobj1[i]["lifelogDirectory"];
        fdirInput.value = newobj1[i]["lifelogDirectory"];
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
    btnUpdate.className = "btn btn-success";
    btnUpdate.type = "button";
    btnUpdate.value = "Submit";
    btnUpdate.style.float = "right";
    btn.onclick = (function () {
        return function () {
            titleh2.style.display = "none";
            titleh2Input.style.display = "block";

            dateh4.style.display = "none";
            dateh4Input.style.display = "block";
            dateh4Input2.style.display = "block";

            h6locInput.style.display = "block";
            h6loc.style.display = "none";

            h6milesInput.style.display = "block";
            h6miles.style.display = "none";

            pdescInput.style.display = "block";
            pdesc.style.display = "none";

            fdirInput.style.display = "block";
            fdir.style.display = "none";

            btnUpdate.style.display = "block";
            btn.style.display = "none";


        }
    })(newobj1[i]["id"]);


    btnUpdate.onclick = (function () {
        return function () {
            titleh2.style.display = "block";
            titleh2Input.style.display = "none";

            dateh4.style.display = "block";
            dateh4Input.style.display = "none";
            dateh4Input2.style.display = "none";

            h6locInput.style.display = "none";
            h6loc.style.display = "block";

            h6milesInput.style.display = "none";
            h6miles.style.display = "block";

            pdescInput.style.display = "none";
            pdesc.style.display = "block";

            fdirInput.style.display = "none";
            fdir.style.display = "block";

            btnUpdate.style.display = "none";
            btn.style.display = "block";

            let bodyJSON = {};
            if (titleh2Input.value != "") {
                bodyJSON["officialRouteName"] = titleh2Input.value;
            }
            if (h6locInput.value != "") {
                bodyJSON["location"] = h6locInput.value;
            }
            if (h6milesInput.value != "") {
                bodyJSON["lengthMiles"] = h6milesInput.value;
            }
            if (pdescInput.value != "") {
                bodyJSON["description"] = pdescInput.value;
            }
            if (fdirInput.value != "") {
                bodyJSON["lifelogDirectory"] = fdirInput.value;
            }
            if (dateh4Input.value.length > 6) {
                bodyJSON["startDate"] = formatDate(dateh4Input.value.toString());
            }
            if (dateh4Input2.value.length > 6) {
                bodyJSON["endDate"] = formatDate(dateh4Input2.value.toString());
            }

            updateActivity(id, bodyJSON);
        }
    })(newobj1[i]["id"]);

    col1d.appendChild(fdir);
    col1d.appendChild(fdirInput);
    row4.appendChild(col1d);
    col2d.appendChild(btn);
    col2d.appendChild(btnUpdate);
    row4.appendChild(col2d);
    row4.style.paddingBottom = "10px";
    nodeDiv.appendChild(row4);

    document.getElementById("recentactivityList").appendChild(nodeDiv);
}
