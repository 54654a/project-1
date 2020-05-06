package dev.zheng.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.zheng.employees.Reimbursement;
import dev.zheng.util.JDBCConnection;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean addReimbursement(Reimbursement r) {
		String sql = "INSERT INTO reimbursement VALUES( ? ,"
				+ " ? , ? , ? , ? , ? , ? , DEFAULT, ? )";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(r.getResimId()));
			ps.setString(2, Integer.toString(r.getEmployeeId()));
			ps.setString(3, Double.toString(r.getTotalReimbursement()));
			ps.setString(4, Double.toString(r.getPendingAmount()));
			ps.setString(5, Double.toString(r.getAwardedAmount()));
			ps.setString(6, Integer.toString(r.getEventId()));
			ps.setString(7, Integer.toString(r.getExceeded()));
			ps.setString(8,r.getRequestState());
			
			ps.execute();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
		return false;
	}

	@Override
	public List<Reimbursement> getAllReimbursement() {
		String sql=" SELECT * FROM reimbursement ORDER BY rei_id ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			List<Reimbursement> reiList = new ArrayList<Reimbursement>();
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				reiList.add(new Reimbursement(Integer.parseInt(rs.getString(1)),
						Integer.parseInt(rs.getString(2)), Double.parseDouble(rs.getString(3)),
						Double.parseDouble(rs.getString(4)),Double.parseDouble(rs.getString(5)),
						Integer.parseInt(rs.getString(6)), Integer.parseInt(rs.getString(7)),
								rs.getString(8), rs.getString(9)));
			}
			return reiList;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursement getReimbursement(int id) {
		String sql=" SELECT * FROM reimbursement WHERE rei_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new Reimbursement(Integer.parseInt(rs.getString(1)),
						Integer.parseInt(rs.getString(2)), Double.parseDouble(rs.getString(3)),
						Double.parseDouble(rs.getString(4)),Double.parseDouble(rs.getString(5)),
						Integer.parseInt(rs.getString(6)), Integer.parseInt(rs.getString(7)),
								rs.getString(8), rs.getString(9));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateReimbursement(Reimbursement change) {
		String sql = " UPDATE reimbursement SET employee_id = ? , total_amount = ? ,"
				+ "pending = ? , awarded = ? , event_id = ? , exceeding = ? ,"
				+ " request_date= default , request_state = ? "
				+ "WHERE rei_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(change.getEmployeeId()));
			ps.setString(2, Double.toString(change.getTotalReimbursement()));
			ps.setString(3, Double.toString(change.getPendingAmount()));
			ps.setString(4, Double.toString(change.getAwardedAmount()));
			ps.setString(5, Integer.toString(change.getEventId()));
			ps.setString(6, Integer.toString(change.isExceeded()));
			ps.setString(7, change.getRequestState());
			ps.setString(8, Integer.toString(change.getResimId()));
			
			
			ps.execute();
			return true;
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteReimbursement(int deleteId) {
		String sql = "DELETE FROM reimbursement WHERE rei_id = ? ";
		
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
	
	@Override
	public List<Reimbursement> getEmployeeReimbursement(int employeeId){
		String sql="SELECT * FROM reimbursement WHERE employee_id = ?  ORDER BY request_state, rei_id desc ";
		try {
			List<Reimbursement> rList = new ArrayList<Reimbursement>();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(employeeId));
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rList.add(new Reimbursement(Integer.parseInt(rs.getString(1)),
						Integer.parseInt(rs.getString(2)), Double.parseDouble(rs.getString(3)),
						Double.parseDouble(rs.getString(4)),Double.parseDouble(rs.getString(5)),
						Integer.parseInt(rs.getString(6)), Integer.parseInt(rs.getString(7)),
								rs.getString(8), rs.getString(9)));
			}
			return rList;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}
	
	@Override
	public Reimbursement getAEmployeeReimbursement(int employeeId){
		String sql="SELECT * FROM reimbursement WHERE employee_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(employeeId));
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new Reimbursement(Integer.parseInt(rs.getString(1)),
						Integer.parseInt(rs.getString(2)), Double.parseDouble(rs.getString(3)),
						Double.parseDouble(rs.getString(4)),Double.parseDouble(rs.getString(5)),
						Integer.parseInt(rs.getString(6)), Integer.parseInt(rs.getString(7)),
								rs.getString(8), rs.getString(9));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}

}
