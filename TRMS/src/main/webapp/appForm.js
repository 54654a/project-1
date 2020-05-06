var a;
var b;
var c;
var d;
var max;
var eId;
var employee =JSON.parse(sessionStorage.getItem("e1"));
var Reimbursment;
var moreInfo;

function loadingInfo(){
    employee =JSON.parse(sessionStorage.getItem("e1"));
    document.getElementById("userId").innerHTML =employee.id;
    let fullname = employee.fName + " "+employee.lName;
    document.getElementById("userName").innerHTML = fullname;
}

console.log(employee);
function makeButtons(){

    a= document.createElement("BUTTON");
    a.innerHTML="previous";
    a.id= "previous";
    a.onclick=()=>{
        console.log("in the previous button, count= "+ count);
        count--;
        if(count>=0){
            displayR();
        }else{
            alert("this is end of the list");
            count =0;
        }
    };
    
    document.getElementById("buttons").appendChild(a);
   
    b= document.createElement("BUTTON");
    b.innerHTML="Next";
    b.id= "next";
    b.onclick=()=>{
        console.log("in the next button, count= "+ count);
        count++;
        if(count<max){
            displayR();
        }else{
            alert("this is top of the list");
            count = max-1;
        }
    };
    document.getElementById("buttons").appendChild(b);

    c = document.createElement("BUTTON");
    c.innerHTML="Approve this";
    c.id = "approveB";
    c.onclick =()=>{
        xhttp = new XMLHttpRequest();
        var urlR;
        xhttp.onreadystatechange =function(){            
            if(this.readyState ==4 && this.status ==200){
                console.log(this.responseText);

                var employee2 = JSON.parse(this.responseText);


                console.log("this is employee title id : "+ employee.titleId);
                console.log("this is siged in ID: " +employee.id);
                console.log("this is 2nd sup id: " +employee2.supId);



                if(employee.id == employee2.supId){                    
                    if(newRequest[count].level1 == 0){
                        confirmWin();
                    }else if(newRequest[count].level1 == 1){
                        document.getElementById("approvalResult").innerHTML = "It has been approved already."
                    }else{
                        document.getElementById("approvalResult").innerHTML = "It has been denied already."
                    }
                }else if(employee.titleId ==2){
                    if(newRequest[count].level1 != 1){                
                        if(newRequest[count].level1 == 0 ){
                            document.getElementById("approvalResult").innerHTML ="Still Pending for lower level to approve first.";
                        }else{
                            if(newRequest[count].level2==-1){
                                document.getElementById("approvalResult").innerHTML = "It has been denied already."
                            }else if(newRequest[count].level2 == 1){
                                document.getElementById("approvalResult").innerHTML = "It has been approved already."
                            }else{
                                confirmWin(); 
                            }
                        }         
                    }else{
                        document.getElementById("approvalResult").innerHTML ="This request has been denied already";
                    }
                }else if(employee.titleId ==3){
                    if(newRequest[count].level1 == -1){
                        document.getElementById("approvalResult").innerHTML = "It has been denied already."
                    }else if(newRequest[count].level1 == 0){
                        confirmWin();
                    }else{
                        document.getElementById("approvalResult").innerHTML = "It has been approved already."
                    }
                }else if(employee.titleId ==4){
                    if(newRequest[count].level1 == 0){
                        document.getElementById("approvalResult").innerHTML ="still Pending for lower level to approve first.";
                    }else if( newRequest[count].level2 == 0){
                    
                        document.getElementById("approvalResult").innerHTML ="still Pending for lower level to approve first.";

                    }else if(newRequest[count].level3 == 1){
                        document.getElementById("approvalResult").innerHTML = "It has been approved already."
                    }else{
                        console.log("outside confirmWin at arppove this");
                        confirmWin();
        
                    }
                }      
            }            
        }
        console.log(" outside this is request employee oid :"+ newRequest[count].employeeId);
        if(employee.titleId != 2 ){
            console.log(" inside this is request employee oid :"+ newRequest[count].employeeId);
            urlR = "http://localhost:8080/TRMS/getEmployee.do?employeeId="+
                newRequest[count].employeeId;
                
        }else{
        
            urlR = "http://localhost:8080/TRMS/getDepartHead.do?employee.departId="
                +employee.departId;       
        }
        console.log(urlR);
        xhttp.open("GET", urlR, true);

        xhttp.send();
    
    };
    document.getElementById("buttons").appendChild(c);


    if(employee.titleId ==1 || employee.titleId ==4){
        d = document.createElement("button");
        d.innerHTML="Check Reimbursment ";
        d.id= "checkRei";
        d.onclick=()=>{
            window.open("result.html",'popup','width=980, height=600, scrollbars=no,resizable=no',false);           
        };
        document.getElementById("buttons").appendChild(d);        
    }
}

function displayR(){
    if(newRequest[count].level1 == 1){
        var approval1 = "Yes";
    }else if(newRequest[count].level1 == 0){
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
        var strUrgent ="No";
    }else if(newRequest[count].urgent ==1){
        strUrgent ="Yes";
    }
    eId = newRequest[count].employeeId;
    let information = `<p> Employee ID: ${newRequest[count].employeeId}</p>
                <h3>Request ID: ${newRequest[count].id}</h3>
                <h3>Event ID: ${newRequest[count].eventId}</h3>
                <h3>Location: ${newRequest[count].location}</h3>
                <h3>Date: ${newRequest[count].datetime}</h3>
                <h3>Grade Format: ${newRequest[count].gradeFormat}</h3>
                <h3>Description: ${newRequest[count].description}</h3>
                <h3>Cost: ${newRequest[count].cost}</h3>
                <h3>Justification: ${newRequest[count].justification}</h3>
                <h3>Direct Supervisor Approval: ${approval1}<h3>
                <h3>Department Head Approval: ${approval2}</h3> 
                <h3>Benenfits Coordinator Approval: ${approval3}</h3>
                <h3> Urgent: ${strUrgent}</h3>`
    document.getElementById("result").innerHTML= information;

}
function checkRequest(){
    newRequest={};
    employee =JSON.parse(sessionStorage.getItem("e1"));
    let xhttp =  new XMLHttpRequest();
    xhttp.onreadystatechange =function(){
            if(this.readyState ==4 && this.status ==200){
                console.log(this.responseText);
                
                count = 0;
                newRequest = JSON.parse(this.responseText);
                console.log("0: "+newRequest[0]);
                console.log("1: "+newRequest[1]);
                console.log("2: "+newRequest[2]);
                max = newRequest.length;

                makeButtons();
                displayR();                
            }
    }                   

    let url;
    if(employee.titleId==1){
        url ="http://localhost:8080/TRMS/getEmployeesRequest.do?employee.id="+employee.id;
    }else if(employee.titleId ==2 || employee.titleId ==3){
        url ="http://localhost:8080/TRMS/getRequestByDepart.do?employeeId="+employee.id+"&departId="+employee.departId;
    }
    else{
        url="http://localhost:8080/TRMS/getAllRequest.do";
    }

    xhttp.open("GET",url, true);

    xhttp.send();

}

function confirmWin(){
    var answer = prompt("Do you want to approve this request?(Yes/No/request more info)")
    let temp =answer.toLowerCase();
    if(temp =="yes"){
        if(employee.titleId == 1){
            console.log("in title 1");
            newRequest[count].level1 = "1";
            console.log("after approval: "+ newRequest[count].level1);

        }else if(employee.titleId ==2){
            console.log("in title 2");
            newRequest[count].level2 =1;

        }else if(employee.titleId ==3){
            console.log("in title 3");
            newRequest[count].level1 =1;
            newRequest[count].level2 =1;

        }else if(employee.titleId ==4){
            console.log("in title 4");
            newRequest[count].level3 =1;
        }
    }else if(temp =="no"){
        newRequest[count].level1 = -1;
        newRequest[count].level2 = -1;
        newRequest[count].level3 = -1;
    }else{
        temp = "Pending-2";
        newRequest[count].level1 = 0;
        moreInfo= prompt("What information are you requesting for ?");
        addMsg();
        confirm("Message has beent sent");

    }
    document.getElementById("approvalResult").innerHTML="This request has been changed to "
    + temp+ " stage.";

    let request = newRequest[count];
    console.log("ready to send out l1: " + newRequest[count].level1);
    console.log("ready to send out l2: " + newRequest[count].level1);
    console.log("ready to send out l3: " + newRequest[count].level1);

    let xhttp1 = new XMLHttpRequest();
    xhttp1.onreadystatechange =function(){
        if(this.readyState ==4 && this.status ==200){
            console.log(this.responseText);
        }
    }
    let url = "http://localhost:8080/TRMS/updateRequest.do";

    xhttp.open("POST",url,true);

    xhttp.setRequestHeader('Context-Type','application/json');

    let request1={
        id: request.id,
        level1: newRequest[count].level1,
        level2: newRequest[count].level2,
        level3: newRequest[count].level3,
        level4: newRequest[count].level4,
        passing: newRequest[count].passing
    }
    xhttp.send(JSON.stringify(request1));

    if(newRequest[count].level1 == 1 && newRequest[count].level2 == 1 && newRequest[count].level3 == 1){
        addReimbursement();
    }
}


//moved to other function
function getAllReimbursement(){
    window.open("result.html",'popup','width=980, height=600, scrollbars=no,resizable=no',false);
    var Reimbursement={};
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

function addReimbursement(){
    var resState;
    var override;
    var rate;
    var cost = newRequest[count].cost;
    var availAmount;
    getBalanceInfo();
    getEventCoverage();
    

    let tempAmount = ( cost* rate);
    if(availAmount < tempAmount){
        var r =confirm("Cost has exceeded the available amount.\n"  +
        "Do you want to override that?");
        if(r==true){
            resState = "finalStage";
            override =1;
        }else{
            resState ="stage2";  
            override =-1;         
            addMsg();
        }
    }else{
        resState = "finalStage";
        override =-1; 
    }
    let xhttp2 = new XMLHttpRequest();
    xhttp2.onreadystatechange = function(){
        if(this.readyState ==4 & this.status==200){
            console.log(this.responseText);
        }
    }
    let rId = newRequest[count].id;
    let employeeId = newRequest[count].employeeId;
    let url ="http://localhost:8080/TRMS/addReimbursement.do?employeeId="+
                employeeId+"&resState="+resState+"&availAmount="+
                availAmount;

    xhttp2.open("POST",url, true);
    xhttp2.setRequestHeader('Context-Type','application/json' );
    let result={
        resimId: rId,
        requestState: resState,
        exceeded: override
    };
    xhttp2.send(JSON.stringify(result));
}

function addMsg(){
    let xhttp = new XMLHttpRequest();
    let eId = newRequest[count].employeeId;
    let msg = moreInfo;
    let sId = employee.id;
    xhttp.onreadystatechange = function(){
        if(this.readyState == 4 && this.status==200){
            console.log(this.responseText);
        }
    }

    let url ="http://localhost:8080/TRMS/addMsg.do";
    
    xhttp.open("POST",url, true);
    xhttp.setRequestHeader('Context-Type','application/json' );
    let tempMsg={
        employeeId: eId,
        msg: msg,
        senderId: sId
    };
    xhttp.send(JSON.stringify(tempMsg));

}

function refresh(){
    location.reload();
}

function getBalanceInfo(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState ==4 & this.status==200){
            console.log(this.responseText);
           let  employeeBalance = JSON.parse(this.responseText);
            availAmount = employeeBalance.availAmount;
        }
    }

    let url ="http://localhost:8080/TRMS/getBalanceInfo.do?employeeId="+
                newRequest[count].employeeId;

    xhttp.open("GET",url, true);
    xhttp.send();

}

function getEventCoverage(){
    let coverageInfo;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState ==4 & this.status==200){
            console.log(this.responseText);
            coverageInfo = JSON.parse(this.responseText);
            rate = coverageInfo.coverage;
        }
    }
    let url ="http://localhost:8080/TRMS/getCoverageEvent.do?eventId="+
                newRequest[count].eventId;

    xhttp.open("GET",url, true);
    xhttp.send();
    
}
