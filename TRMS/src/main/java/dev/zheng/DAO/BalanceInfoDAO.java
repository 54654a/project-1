package dev.zheng.DAO;

import java.util.List;

import dev.zheng.employees.BalanceInfo;

public interface BalanceInfoDAO {

	public boolean addBalance(BalanceInfo b);
	public List<BalanceInfo> getAllBalance();
	public BalanceInfo getBalance(int employeeId);
	public boolean updateBalance(BalanceInfo change);
	public boolean deleteBalance(int deleteId);

}
