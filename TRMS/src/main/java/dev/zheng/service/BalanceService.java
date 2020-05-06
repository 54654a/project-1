package dev.zheng.service;

import java.util.List;

import dev.zheng.DAO.BalanceInfoDAO;
import dev.zheng.DAO.BalanceInfoDAOImpl;
import dev.zheng.employees.BalanceInfo;
import dev.zheng.employees.Reimbursement;

public class BalanceService {

	public static BalanceInfoDAO bd = new BalanceInfoDAOImpl();
	
	
	public static boolean addBalance(BalanceInfo b) {
		return bd.addBalance(b);
	}
	public static List<BalanceInfo> getAllBalance(){
		return bd.getAllBalance();
	}
	public static BalanceInfo getBalance(int employeeId) {
		return bd.getBalance(employeeId);
	}
	public static boolean updateBalance(BalanceInfo change) {
		Reimbursement rei = ReimbursementService.getAEmployeeReimbursement(
				change.getEmployeeId());
		double awarded = rei.getAwardedAmount() + rei.getPendingAmount();
		double total = rei.getTotalReimbursement();
		double avail = total - awarded;
		if(avail< 0) {
			avail = 0;
		}				
		change.setTotalAmount(total);
		change.setAvailAmount(avail);
		change.setAwardedAmount(awarded);		
		
		return bd.updateBalance(change);
	}
	public static boolean deleteBalance(int deleteId) {
		return bd.deleteBalance(deleteId);
	}
}
