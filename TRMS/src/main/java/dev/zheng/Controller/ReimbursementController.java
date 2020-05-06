package dev.zheng.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.zheng.employees.BalanceInfo;
import dev.zheng.employees.CoverageEvent;
import dev.zheng.employees.Reimbursement;
import dev.zheng.employees.Request;
import dev.zheng.service.BalanceService;
import dev.zheng.service.CoverageEventService;
import dev.zheng.service.ReimbursementService;
import dev.zheng.service.RequestService;

public class ReimbursementController {

	public static Gson gson = new Gson();
	
	public static void addReimbursement(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		Reimbursement re= gson.fromJson(request.getReader(), Reimbursement.class);
		Request r = RequestService.getRequest(re.getResimId());
		CoverageEvent ce =CoverageEventService.getCoverageEvent(r.getEventId());
		BalanceInfo bi = BalanceService.getBalance(r.getEmployeeId());
		double pending;
		double rate = ce.getCoverage();
		double total;
		double awarded;

		
		awarded = bi.getAwardedAmount();
		if(re.getExceeded()==1) {
			pending = r.getCost();
			total = pending+ awarded;
		}else {
			total = bi.getTotalAmount();
			if(re.getRequestState()=="stage2") {
				pending = total -awarded;
			}else {
				pending =  r.getCost() * rate;
			}
		}
		
		re.setEmployeeId(r.getEmployeeId());
		re.setTotal(total);
		re.setPendingAmount(pending);
		re.setAwardedAmount(awarded);
		re.setEventId(r.getEventId());
		ReimbursementService.addReimbursement(re);
		
		response.getWriter().append(gson.toJson(re));
	}
	
	public static void updateReimbursement(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		Reimbursement re = gson.fromJson(request.getReader(), Reimbursement.class);
		
		Reimbursement change = ReimbursementService.getReimbursement(re.getResimId());
		change.setRequestState(re.getRequestState());
		ReimbursementService.updateReimbursement(change);
		
		response.getWriter().append(gson.toJson(re));
		
	}
	
	public static void getReimbursement(HttpServletRequest request,
			HttpServletResponse response) throws IOException{

		List<Reimbursement> rList =ReimbursementService.getAllReimbursement();
		if(rList != null) {
			response.getWriter().append(gson.toJson(rList));
		}else {
			response.getWriter().append("{}");
		}
		
	}
	
	public static void getEmployeeReimbursement(HttpServletRequest request,
			HttpServletResponse response)throws IOException{
		String strId = request.getParameter("id");
		int employeeId =Integer.parseInt(strId);
		List<Reimbursement> rList =ReimbursementService.getEmployeeReimbursement(employeeId);
		if(rList != null) {
			response.getWriter().append(gson.toJson(rList));
		}else {
			response.getWriter().append("{}");
		}
	}
	
	public static void getReimbursementById(HttpServletRequest request,
			HttpServletResponse response)throws IOException{
		String strId = request.getParameter("id");
		System.out.println("this is in ger rei by id strId is: "+strId);
		int id = Integer.parseInt(strId);
		Reimbursement r = ReimbursementService.getReimbursement(id);
		if(r != null) {
			response.getWriter().append(gson.toJson(r));
		}else {
			response.getWriter().append("{}");
		}
		
	}
}
