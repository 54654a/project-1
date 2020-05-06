package dev.zheng.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.zheng.employees.CoverageEvent;
import dev.zheng.util.JDBCConnection;

public class CoverageEventDAOImpl implements CoverageEventDAO{

	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean addCoverageEvent(CoverageEvent e) {
		String sql ="INSERT INTO event VALUES( ? , ? , ? )";
			try {
				PreparedStatement ps =conn.prepareStatement(sql);
				ps.setString(1, Integer.toString(e.getEventId()));
				ps.setString(2, e.getEventType());
				ps.setString(3, Double.toString(e.getCoverage()));
				ps.execute();
				return true;
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		return false;
	}

	@Override
	public List<CoverageEvent> getAllEvents() {
		String sql = "SELECT * FROM event ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<CoverageEvent> eList = new ArrayList<CoverageEvent>();
			
			while(rs.next()) {
				eList.add(new CoverageEvent(rs.getInt(1), rs.getString(2),
						rs.getDouble(3)));
			}
			return eList;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public CoverageEvent getCoverageEvent(int eventId) {
		String sql = "SELECT * FROM event WHERE event_id= ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(eventId));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			return new CoverageEvent(rs.getInt(1), rs.getString(2),
						rs.getDouble(3));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateCoverageEvent(CoverageEvent change) {
		String sql = "UPDATE event SET event_type = ? , coverage = ? WHERE"
				+ " event_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  change.getEventType());
			ps.setString(2, Double.toString(change.getCoverage()));
			ps.setString(3, Integer.toString(change.getEventId()));
			ps.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCoverageEvent(int deleteId) {
		String sql = "DELETE FROM event WHERE event_id = ? ";
		
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
