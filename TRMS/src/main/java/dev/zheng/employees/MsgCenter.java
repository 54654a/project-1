package dev.zheng.employees;

public class MsgCenter {

	private int msgId;
	private int employeeId;
	private String msg;
	private String msgTime;
	private String readState;
	private int senderId;
	
	public MsgCenter() {
		super();
	}
	
	public MsgCenter(int msgId, String readState) {
		super();
		this.employeeId = msgId;
		this.readState = readState;
	}
	
	public MsgCenter(int employeeId, String msg,  int senderId) {
		super();
		this.employeeId = employeeId;
		this.msg = msg;
		this.senderId = senderId;
	}
	
	public MsgCenter(int employeeId, String msg, String msgTime , String readState,  int senderId) {
		super();
		this.employeeId = employeeId;
		this.msg = msg;
		this.msgTime=msgTime;
		this.readState = readState;
		this.senderId =senderId;
	}
	
	
	public MsgCenter(int msgId,int employeeId, String msg, String msgTime , String readState, int senderId) {
		super();
		this.msgId=msgId;
		this.employeeId = employeeId;
		this.msg = msg;
		this.readState = readState;
		this.msgTime=msgTime;
		this.senderId=senderId;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getReadState() {
		return readState;
	}
	public void setReadState(String readState) {
		this.readState = readState;
	}


	public String getMsgTime() {
		return msgTime;
	}


	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}


	public int getMsgId() {
		return msgId;
	}


	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}


	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	@Override
	public String toString() {
		return "MsgCenter [msgId=" + msgId + ", employeeId=" + employeeId + ", msg=" + msg + ", msgTime=" + msgTime
				+ ", readState=" + readState + ", senderId=" + senderId + "]";
	}
}
