package dev.zheng.employees;

public class Request {

	private int id;
	private int eventId;
	private int urgent;
	private int passing;
	private int level1;
	private int level2;
	private int level3;
	private int level4;
	private String gradeFormat;
	private int employeeId;
	
	private String location;
	private String datetime;
	private String description;
	private String justification;
	private double cost;
	
	public Request() {
		super();
		
	}
	
	public Request(int id, int level1, int level2, int level3, int level4) {
		super();
		this.id = id;
		this.level1 = level1;
		this.level2 = level2;
		this.level3 = level3;
		this.level4 = level4;
	}

	public Request(int id, int eventId, String gradeFormat, String location,
			String datetime, String description, String justification, 
			double cost, int employeeId, int urgent) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.urgent = urgent;
		this.gradeFormat=gradeFormat;
		
		this.location = location;
		this.datetime =datetime;
		this.description=description;
		this.justification=justification;
		this.cost=cost;
		this.employeeId=employeeId;
		
	}

	public Request(int id, int eventId, int level1, int level2, int level3, int level4,
		  int passing, String gradeFormat,  String location,
			String datetime, String description, String justification,
			double cost, int employeeId, int urgent) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.urgent = urgent;
		this.passing = passing;
		this.level1 = level1;
		this.level2 = level2;
		this.level3 = level3;
		this.level4 = level4;
		this.gradeFormat=gradeFormat;
		
		this.location = location;
		this.datetime =datetime;
		this.description=description;
		this.justification=justification;
		this.cost=cost;
		this.employeeId=employeeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getUrgent() {
		return urgent;
	}

	public void setUrgent(int urgent) {
		this.urgent = urgent;
	}

	public int getPassing() {
		return passing;
	}

	public void setPassing(int passing) {
		this.passing = passing;
	}

	public int getLevel1() {
		return level1;
	}

	public void setLevel1(int level1) {
		this.level1 = level1;
	}

	public int getLevel2() {
		return level2;
	}

	public void setLevel2(int level2) {
		this.level2 = level2;
	}

	public int getLevel3() {
		return level3;
	}

	public void setLevel3(int level3) {
		this.level3 = level3;
	}

	public int getLevel4() {
		return level4;
	}

	public void setLevel4(int level4) {
		this.level4 = level4;
	}

	public String getGradeFormat() {
		return gradeFormat;
	}

	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		
		String strUrgent,strPassing,strLevel1,strLevel2, strLevel3, strLevel4, strLevel5;
		if(urgent == 0 ) {
			strUrgent = "Pending";
		}else if(urgent == 1) {
			strUrgent = "Yes";
		}else {
			strUrgent = "No";
		}
		if(passing == 0 ) {
			strPassing = "Pending";
		}else if(passing == 1) {
			strPassing = "Yes";
		}else {
			strPassing = "No";
		}
		if(level1 == 0 ) {
			strLevel1 = "Pending";
		}else if(level1 == 1) {
			strLevel1 = "Approved";
		}else {
			strLevel1 = "Not Approved";
		}
		if(level2 == 0 ) {
			strLevel2 = "Pending";
		}else if(level2 == 1) {
			strLevel2 = "Approved";
		}else {
			strLevel2 = "Not Approved";
		}
		if(level3 == 0 ) {
			strLevel3 = "Pending";
		}else if(level3 == 1) {
			strLevel3 = "Approved";
		}else {
			strLevel3 = "Not Approved";
		}		
		if(level4 == 1 ) {
			strLevel4 = "Escalation Email sent";
		}else {
			strLevel4 = "Pending";
		}
		
		return "Request [id=" + id + ", eventId=" + eventId + ", urgent=" + urgent + ", passing=" + passing
				+ ", level1=" + level1 + ", level2=" + level2 + ", level3=" + level3 + ", level4=" + level4
				 + ", gradeFormat=" + gradeFormat + ", location=" + location + ", datetime="
				+ datetime + ", description=" + description + ", justification=" + justification + ", cost=" + cost
				+ "]";
	}
	
	
	
}
