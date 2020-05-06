package dev.zheng.service;

import java.util.List;

import dev.zheng.DAO.EmployeeDAO;
import dev.zheng.DAO.EmployeeDAOImpl;
import dev.zheng.employees.Employee;

public class EmployeeService {

	public static EmployeeDAO ed = new EmployeeDAOImpl();
	
	public static boolean addEmployee(Employee e) {
		return ed.addEmployee(e);
	}
	
	public static List<Employee> getAllEmployee(){
		return ed.getAllEmployees();
	}
	
	public static Employee getEmployee(int id) {
		return ed.getEmployee(id);
	}
	
	public static boolean updateEmployee(Employee change) {
		return ed.updateEmployee(change);
	}
	
	public static boolean deleteEmployee(int deleteId) {
		return ed.deleteEmployee(deleteId);
	}
	
	public static Employee getDepartHead(int departId) {
		int id = ed.getDepartHead(departId);	
		return ed.getEmployee(id);
	}
	
	public static Employee loginEmployee(String username, String password) {
		List<Employee> eList = getAllEmployee();
		int id=0;
		for( int i = 0 ;i<eList.size();i++) {
			if(eList.get(i).getUsername().equals(username)) {
				if(eList.get(i).getPassword().equals(password))
					id =eList.get(i).getId();
			}
		}
		Employee temp = getEmployee(id);
		return temp;

	}
	
	public static List<Employee> getEmployees(int supId){
		return ed.getEmployees(supId);	
	}
	
	public static List<Employee> getEmployeesSameDepart(int departId, int employeeId){
		return ed.getEmployeesSameDepart(departId, employeeId);
	}
	
}
