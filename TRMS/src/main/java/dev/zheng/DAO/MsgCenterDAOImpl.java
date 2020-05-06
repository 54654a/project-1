package dev.zheng.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.zheng.employees.MsgCenter;
import dev.zheng.util.JDBCConnection;

public class MsgCenterDAOImpl implements MsgCenterDAO{
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean addMsgCenter(MsgCenter mc) {
		String sql = "INSERT INTO msgcenter VALUES( msgid_maker.nextval,  ? ,"
				+ " ? , DEFAULT , DEFAULT , ? ) ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(mc.getEmployeeId()));
			ps.setString(2, mc.getMsg());
			ps.setString(3, Integer.toString(mc.getSenderId()));
			ps.execute();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}		

		return false;
	}

	@Override
	public List<MsgCenter> getAllMsg(int employeeId) {
		String sql ="SELECT * FROM msgcenter WHERE employee_id = ? "
				+ "ORDER BY msg_id DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(employeeId));
			List<MsgCenter> mList = new ArrayList<MsgCenter>();
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				mList.add(new MsgCenter(rs.getInt(1), rs.getInt(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6)));
			}
			return mList;
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public MsgCenter getMsgCenter(int msgId) {
		String sql ="SELECT * FROM msgcenter WHERE msg_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(msgId));
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new MsgCenter(rs.getInt(1), rs.getInt(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public boolean updateMsgCenter(MsgCenter change) {
		String sql ="UPDATE msgcenter  SET read_state = ?  WHERE msg_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, change.getReadState());
			ps.setString(2, Integer.toString(change.getMsgId()));
			ps.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteMsgCenter(int deleteId) {
		String sql="DELETE FROM msgcenter WHERE msg_id = ? ";
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
