package dev.zheng.service;

import java.util.List;

import dev.zheng.DAO.MsgCenterDAO;
import dev.zheng.DAO.MsgCenterDAOImpl;
import dev.zheng.employees.MsgCenter;

public class MsgCenterService {

	public static MsgCenterDAO mcd = new MsgCenterDAOImpl();
	
	public static boolean addMsgCenter(MsgCenter mc) {
		return mcd.addMsgCenter(mc);
	}
	public static List<MsgCenter> getAllMsg(int employeeId){
		return mcd.getAllMsg(employeeId);
	}
	
	public static MsgCenter getMsgCenter(int msgId) {
		return mcd.getMsgCenter(msgId);
	}
	
	public static boolean updateMsgCenter(MsgCenter change) {
		return mcd.updateMsgCenter(change);
	}
	
	public static boolean deleteMsgCenter(int deleteId) {
		return mcd.deleteMsgCenter(deleteId);
	}
}
