package net.employeemanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.employeemanagement.dao.EmployeeDao;
import net.employeemanagement.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDao employeeDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
    	this.employeeDao = new EmployeeDao();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		
		try {
			switch(action) {
				case "/new":
					showNewForm(request, response);
					break;
				case "/insert":
					addEmployee(request, response);
					break;
				case "/delete":
					deleteEmployee(request, response);
					break;
				case "/edit":
					showEditForm(request, response);
					break;
				case "/update":
					updateEmployee(request, response);
					break;
				default:
					listEmployee(request, response);
					break;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		List<Employee> listUser = employeeDao.selectAllEmployees();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
		dispatcher.forward(request, response);
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int salary = Integer.parseInt(request.getParameter("salary"));
		String department = request.getParameter("department");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		System.out.println("hello");

		Employee book = new Employee(id, name, salary, department, address, phone);
		employeeDao.updateEmployee(book);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee existingEmployee = employeeDao.selectEmployee(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		request.setAttribute("user", existingEmployee);
		dispatcher.forward(request, response);
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		employeeDao.deleteEmployee(id);
		response.sendRedirect("list");
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		String name = request.getParameter("name");
		int salary = Integer.parseInt(request.getParameter("salary"));
		String department = request.getParameter("department");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		Employee newEmployee = new Employee(name, salary, department, address, phone);
		employeeDao.addEmployee(newEmployee);
		System.out.println("hello2");
		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		dispatcher.forward(request, response);
	}

}
