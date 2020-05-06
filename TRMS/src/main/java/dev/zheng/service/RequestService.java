package dev.zheng.service;



import java.util.ArrayList;
import java.util.List;

import dev.zheng.DAO.RequestDAO;
import dev.zheng.DAO.RequestDAOImpl;
import dev.zheng.employees.Employee;
import dev.zheng.employees.Request;

public class RequestService {

	public static RequestDAO red = new RequestDAOImpl();
	
	public static boolean addRequest(Request r) {
		return red.addRequest(r);
	}
	
	public static List<Request> getAllRequest(){
		return red.getAllRequest();
	}
	
	public static Request getRequest(int id) {
		return red.getRequest(id);
	}
	
	public static boolean updateRequest(Request change) {
		return red.updateRequest(change);
	}
	
	public static boolean deleteRequest(int deleteId) {
		return red.deleteRequest(deleteId);
	}
	
	public static Request getEmployeeRequest(int employeeId){
		return red.getEmployeeRequest(employeeId);
		
	}
	
	public static List<Request> getEmployeesRequest(int employeeId){
		List<Employee> eList=EmployeeService.getEmployees(employeeId);
		List<Request> rList=new ArrayList<Request>();
		for(Employee e: eList) {
			if(red.getEmployeeRequest(e.getId())!=null) {
				rList.add(red.getEmployeeRequest(e.getId()));
			}
		}		
		return rList;
	}
}
