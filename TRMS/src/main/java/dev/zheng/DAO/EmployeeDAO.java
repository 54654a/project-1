package dev.zheng.DAO;

import java.util.List;

import dev.zheng.employees.Employee;

public interface EmployeeDAO {
	
	public boolean addEmployee(Employee e);
	public List<Employee> getAllEmployees();
	public Employee getEmployee(int id);
	public boolean updateEmployee(Employee change);
	public boolean deleteEmployee(int deleteId);
	public int getDepartHead(int departId);
	public List<Employee> getEmployees(int supId);
	public List<Employee> getEmployeesSameDepart(int departId, int employeeId);
}
