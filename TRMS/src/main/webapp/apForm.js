function loadingInfo(){
    employee =JSON.parse(sessionStorage.getItem("e1"));
    document.getElementById("userId").value =employee.id;
    let fullname = employee.fName + employee.lName;
    document.getElementById("username").value = fullname;
 }

function makeButtons(){
    var a= document.createElement("button");
    a = document.createTextNode("Preview ");
    a.id= 'preview';
    a.onclick="a1();"
    let body = document.getElementById("appBody");
    body.appendChild(a);
   
    var b= document.createElement("button");
    b = document.createTextNode("Next");
    b.id= 'preview';
    b.onclick="b1();"
    body.appendChild(b);

    var c = document.createElement("button");
    c = document.createTextNode("Approve this");
    c.id = "approveB";
    c.onclick = "isRightPerson();"
    body.appendChild(c);


    if(employee.titleId ==1 || employee.titleId ==4){
        var d = document.createElement("button");
        d = document.createTextNode("Check Reimbursment ");
        d.id= "checkRei";
        d.onclick="getAllReimbursement();"
        body.appendChild(d);        
    }

}



function a1(){
    if(count==0){
        b.style.visibility ="visible";
    }
    displayR();
    count++;
}

function b1(){
    displayR();
    count++;
}


function checkRequest(){
    employee =JSON.parse(sessionStorage.getItem("e1"));
    let xhttp =  new XMLHttpRequest();
    xhttp.onreadystatechange =function(){
            if(this.readyState ==4 && this.status ==200){
                console.log(this.responseText);
                var count =0;
                makeButtons();
                if(count ==0){
                    b.style.visibility="hidden";
                }
                let newRequest = JSON.parse(this.responseText);
        
                function displayR(){
                    if(newRequest[count].level1 == 1){
                        var approval1 = "Yes";
                    }else if(newRequest[count] == 0){
                        approval1 ="Pending";
                    }else{
                        approval1 = "No";
                    }
                    if(newRequest[count].level2 == 1){
                        var approval2 = "Yes";
                    }else if(newRequest[count].level2 == 0){
                        approval2 ="Pending";
                    }else{
                        approval2 = "No";
                    }
                    if(newRequest[count].level3 == 1){
                        var approval3 = "Yes";
                    }else if(newRequest[count].level3 == 0){
                        approval3 ="Pending";
                    }else{
                        approval3 = "No";
                    }
                    if(newRequest[count].urgent ==0){
                        var strUrgent ="Pending";
                    }else if(newRequest[count].urgent ==1){
                        strUrgent ="Yes";
                    }else{
                        strUgent = "No";
                    }
                    
                    let information = `<h3> Employee ID: ${newRequest[count].employeeId}</h3>,
                                <h3>Request ID: ${newRequest[count].id},
                                <h3>Event ID: ${newRequest[count].eventId}</h3>, <h3>Location: 
                                ${newRequest[count].location}</h3>, <h3>Date: ${newRequest[count].date_time}</h3>,
                                <h3>Grade Format: ${newRequest[count].gradeFormat}</h3>, <h3>Description: 
                                ${newRequest[count].description}</h3>, <h3>Cost: ${newRequest[count].cost}</h3>,
                                <h3>Justification: ${newRequest[i].justification}, <h3>Direct Supervisor Approval: 
                                ${approval1}<h3>, <h3>Department Head Approval: ${approval2}</h3>, 
                                <h3>Benenfits Coordinator Approval: ${approval3},<h3> Urgent: ${strUrgent}</h3>`
                    
                    document.getElementById("result").innerHTML= information;

                }
            }
    }                   

    xhttp.open("GET","http://localhost:8080/TRMS/getAllRequest.do?employee.id="+employee.id, true);

    xhttp.send();

}
