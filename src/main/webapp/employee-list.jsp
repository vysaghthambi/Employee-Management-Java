<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Employee Management App</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body onLoad="document.getElementById('my_form').submit()">
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #655D8A">
			<div>
				Employee Management
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employees</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Employees</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success ">Add
					New Employee</a>
			</div>
			<br>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Salary</th>
						<th>Department</th>
						<th>Address</th>
						<th>Phone Number</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td class="text-center align-middle"><c:out
									value="${user.id}" /></td>
							<td class="text-center align-middle"><c:out
									value="${user.name}" /></td>
							<td class="text-center align-middle"><c:out
									value="${user.salary}" /></td>
							<td class="text-center align-middle"><c:out
									value="${user.department}" /></td>
							<td class="text-center align-middle"><c:out
									value="${user.address}" /></td>
							<td class="text-center align-middle"><c:out
									value="${user.phone}" /></td>
							<td><a class="btn btn-primary btn-block "
								href="edit?id=<c:out value='${user.id}' />">Edit </a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a class="btn btn-danger btn-block "
								href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
	<form id="my_form" action="list"></form>
</body>

</html>