package dev.zheng.employees;

public class BalanceInfo {
	
	private int employeeId;
	private double totalAmount;
	private double awardedAmount;
	private double availAmount;
	private String lastestDate;
	
	
	public BalanceInfo() {
		super();
	}
	
	public BalanceInfo(int employeeId, double totalAmount, double awardedAmount, double availAmount) {
		super();
		this.employeeId = employeeId;
		this.totalAmount = totalAmount;
		this.awardedAmount = awardedAmount;
		this.availAmount = availAmount;
	}
	
	public BalanceInfo(int employeeId, double totalAmount, double awardedAmount, double availAmount, String lastestDate) {
		super();
		this.employeeId = employeeId;
		this.totalAmount = totalAmount;
		this.awardedAmount = awardedAmount;
		this.availAmount = availAmount;
		this.lastestDate=lastestDate;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getAwardedAmount() {
		return awardedAmount;
	}
	public void setAwardedAmount(double awardedAmount) {
		this.awardedAmount = awardedAmount;
	}
	public double getAvailAmount() {
		return availAmount;
	}
	public void setAvailAmount(double availAmount) {
		this.availAmount = availAmount;
	}
	
	public String getLastestDate() {
		return lastestDate;
	}

	public void setLastestDate(String lastestDate) {
		this.lastestDate = lastestDate;
	}

	@Override
	public String toString() {
		return "BalanceInfo [employeeId=" + employeeId + ", totalAmount=" + totalAmount + ", awardedAmount="
				+ awardedAmount + ", availAmount=" + availAmount + "]";
	}
}
