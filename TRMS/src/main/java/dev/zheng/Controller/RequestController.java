package dev.zheng.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.zheng.employees.Employee;
import dev.zheng.employees.Request;
import dev.zheng.service.EmployeeService;
import dev.zheng.service.RequestService;



public class RequestController {

	
	public static Gson gson= new Gson();
	
	public static void getRequest(HttpServletRequest request,
			HttpServletResponse response)throws 
		IOException, ServletException{
		
		String strId = request.getParameter("requestId");
		System.out.println("in get request: strId:" +strId);
		int id= Integer.parseInt(strId);
		Request r = RequestService.getRequest(id);	
		
		if(r!= null) {
			response.getWriter().append(gson.toJson(r));
		}else {
			response.getWriter().append("{}");
		}
		
	}
	
	public static void getEmployeesRequest(HttpServletRequest request,
			HttpServletResponse response)throws 
		IOException, ServletException{
		
		String employeeId = request.getParameter("employee.id");
		System.out.println("string id: "+ employeeId);
		int id = Integer.parseInt(employeeId);
		List<Request> rList = RequestService.getEmployeesRequest(id);
		System.out.println(rList);
		if(rList!= null) {
			response.getWriter().append(gson.toJson(rList));
		}
		
	}
	
	public static void getRequestByDepart(HttpServletRequest request,
			HttpServletResponse response)throws 
		IOException{
		String employeeId =request.getParameter("employeeId");
		String departId = request.getParameter("departId");
		int eId = Integer.parseInt(employeeId);
		int dId = Integer.parseInt(departId);
		List<Employee> eList = EmployeeService.getEmployeesSameDepart(dId, eId);
		List<Request> rList = new ArrayList<Request>();
		for(Employee e : eList) {
			if(RequestService.getEmployeeRequest(e.getId())!=null) {
				rList.add(RequestService.getEmployeeRequest(e.getId()));
			}
		}
		if(rList!= null) {
			response.getWriter().append(gson.toJson(rList));
		}		
	}
	
	public static void addRequest(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		
		Request r = gson.fromJson(request.getReader(), Request.class);
		System.out.println(r);
		RequestService.addRequest(r);
		
		response.getWriter().append(gson.toJson(r));
		
	}
	
	public static void getAllRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
	IOException{
		
		System.out.println("in the get all request");
		List<Request> rList = RequestService.getAllRequest();
		
		if(rList!= null) {
			response.getWriter().append(gson.toJson(rList));
		}else {
			response.getWriter().append("{}");
		}
	}
	
	public static void  getEmployeeRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		String  strUd = request.getParameter(
				"employeeId");
		int employeeId =Integer.parseInt(strUd);
		Request r = RequestService.getEmployeeRequest(employeeId);
		
		if(r!=null) {
			response.getWriter().append(gson.toJson(r));	
		}else
			response.getWriter().append("{}");
		
	}
	
	public static void updateRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		Request change = gson.fromJson(request.getReader(), Request.class);
		Request temp =RequestService.getRequest(change.getId());
		System.out.println("inside the updateRequest. change is:" +change);
		
		temp.setLevel1(change.getLevel1());
		temp.setLevel2(change.getLevel2());
		temp.setLevel3(change.getLevel3());
		temp.setLevel4(change.getLevel4());
		temp.setPassing(change.getPassing());
		System.out.println("inside the updateRequest. after changed. temp is:" + temp);
		
		System.out.println("value getting from web:" +change);
		RequestService.updateRequest(temp);
		
		response.getWriter().append(gson.toJson(temp));
	}
	
}
