package dev.zheng.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.zheng.employees.BalanceInfo;
import dev.zheng.util.JDBCConnection;

public class BalanceInfoDAOImpl implements BalanceInfoDAO{
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean addBalance(BalanceInfo b) {
		String sql = "INSERT INTO benefit_info VALUES( employee_id = ?,"
				+ "DEFAULT, awarded = ? , avail = ? , DEFAULT ) ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(b.getEmployeeId()));
			ps.setString(2, Double.toString(b.getAwardedAmount()));
			ps.setString(3, Double.toString(b.getAvailAmount()));
			ps.execute();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}		

		return false;
	}

	@Override
	public List<BalanceInfo> getAllBalance() {
		String sql ="SELECT * FROM benefit_info ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<BalanceInfo> bList= new ArrayList<BalanceInfo>();
			while(rs.next()) {
				 bList.add(new BalanceInfo(rs.getInt(1), rs.getDouble(2),
						rs.getDouble(3), rs.getDouble(4), rs.getString(5)));
			}
			return bList;
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public BalanceInfo getBalance(int employeeId) {
		String sql ="SELECT * FROM benefit_info WHERE employee_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(employeeId));
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new BalanceInfo(rs.getInt(1), rs.getDouble(2),
						rs.getDouble(3), rs.getDouble(4), rs.getString(5));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public boolean updateBalance(BalanceInfo change) {
		String sql ="UPDATE benefit_info SET total = ? , awarded = ? ,"
				+ "avail = ? , last_update=DEFAULT WHERE employee_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Double.toString(change.getTotalAmount()));
			ps.setString(2, Double.toString(change.getAwardedAmount()));
			ps.setString(3, Double.toString(change.getAvailAmount()));
			ps.setString(4, Double.toString(change.getEmployeeId()));
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBalance(int deleteId) {
		String sql="DELETE FROM Benefit_info WHERE employee_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(deleteId));
			
			ps.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
