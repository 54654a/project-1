package dev.zheng.service;

import java.util.List;

import dev.zheng.DAO.ReimbursementDAO;
import dev.zheng.DAO.ReimbursementDAOImpl;
import dev.zheng.employees.BalanceInfo;
import dev.zheng.employees.CoverageEvent;
import dev.zheng.employees.Reimbursement;
import dev.zheng.employees.Request;

public class ReimbursementService {
	
	public static ReimbursementDAO rd= new ReimbursementDAOImpl();
	
	public static boolean addReimbursement(Reimbursement r) {

		return rd.addReimbursement(r);

	}
	
	public static List<Reimbursement> getAllReimbursement(){
		return rd.getAllReimbursement();
	}
	
	public static Reimbursement getReimbursement(int id) {
		return rd.getReimbursement(id);
	}
	
	public static boolean updateReimbursement(Reimbursement change) {
		
		return rd.updateReimbursement(change);
	}
	
	public static boolean deleteReimbursement(int deleteId) {
		return rd.deleteReimbursement(deleteId);
	}
	
	public static List<Reimbursement> getEmployeeReimbursement(int employeeId){
		return rd.getEmployeeReimbursement(employeeId);
		
	}
	
	public static Reimbursement getAEmployeeReimbursement(int employeeId){
		return rd.getAEmployeeReimbursement(employeeId);
		
	}
	
}
