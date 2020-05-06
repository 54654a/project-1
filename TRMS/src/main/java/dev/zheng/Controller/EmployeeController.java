package dev.zheng.Controller;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.zheng.employees.Employee;
import dev.zheng.service.EmployeeService;

public class EmployeeController {

	public static Gson gson = new Gson();
	
	public static void employeeLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		
		Employee login = EmployeeService.loginEmployee(username, password);
		if(login != null) {
			response.getWriter().append(gson.toJson(login));
		}else
			response.getWriter().append("{}");
			
	}	
	
	public static void getEmployeeById(HttpServletRequest request,
			HttpServletResponse response)throws IOException{
		String id = request.getParameter(
				"employeeId");
		System.out.println("getting employeeId from web: " +id);
		int employeeId = Integer.parseInt(id);
		Employee selectEmployee = EmployeeService.getEmployee(employeeId);
		
		if(selectEmployee != null) {
			response.getWriter().append(gson.toJson(selectEmployee));
		}else
			response.getWriter().append("{}");
		
	}
	
	public static void getDepartHead(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		String departId=request.getParameter(
				"employee.departId");
		System.out.println("this is departId: "+departId);
		Employee sup = EmployeeService.getDepartHead(Integer.parseInt(departId));
		
		if(sup != null) {
			response.getWriter().append(gson.toJson(sup));
		}else {
			response.getWriter().append("{}");
		}	
	}
}
