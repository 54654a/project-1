import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dev.zheng.DAO.EmployeeDAO;
import dev.zheng.DAO.EmployeeDAOImpl;
import dev.zheng.employees.BalanceInfo;
import dev.zheng.employees.Employee;
import dev.zheng.employees.Reimbursement;
import dev.zheng.service.BalanceService;
import dev.zheng.service.EmployeeService;
import dev.zheng.service.ReimbursementService;

public class junit {

	EmployeeDAO ed =new EmployeeDAOImpl();
	
	@Test
	public void getUser() {
		Employee u = EmployeeService.getEmployee(1);
		u.setUsername("tim1");
		assertEquals("tim1",EmployeeService.getEmployee(1).getUsername());
	}
	
	@Test
	public void getUser2() {
		Employee u = EmployeeService.loginEmployee("tim1", "password");

		assertEquals(1,u.getId());
	}

	
	@Test
	public void updateBalance() {
		BalanceInfo bi = BalanceService.getBalance(17);
		System.out.println("before: " +bi);
		BalanceService.updateBalance(bi);
		System.out.println("after: " +bi);
		
	}
	
}
