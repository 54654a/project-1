package dev.zheng.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.zheng.employees.Request;
import dev.zheng.util.JDBCConnection;

public class RequestDAOImpl implements RequestDAO {
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean addRequest(Request r) {
		String sql = " INSERT INTO request VALUES( requestId_maker.nextval , "
				+ "? , DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, "
				+ "? , ? , TO_DATE( ? ,'YYYY-MM-DD') , ? , ? , ? , ? , ? ) ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(r.getEventId()));
			ps.setString(2, r.getGradeFormat());
			ps.setString(3, r.getLocation());
			ps.setString(4, r.getDatetime());
			ps.setString(5, r.getDescription());
			ps.setString(6, r.getJustification());
			ps.setString(7, Double.toString(r.getCost()));
			ps.setString(8, Integer.toString(r.getEmployeeId()));
			ps.setString(9, Integer.toString(r.getUrgent()));
			
			ps.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Request> getAllRequest() {
		String sql = " SELECT * FROM request ";
		List<Request> requestList = new ArrayList<Request>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				requestList.add(new Request(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6),
						rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getDouble(13), rs.getInt(14), 
						rs.getInt(15)));
			}
			
			return requestList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Request getRequest(int id) {
		String sql = " SELECT * FROM request WHERE request_id = ? ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new Request(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6),
						rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getDouble(13), rs.getInt(14), 
						rs.getInt(15));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateRequest(Request change) {
		String sql ="UPDATE request SET event_id = ? ,"
				+ "level1 = ? , level2 = ? , level3 = ? , level4 = ? , "
				+ "passing = ? , grade_format = ? ,"
				+ " location = ? , description = ? , justification = ? , cost = ? , employee_id = ? "
				+ ", urgent = ?  WHERE "
				+ " request_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(change.getEventId()));
			ps.setString(2, Integer.toString(change.getLevel1()));
			ps.setString(3, Integer.toString(change.getLevel2()));
			ps.setString(4, Integer.toString(change.getLevel3()));
			ps.setString(5, Integer.toString(change.getLevel4()));
			ps.setString(6, Integer.toString(change.getPassing()));
			
			ps.setString(7, change.getGradeFormat());
			ps.setString(8, change.getLocation());
			ps.setString(9, change.getDescription());
			ps.setString(10, change.getJustification());
			ps.setString(11, Double.toString(change.getCost()));
			ps.setString(12, Integer.toString(change.getEmployeeId()));
			ps.setString(13, Integer.toString(change.getUrgent()));
			ps.setString(14, Integer.toString(change.getId()));
			ps.execute();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteRequest(int deleteId) {
		String sql = "DELETE FROM request WHERE request_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(deleteId));
			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	@Override
	public Request getEmployeeRequest(int employeeId){
		String sql = "SELECT * FROM request WHERE employee_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(employeeId));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Request(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6),
						rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getDouble(13), rs.getInt(14), 
						rs.getInt(15));
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;		
		
	}
	
	

}
