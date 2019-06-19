function recentKayakingActivities() {
    var userEmail = localStorage.getItem("userEmail");
    makeRequest("GET", URLstring + "activities/getActivitiesByCategory/" + userEmail + "/Kayaking", "").then((resolve) => {
        var newobj1 = JSON.parse(resolve);
        console.log(newobj1);
        document.getElementById("recentactivityList").innerHTML = "";
        for (var i = 0; i < newobj1.length; i++) {
            let nodeDiv = document.createElement("DIV");
            nodeDiv.className = "container activitylisting"
            let row1 = document.createElement("DIV");
            row1.className = "row";
            let col1a = document.createElement("DIV");
            col1a.className = "col-xs-8";

            //Route Name
            let titleh2 = document.createElement("h2");
            let titleh2Input = document.createElement("input");
            let titleh2Input2 = document.createElement("input");
            if (newobj1[i]["journeyStart"] != null) {
                titleh2.innerHTML = newobj1[i]["journeyStart"];
                titleh2Input.value = newobj1[i]["journeyStart"];
                if (newobj1[i]["journeyEnd"] != null) {
                    titleh2.innerHTML += " to " + newobj1[i]["journeyEnd"];
                    titleh2Input2.value = newobj1[i]["journeyEnd"];
                }
            } else if (newobj1[i]["journeyEnd"] != null) {
                titleh2.innerHTML = newobj1[i]["journeyEnd"];
                titleh2Input2.value = newobj1[i]["journeyEnd"];
            }
            titleh2Input.type = "text";
            titleh2Input.className = "form-control";
            titleh2Input.placeholder = "Journey Start";
            titleh2Input.style.display = "none";
            titleh2Input2.type = "text";
            titleh2Input2.className = "form-control";
            titleh2Input2.placeholder = "Journey End";
            titleh2Input2.style.display = "none";


            let col2a = document.createElement("DIV");
            col2a.className = "col-xs-4";
            col2a.style.paddingTop = '20px';

            //Dates
            let dateh4 = document.createElement("h4");
            let dateh4Input = document.createElement("input");
            dateh4Input.style.display = "none";
            dateh4Input.type = "date";
            dateh4Input.className = "form-control";
            dateh4Input.placeholder = "Date";


            if (newobj1[i]["dateCompleted"] != null) {
                dateh4.innerHTML += newobj1[i]["dateCompleted"];
                dateh4Input.value = newobj1[i]["dateCompleted"];
            }
            dateh4.style.float = "right";

            col1a.appendChild(titleh2);
            col1a.appendChild(titleh2Input);
            col1a.appendChild(titleh2Input2);
            row1.appendChild(col1a);
            col2a.appendChild(dateh4);
            col2a.appendChild(dateh4Input);
            row1.appendChild(col2a);
            row1.style.backgroundColor = "gold";
            nodeDiv.appendChild(row1);


            let row3 = document.createElement("DIV");
            row3.className = "row";
            let col1c = document.createElement("DIV");
            col1c.className = "col-xs-8";
            //Duration
            let h6dur = document.createElement("h5");
            let h6durInput = document.createElement("input");
            let h6durMinInput = document.createElement("input");
            h6durInput.style.display = "none";
            h6durInput.type = "number";
            h6durInput.className = "form-control";
            h6durInput.placeholder = "hrs";
            h6durMinInput.style.display = "none";
            h6durMinInput.type = "number";
            h6durMinInput.className = "form-control";
            h6durMinInput.placeholder = "mins";
            if (newobj1[i]["durationMins"] != null) {
                let duration = newobj1[i]["durationMins"];
                if (duration > 59) {
                    h6dur.innerHTML = (duration / 60) + " hrs " + (duration % 60) + " mins";
                    h6durInput.value = (duration / 60);
                    h6durMinInput.value = (duration % 60);
                } else {
                    h6dur.innerHTML = duration + " mins";
                    h6durMinInput.value = duration;
                }
            } else {
                h6dur.innerHTML = " ";
            }
            let col2c = document.createElement("DIV");
            col2c.className = "col-xs-4";
            //distance
            let h6km = document.createElement("h5");
            let h6kmInput = document.createElement("input");
            h6kmInput.style.display = "none";
            h6kmInput.type = "number";
            h6kmInput.className = "form-control";
            h6kmInput.placeholder = "distance";
            if (newobj1[i]["lengthKilometers"] != null) {
                h6km.innerHTML = newobj1[i]["lengthKilometers"] + ' kilometers';
                h6kmInput.value = newobj1[i]["lengthKilometers"];
            } else {
                h6km.innerHTML = " ";
            }
            h6km.style.float = "right";
            col1c.appendChild(h6dur);
            col1c.appendChild(h6durInput);
            row3.appendChild(col1c);
            col2c.appendChild(h6km);
            col2c.appendChild(h6kmInput);
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
            btnUpdate.className = "btn btn-primary";
            btnUpdate.type = "button";
            btnUpdate.value = "Submit";
            btnUpdate.style.float = "right";
            btn.onclick = (function () {
                return function () {
                    titleh2.style.display = "none";
                    titleh2Input.style.display = "block";
                    titleh2Input2.style.display = "block";


                    dateh4.style.display = "none";
                    dateh4Input.style.display = "block";

                    h6durInput.style.display = "block";
                    h6dur.style.display = "none";

                    h6kmInput.style.display = "block";
                    h6km.style.display = "none";

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
                    titleh2Input2.style.display = "none";

                    dateh4.style.display = "block";
                    dateh4Input.style.display = "none";

                    h6kmInput.style.display = "none";
                    h6km.style.display = "block";

                    h6durInput.style.display = "none";
                    h6dur.style.display = "block";

                    pdescInput.style.display = "none";
                    pdesc.style.display = "block";

                    fdirInput.style.display = "none";
                    fdir.style.display = "block";

                    btnUpdate.style.display = "none";
                    btn.style.display = "block";

                    updateActivity(id);
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
    })
}
