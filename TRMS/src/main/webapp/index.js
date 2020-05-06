var employee={};
var loginState = false ;
var tableCount =1;
var msg ={};
var employeeMsg;


// below is for index.html

function eLogin(){
	
    let xhttp = new XMLHttpRequest();
    let eUser = document.getElementById("user").value;
    let ePass = document.getElementById("pass").value;

    var eBalance;
    xhttp.onreadystatechange = function(){
        if(this.readyState ==4 && this.status == 200){
            console.log(this.responseText);
            
            employee = JSON.parse(this.responseText);
            
            let information = `<h3 >Employee ID: ${employee.id}</h3>
                            <label > Employee Name: <br> ${employee.fName} ${employee.lName}</label>`
            
            document.getElementById("divL").innerHTML = information;
            //document.getElementById("divL").style.visibility="hidden";

            var employeeMsg;
            //getMsg();
            //document.getElementById("msgBar").innerHTML = employeeMsg;

            if(employee.titleId!=0){
                var list = document.getElementById("links");
                var a= document.createElement("a");
                var li= document.createElement("li");
                var link = document.createTextNode("Approve Form");
                a.appendChild(link);
                a.href="approvalForm.html";
                
                li.appendChild(a);
                list.appendChild(li);
            }


            loginState =true;
            document.getElementById("form").href="form.html";
            var list = document.getElementById("links");
            var a= document.createElement("a");
            var li= document.createElement("li");
            var link = document.createTextNode("Sign Out");
            a.appendChild(link);
            a.href="index.html";
            li.appendChild(a);
            list.appendChild(li);

            // xhttpB = new XMLHttpRequest();
            
            // xhttpB.onreadystatechange=function(){
            //     if(this.readyState ==4 && this.status ==200){
            //         console.log(this.responseText);
            //         eBalance = JSON.parse(this.responseText);


            //          let infoList = `<ol id="list">
            //         <li>Total Balance: </li>
            //         <li>Awarded Balance: </li>
            //         <li>Available Balance: </li>
            //         <li>Last Update: </li>
            //         </ol>`;
            //         let resultList = `<ol id="list">
            //         <li>${eBalance.totalAmount}</li>
            //         <li>${eBalance.awardedAmount}</li>
            //         <li>${eBalance.availAmount}</li>
            //         <li>${eBalance.lastestDate}</li>
            //         </ol>`;
            //         document.getElementById("divB").innerHTML += infoList;
            //         document.getElementById("divB").innerHTML +=resultList;
            //     }
            // }
            // xhttpB.open("GET","http://localhost:8080/TRMS/getBalanceInfo.do?employeeId=1"+
            // employee.id,true);
            // xhttpB.send();

            sessionStorage.setItem("e1", JSON.stringify(employee));
        }
        
        //else{
          //  alert("bad login information, \n try again");
           // window.open("index.html");
        //}
    }
    //document.getElementById("divS").style.visibility="visible";
    url = "http://localhost:8080/TRMS/employeeLogin.do?user="
            +eUser+"&pass="+ePass;

    xhttp.open("GET", url, true);
    xhttp.send();
    //isSupLevelUp();
    
}

if(loginState==true){
    if(e.titleId!= 0){
        var list = document.getElementById("links");
        var a= document.createElement("a");
        var li= document.createElement("li");
        var link = document.createTextNode("Sign Out");
        a.appendChild(link);
        a.href="index.html";
        li.appendChild(a);
        list.appendChild(li);
    }
}


function backtoMain(){
    loginState =true;
    //getMsg();
    let information = `<h3 >Employee ID: ${employee.id}</h3>
         <label > Employee Name: <br> ${employee.fName} ${employee.lName}</label>`
            
    document.getElementById("result").innerHTML = information;
    document.getElementById("result").innerHTML += employeeMsg;
}

function isSupLevelUp(){
    if(employee.titleId!=0){
        var list = document.getElementById("links");
        var a= document.createElement("a");
        var li= document.createElement("li");
        var link = document.createTextNode("Approve Form");
        a.appendChild(link);
        a.href="approvalForm.html";
        
        //a.href="javascript:;";
        //a.onclick=()=>{
          //  window.open("approvalForm.html",'popup','width=600, height=630, scrollbars=no,resizable=no',false);
        //};
        li.appendChild(a);
        list.appendChild(li);
    }
}

function checkLogin(){
    if(this.loginState ==true){
        document.getElementById("form").href="form.html";
    }else{
        document.getElementById("form").href="#";
        alert("Please Login first in order to access that Page");
    }
}


/**above is for index.html */

/**below is for form.html */
function loadInfo(){
	console.log("inside load info");
    document.getElementById("fName").value= employee.fName;
    document.getElementById("lName").value=employee.lName;
    document.getElementById("eId").value=employee.id;
}

function resetForm(){
    document.getElementById("fName").value= employee.fName;
    document.getElementById("lName").value=employee.lName;
    document.getElementById("eId").value=employee.id;
    document.getElementById("location").value="";
    document.getElementById("time").value="";
    document.getElementById("des").value="";
    document.getElementById("cost").value="";
    document.getElementById("check1").checked=false;
    document.getElementById("check2").checked=false;
    document.getElementById("check3").checked=false;
    document.getElementById("eventId").value=1;
    document.getElementById("des2").value="";
}

function requestForm(){

    let request={};

    let checkRadio = document.querySelector( 
        'input[name="format"]:checked'); 

    request.employeeId = document.getElementById("eId").value;
    request.eventId= document.getElementById("eventId").value;
    request.gradeFormat =checkRadio.value;
    request.location = document.getElementById("location").value;
    var futureDate = document.getElementById("date");
    request.datetime = document.getElementById("date").value;
   // request.datetime += document.getElementById("time").value;  
    request.description= document.getElementById("des").value;
    request.justification= document.getElementById("des2").value;
    request.cost = document.getElementById("cost").value;
    let currentDate = new Date();
    let timeDiff = Math.abs(futureDate.valueAsNumber-currentDate.getTime());
    let diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
    if(diffDays < 14){
        request.urgent ="Yes";
    }else{
        request.urgent= "No";
    }
    
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange =function(){
        if(this.readyState ==4 && this.status == 200){
            console.log(this.responseText);
        }
    }
    
    
    //url = "http://localhost:8080/TRMS/addRequest.do?employeeID=" +request.employeeId+
    //"eventId="+request.eventId+"urgent="+request.urgent+"gradeFormat="+request.gradeFormat+
    //"location="+request.location+"datetime="+request.datetime+"description="+
    //request.description+"justification="+request.justification+"cost="+request.cost;

    url = "http://localhost:8080/TRMS/addRequest.do";

    xhttp.open("POST",url,true);

    xhttp.setRequestHeader('Context-Type','application/json');

    let request1={
        employeeId: request.employeeId,
        eventId: request.eventId,
        urgent: request.urgent,
        gradeFormat: request.gradeFormat,
        location: request.location,
        datetime: request.datetime,
        description: request.description,
        justification: request.justification,
        cost: request.cost
    }


    xhttp.send(JSON.stringify(request1));

    alert("Form has been submitted");
    resetForm();
}
/**above is for form.html */


/**below is for approvalForm.html */
//moved
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


//moved
function a1(){
    if(count==0){
        b.style.visibility ="visible";
    }
    displayR();
    count++;
}
//moved
function b1(){
    displayR();
    count++;
}

//moved to app form
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

//moved to app Form
function isRightPerson(){
    xhttp = new XMLHttpRequest();
    var employee2
    xhttp.onreadystatechange =function(){
        if(this.readyState ==4 && this.status ==200){
            console.log(this.responseText);
            employee2 = JSON.parse(this.responseText);
        }       
    }
    let urlR;
    if(employee.titleId == 1 || employee.titleId ==3 ){
        let eId = newRequest[count].employeeId;
        urlR = "http://localhost:8080/TRMS/getEmployee.do?newRequest[count].employeeId="+
            eId;
        
    }else if(employee.titleId == 2){

        urlR = "http://localhost:8080/TRMS/getDepartHead.do?employee.departId="
            +employee.departId;

    }
    xhttp.open("GET", urlR, true);

    xhttp.send();

    if(employee.employeeId == employee2.supId){
        if(newRequest[count].level1 == 0){
            confirmWin();
        }else if(newRequest[count].level1 == 1){
            document.getElementById("approvalResult").innerHTML = "It has been approved already."
        }else{
            document.getElementById("approvalResult").innerHTML = "It has been denied already."
        }
    }else if(employee.employeeId == employee2.employeeId){
        if(newRequest[count].level1 != -1){
        
            if(newRequest[count].level1 == 0 ){
                document.getElementById("approvalResult").innerHTML ="still Pending for lower level to approve first.";
            }else{
                confirmWin();
            }         
        }else{
            document.getElementById("approvalResult").innerHTML ="This request has been denied already";
        }
    }
    if(employee.titleId ==4){
        if(newRequest[count].level1 == 0 || newRequest[count].level2 == 0)
        {
            document.getElementById("approvalResult").innerHTML ="still Pending for lower level to approve first.";
        }else{
            confirmWin();

        }
    }else if(employee.titleId ==5){

    }

}

//moved to appForm
function confirmWin(){
    var answer = prompt("DO you want to approve this request?(Yes/No/wait)");
    let temp = answer.toLowerCase();
    if(temp =="yes"){
        if(employee.titleId == 1){
            newRequest[count].level1 = 1;

        }else if(employee.titleId ==2){
            newRequest[count].level2 =1;

        }else if(employee.titleId ==3){
            newRequest[count].level1 =1;
            newRequest[count].level2 =1;

        }else if(employee.titleId ==4){

            newRequest[count].level3 =1;

        }
    }else if(temp =="no"){
        newRequest[count].level1 = -1;
        newRequest[count].level2 = -1;
        newRequest[count].level3 = -1;
    }else{
        newRequest[count].level1 = 0;
    }
    document.getElementById("approvalResult").innerHTML="This request has been changed to "
    + temp+ "stage.";

    let xhttp1 = new XMLHttpRequest();
    xhttp1.onreadystatechange =function(){
        if(this.readyState ==4 && this.status ==200){
            console.log(this.responseText);
        }

    }
    let url="http://localhost:8080/TRMS/updateRequest.do";
    xhttp1.open("POST", url, true);

    xhttp1.setRequestHeader('Context-Type','application/json');

    xhttp1.send(JSON.stringify(request));

    addReimbursement();

}

//moved to appForm
function getAllReimbursement(){
    window.open("result.html",'popup','width=980, height=600, scrollbars=no,resizable=no',false);
    Reimbursment;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState ==4 && this.status ==200){
            console.log(this.responseText);
            Reimbursement = JSON.parse(this.responseText);
            var rList;
            for(i =0; i< Reimbursement.length; i++ ){
                rList +=`<tr>
                <td>Reimbursement[i].resimId</td>
                <td>Reimbursement[i].eventId</td>
                <td>Reimbursement[i].employeeId</td>
                <td>Reimbursement[i].total</td>
                <td>Reimbursement[i].pendingAmount</td>
                <td>Reimbursement[i].awardedAmount</td>
                <td>Reimbursement[i].exceeded</td>
                <td>Reimbursement[i].date</td>
                <td>Reimbursement[i].requestState</td>
                <td><button on click="approveRei()">Approve this</button></td>
                </tr>`;
            }
            document.getElementById("resultTable").innerHTML += rList;
        }        
    }

    xhttp.open("GET","http://localhost:8080/TRMS/getAllReimbursement.do", true);
    xhttp.send();
}

//moved
function getBalanceInfo(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState ==4 & this.status==200){
            console.log(this.responseText);
            employeeBalance = this.responseText;
        }
    }

    let url ="http://localhost:8080/TRMS/getBalanceInfo.do?newRequest[count].employeeId="+
                newRequest[count].employeeId;

    xhttp.open("GET",url, true);
    xhttp.send();

}


//moved
function getEventCoverage(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState ==4 & this.status==200){
            console.log(this.responseText);
            coverageInfo = this.responseText;
        }
    }

    let url ="http://localhost:8080/TRMS/getCoverageEvent.do?newRequest[count].eventId="+
                newRequest[count].eventId;

    xhttp.open("GET",url, true);
    xhttp.send();
}

//moved to appForm
function addReimbursement(){
    var employeeBalance;
    var resState;
    getBalanceInfo();
    getEventCoverage();
    let tempAmount = (newRequest[count].cost * coverageInfo.coverage);
    if(employeeBalance.availAmount < tempAmount){
        var r =confirm("Cost has exceeded the available amount.\n"  +
        "Do you want to override that?");
        if(r==true){
            newRequest[count].cost =newRequest[count].cost;
            resState = "finalStage";
        }else{
            //need to update the request later
            resState ="stage2";           
            addMsg();
        }
    }
    let xhttp2 = new XMLHttpRequest();
    xhttp2.onreadystatechange = function(){
        if(this.readyState ==4 & this.status==200){
            console.log(this.responseText);
        }
    }

    let url ="http://localhost:8080/TRMS/addReimbursement.do?newRequest[count].employeeId="+
                newRequest[count].employeeId+"&resState="+resState+"&employeeBalance.availAmount="+
                employeeBalance.availAmount;

    xhttp2.open("POST",url, true);
    xhttp2.setRequestHeader('Context-Tyep','application/json' );
    xhttp2.send(JSON.stringify(newRequest[count]));
}

function addMsg(){
    let tempMsg;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState ==4 & this.status==200){
            console.log(this.responseText);
            tempMsg.employeeId = newRequest[count].employeeId;
            tempMsg.msgInfo = "Your cost has been lower to the available amount."
            tempMsg.senderId = employee.id;
        }
    }

    let url ="http://localhost:8080/TRMS//TRMS/addMsg.do?newRequest[count].employeeId="+
                newRequest[count].employeeId;

    xhttp.open("POST",url, true);
    xhttp.setRequestHeader('Context-Tyep','application/json' );
    xhttp.send(JSON.stringify(tempMsg));
}

function getMsg(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState ==4 & this.status==200){
            console.log(this.responseText);
            msg = JSON.parse(this.responseText);
//if(msg == undefined || msg == "{}" || msg == "[]"){
  //              employeeMsg ="there is no message";
    //        }else{
                for( let i =0 ; i< msg.length ; i++){
                    employeeMsg +=`<p onclick="popUpWin()">"Message Id: ${msg[i].msgId}
                     ${msg[i].msg}          ${msg[i].msgTime}           ${msg[i].readState}    
                     from ${msg[i].senderId}</p>`;
                }
      //      }
         //   document.getElementById("msgBar").innerHTML=employeeMsg;
        }
    }

    let url ="http://localhost:8080/TRMS/getMsg.do?employee.id="+
                employee.id;
    xhttp.open("GET",url, true);
    xhttp.send();    
}

function popUpWin(){
    let divInfo=`let conMsg = confirm("Do you want to cancel this request?");
    if(conMsg== true){
        var requestState ="Cancelled";
    }else{
        requestState ="finalStage";
    }`
    document.getElementById("divL").innerHTML =divInfo;
    
}

function subGrade(){
    window.open("subtmitResult.html",'popup','width=600, height=600, scrollbars=no,resizable=no',false);
}