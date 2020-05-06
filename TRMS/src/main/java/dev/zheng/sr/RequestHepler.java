package dev.zheng.sr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.zheng.Controller.BalanceInfoController;
import dev.zheng.Controller.CoverageEventController;
import dev.zheng.Controller.EmployeeController;
import dev.zheng.Controller.MsgCenterController;
import dev.zheng.Controller.ReimbursementController;
import dev.zheng.Controller.RequestController;
import dev.zheng.service.ReimbursementService;

public class RequestHepler {
	
	public static void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		
		String uri =request.getRequestURI();
		
		switch(uri) {
		
			case "/TRMS/test.do": 
				response.getWriter().append("test");
				response.setStatus(200);
				break;
			
			case "/TRMS/employeeLogin.do":
				EmployeeController.employeeLogin(request,response);
				break;
				
			case "/TRMS/getEmployeeReimbursement.do":
				ReimbursementController.getEmployeeReimbursement(request, response);
				break;
				
			case "/TRMS/getEmployeesRequest.do":
				RequestController.getEmployeesRequest(request, response);
				break;
				
			case"/TRMS/getRequestByDepart.do":
				RequestController.getRequestByDepart(request, response);
				break;
				
			case "/TRMS/getAllRequest.do":
				RequestController.getAllRequest(request, response);
				break;
				
			case "/TRMS/getDepartHead.do":
				EmployeeController.getDepartHead(request, response);
				break;
				
			case "/TRMS/getEmployee.do":
				EmployeeController.getEmployeeById(request, response);
				break;
				
			case "/TRMS/getRequest.do":
				RequestController.getRequest(request, response);
				break;
				
			case "/TRMS/updateRequest.do":
				RequestController.updateRequest(request, response);
				break;
				
			case "/TRMS/getEmployeeRequest.do":
				RequestController.getEmployeeRequest(request, response);
				break;
				
			case "/TRMS/addRequest.do":
				RequestController.addRequest(request, response);
				break;
				
			case "/TRMS/addReimbursement.do":
				ReimbursementController.addReimbursement(request, response);
				break;
				
			case "/TRMS/updateReimbursement.do":
				ReimbursementController.updateReimbursement(request, response);
				break;
			
			case "/TRMS/getAllReimbursement.do":
				ReimbursementController.getReimbursement(request, response);
				break;
				
			case "/TRMS/getReimbursementById.do":
				ReimbursementController.getReimbursementById(request, response);
				break;
				
			case "/TRMS/getBalanceInfo.do":
				BalanceInfoController.getBalanceInfo(request, response);
				break;
				
			case "/TRMS/updateEmployeeBalance.do":
				BalanceInfoController.updateEmployeeBalance(request, response);
				break;
				
			case "/TRMS/getCoverageEvent.do":
				CoverageEventController.getCoverageEvent(request, response);
				break;
				
			case "/TRMS/addMsg.do":
				MsgCenterController.addMsg(request, response);
				break;
			
			case "/TRMS/updateMsg.do":
				MsgCenterController.updateMsg(request, response);
				break;
				
			case "/TRMS/getMsg.do":
				MsgCenterController.getMsgCenter(request, response);
				break;
				
				
			default: 
				response.sendError(400,"Something went wrong, please "
						+ "reboot your pc");
				break;
		}
			
		
		
		
		
	}
}
