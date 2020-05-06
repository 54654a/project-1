package dev.zheng.employees;

public class Employee {

	private int id;
	private String fName;
	private String lName;
	private String username;
	private String password;
	private int titleId;
	private int supId;
	private int departId;
	
	public Employee() {
		super();
	}


	public Employee(String fName, String lName, String username, String password, int titleId) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
		this.titleId = titleId;
	}

	public Employee(int id, String fName, String lName, String username, String password,  int supId,
			int departId, int titleId) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
		this.titleId = titleId;
		this.supId = supId;
		this.departId = departId;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}





	public int getSupId() {
		return supId;
	}





	public void setSupId(int supId) {
		this.supId = supId;
	}





	public int getDepartId() {
		return departId;
	}





	public void setDepartId(int departId) {
		this.departId = departId;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", lName=" + lName + ", username=" + username + ", password="
				+ password + ", titleId=" + titleId + ", supId=" + supId + ", departId=" + departId + "]";
	}
	
	
}
