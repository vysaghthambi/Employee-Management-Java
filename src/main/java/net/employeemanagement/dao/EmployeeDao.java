package net.employeemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.employeemanagement.model.Employee;

public class EmployeeDao {
	private String jdbcUrl = "jdbc:mysql://localhost:3306/employeeManager?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Qwerty@12345";
	
	private static final String ADD_EMPLOYEE = "INSERT INTO employee" + "  (name, salary, department, address, phone) VALUES " +
	        " (?, ?, ?, ?, ?);";
	private static final String UPDATE_EMPLOYEE = "update employee set name = ?,salary= ?, department =?, address =?, phone=? where id = ?;";
	private static final String SELECT_EMPLOYEE_BY_ID = "select id, name, salary, department, address, phone from employee where id =?";
	private static final String SELECT_ALL_EMPLOYEES = "select * from employee";
	private static final String DELETE_EMPLOYEE = "delete from employee where id = ?;";
	
	protected Connection getConnection() throws ClassNotFoundException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcUrl,jdbcUsername,jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(ADD_EMPLOYEE)) {
			statement.setString(1, employee.getName());
			statement.setInt(2, employee.getSalary());
			statement.setString(3, employee.getDepartment());
			statement.setString(4, employee.getAddress());
			statement.setString(5, employee.getPhone());
			statement.executeUpdate();
		}
	}
	
	public void updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE)){
			statement.setString(1, employee.getName());
			statement.setInt(2, employee.getSalary());
			statement.setString(3, employee.getDepartment());
			statement.setString(4, employee.getAddress());
			statement.setString(5, employee.getPhone());
			statement.setInt(6, employee.getId());
			statement.executeUpdate();
		}
	}
	
	public Employee selectEmployee(int id) throws SQLException, ClassNotFoundException {
		Employee selectedEmployee = null;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);){
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("name");
                int salary = rs.getInt("salary");
                String department = rs.getString("department");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                selectedEmployee = new Employee(id, name, salary, department, address, phone);
			}
		}
		return selectedEmployee;
	}
	
	public List<Employee> selectAllEmployees() throws SQLException, ClassNotFoundException {
		List<Employee> allEmployees = new ArrayList<>();
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);){
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
                int salary = rs.getInt("salary");
                String department = rs.getString("department");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                Employee employee = new Employee(id, name, salary, department, address, phone);
                allEmployees.add(employee);
			}
		}
		return allEmployees;
	}
	
	public void deleteEmployee(int id) throws ClassNotFoundException, SQLException {
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
	}
}
