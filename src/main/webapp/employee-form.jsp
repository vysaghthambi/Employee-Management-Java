<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: 655D8A">
			<div>
				<a class="navbar-brand">Employee Management</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employees</a></li>
			</ul>
		</nav>
	</header>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<h2>
						<c:if test="${user == null}">
                                    Add New Employee
                        </c:if>
                        <c:if test="${user != null}">
                                    Update Employee
                        </c:if>
				</h2>
				<input type="hidden" name="id"
						value="<c:out value='${user.id}' />" />
				
					<fieldset class="form-group">
						<label>User Name</label> <input type="text"
							value="<c:out value='${user.name}' />" class="form-control"
							name="name" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>User Salary</label> <input type="text"
							value="<c:out value='${user.salary}' />" class="form-control"
							name="salary">
					</fieldset>

					<fieldset class="form-group">
						<label>User Department</label> <input type="text"
							value="<c:out value='${user.department}' />" class="form-control"
							name="department">
					</fieldset>

					<fieldset class="form-group">
						<label>User Address</label> <input type="text"
							value="<c:out value='${user.department}' />" class="form-control"
							name="address">
					</fieldset>

					<fieldset class="form-group">
						<label>User Phone</label> <input type="text"
							value="<c:out value='${user.phone}' />" class="form-control"
							name="phone">
					</fieldset>

					<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>