package dev.zheng.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.zheng.employees.Employee;
import dev.zheng.util.JDBCConnection;

public class EmployeeDAOImpl implements EmployeeDAO{

	public static Connection conn = JDBCConnection.getConnection();
	
	@Override
	public boolean addEmployee(Employee e) {
		String sql =" INSERT INTO employee VALUES ( employeeId_maker.nextval, "
				+ "? , ? , ? , ? , DEFAULT , DEFAULT , ? ) ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getfName());
			ps.setString(2, e.getlName());
			ps.setString(3, e.getUsername());
			ps.setString(4, e.getUsername());
			ps.setString(5, Integer.toString(e.getTitleId()));
			ps.execute();
			return true;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		String sql = " SELECT * FROM employee ";
		
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Employee> employeeList = new ArrayList<Employee>();
			
			while(rs.next()) {
				employeeList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
				
			}
			return employeeList;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getEmployee(int id) {
		String sql = " SELECT * FROM employee WHERE employee_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateEmployee(Employee change) {
		String sql= " UPDATE employee SET fname = ? , lname = ? , usermane = ? ,"
				+ " password = ? , manager_id = ? , depart_id = ? , title_ id = ? WHERE employee_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(8,Integer.toString( change.getId()));
			ps.setString(1,change.getfName());
			ps.setString(2, change.getlName());
			ps.setString(3, change.getUsername());
			ps.setString(4, change.getPassword());
			ps.setString(5, Integer.toString(change.getSupId()));
			ps.setString(6, Integer.toString(change.getDepartId()));
			ps.setString(7,Integer.toString(change.getTitleId()));
			
			ps.execute();
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int deleteId) {
		String sql=" DELETE FROM request WHERE request_id = ? ";
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
	@Override
	public int getDepartHead(int departId) {
		int result=0;
		String sql =" SELECT head_id FROM department WHERE depart_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(departId));
			
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<Employee> getEmployeesSameDepart(int departId, int employeeId) {
		String sql =" SELECT * FROM employee WHERE depart_id = ?  and employee_id != ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(departId));
			ps.setString(2, Integer.toString(employeeId));
			ResultSet rs = ps.executeQuery();
			List<Employee> employeeList = new ArrayList<Employee>();
			
			while(rs.next()) {
				employeeList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
			return employeeList;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}
	
	
	@Override
	public List<Employee> getEmployees(int supId){
		String sql=" SELECT * FROM employee WHERE manager_id = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			List<Employee> eList = new ArrayList<Employee>();
			ps.setString(1, Integer.toString(supId));
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				eList.add(new Employee(rs.getInt("employee_id"), rs.getString("fname"), rs.getString("lname"),
						rs.getString("username"), rs.getString("password"),
						rs.getInt("manager_id"), rs.getInt("depart_id"), rs.getInt("title_id")));
			}
			return eList;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
