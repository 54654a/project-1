package dev.zheng.DAO;

import java.util.List;

import dev.zheng.employees.MsgCenter;

public interface MsgCenterDAO {

	public boolean addMsgCenter(MsgCenter mc);
	public List<MsgCenter> getAllMsg(int employeeId);
	public MsgCenter getMsgCenter(int employeeId);
	public boolean updateMsgCenter(MsgCenter change);
	public boolean deleteMsgCenter(int deleteId);
}
