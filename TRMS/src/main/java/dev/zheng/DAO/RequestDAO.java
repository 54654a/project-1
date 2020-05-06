package dev.zheng.DAO;

import java.util.List;

import dev.zheng.employees.Request;

public interface RequestDAO {

	public boolean addRequest(Request r);
	public List<Request> getAllRequest();
	public Request getRequest(int id);
	public boolean updateRequest(Request change);
	public boolean deleteRequest(int deleteId);
	public Request getEmployeeRequest(int employeeId);

}
