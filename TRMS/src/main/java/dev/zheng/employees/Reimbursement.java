package dev.zheng.employees;

public class Reimbursement {

	private int resimId;
	private int eventId;
	private double total; 
	private int employeeId;
	private double pendingAmount;
	private double awardedAmount;
	private int exceeded;
	private String date;
	private String requestState;


	public Reimbursement() {
		super();
		
	}
	
	public Reimbursement(int employeeId) {
		super();
		this.employeeId= employeeId;
	}
	
	public Reimbursement(int resimId, String requestState) {
		super();
		this.resimId= resimId;
		this.requestState=requestState;
	}
	
	public Reimbursement(int resimId, String requestState, int exceeded) {
		super();
		this.resimId= resimId;
		this.requestState=requestState;
		this.exceeded=exceeded;	
	}
	
	public Reimbursement(int employeeId, double total, double pendingAmount, double awardedAmount,
			int eventId, int exceeded, String date ) {
		super();
		this.eventId = eventId;
		this.employeeId = employeeId;
		this.total=total;
		this.pendingAmount = pendingAmount;
		this.awardedAmount = awardedAmount;
		this.exceeded = exceeded;
		this.date=date;
	}



	public Reimbursement(int resimId, int employeeId, double total, double pendingAmount, double awardedAmount,
			int eventId, int exceeded, String date, String requestState) {
		super();
		this.resimId = resimId;
		this.eventId = eventId;
		this.employeeId = employeeId;
		this.total=total;
		this.pendingAmount = pendingAmount;
		this.awardedAmount = awardedAmount;
		this.exceeded = exceeded;
		this.date=date;
		this.requestState=requestState;
	}



	public int getResimId() {
		return resimId;
	}



	public void setResimId(int resimId) {
		this.resimId = resimId;
	}



	public int getEventId() {
		return eventId;
	}



	public void setEventId(int eventId) {
		this.eventId = eventId;
	}



	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	public double getPendingAmount() {
		return pendingAmount;
	}



	public void setPendingAmount(double pendingAmount) {
		this.pendingAmount = pendingAmount;
	}



	public double getAwardedAmount() {
		return awardedAmount;
	}



	public void setAwardedAmount(double awardedAmount) {
		this.awardedAmount = awardedAmount;
	}



	public int isExceeded() {
		return exceeded;
	}
	
	public void setExceeded(int exceeded) {
		this.exceeded= exceeded;
	}

	public String getRequestState() {
		return requestState;
	}



	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}



	public int getExceeded() {
		return exceeded;
	}

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public  double getTotalReimbursement() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total =total;
	}



	@Override
	public String toString() {
		return "Reimbursement [resimId=" + resimId + ", eventId=" + eventId +", employeeId="
				+ employeeId +  ", total=" + total + ", pendingAmount=" + pendingAmount + ", awardedAmount=" + awardedAmount + ", exceeded="
				+ exceeded + ", date=" + date + ", requestState=" + requestState + "]";
	}
	
	
	
	
}
