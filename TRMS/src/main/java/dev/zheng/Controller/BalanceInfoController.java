package dev.zheng.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.zheng.employees.BalanceInfo;
import dev.zheng.service.BalanceService;

public class BalanceInfoController {
	
	public static Gson gson = new Gson();
	public static void getBalanceInfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException{

		String id =request.getParameter(
				"employeeId");
		int employeeId = Integer.parseInt(id);
		BalanceInfo r =BalanceService.getBalance(employeeId);
		
		if(r != null) {
			response.getWriter().append(gson.toJson(r));
		}else {
			response.getWriter().append("{}");
		}
		
	}
	
	public static void updateEmployeeBalance(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		BalanceInfo bi = gson.fromJson(request.getReader(),
				BalanceInfo.class);
		
		BalanceService.updateBalance(bi);
		response.getWriter().append(gson.toJson(bi));
		
		
	}
}
