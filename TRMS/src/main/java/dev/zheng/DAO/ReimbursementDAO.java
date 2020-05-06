package dev.zheng.DAO;

import java.util.List;

import dev.zheng.employees.Reimbursement;

public interface ReimbursementDAO {

	public boolean addReimbursement(Reimbursement r);
	public List<Reimbursement> getAllReimbursement();
	public Reimbursement getReimbursement(int id);
	public boolean updateReimbursement(Reimbursement change);
	public boolean deleteReimbursement(int deleteId);
	public List<Reimbursement> getEmployeeReimbursement(int employeeId);
	public Reimbursement getAEmployeeReimbursement(int employeeId);
	
}
