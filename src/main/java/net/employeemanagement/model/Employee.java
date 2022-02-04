package net.employeemanagement.model;

public class Employee {
	
	private int id;
	private String name;
	private int salary;
	private String department;
	private String address;
	private String phone;
	
	public Employee(int id, String name, int salary, String department, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.address = address;
		this.phone = phone;
	}
	
	public Employee(String name, int salary, String department, String address, String phone) {
		super();
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.address = address;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}