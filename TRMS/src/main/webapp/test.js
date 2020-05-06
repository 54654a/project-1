if(newRequest[count].level1 == 1){
    document.getElementById("approvalResult").innerHTML = "It has been approved already."
}else if(newRequest[count].level1 == -1){
    document.getElementById("approvalResult").innerHTML = "It has been denied already."
}
if(employee.id == employee2.supId){  
    confirmWin();
}else if(employee.titleId > 1){
    if(newRequest[count].level1 == 1){
        document.getElementById("approvalResult").innerHTML ="Still Pending for lower level to approve first.";
    }else if(newRequest[count].level2 == 1){
        document.getElementById("approvalResult").innerHTML = "It has been approved already."
    }else if(newRequest[count].level2 == -1){
        document.getElementById("approvalResult").innerHTML = "It has been denied already."
    }else{
        confirmWin();
    }
    if(employee.titleId > 2){

    }
}

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
                      
        