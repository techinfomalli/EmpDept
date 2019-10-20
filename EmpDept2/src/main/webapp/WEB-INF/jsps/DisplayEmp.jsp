<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employees Details</title>
</head>
<body>

<h2>Employees:</h2>
<table>
<tr>
<th>Emp Id</th>
<th>Name</th>
<th>Job</th>
<th>mgr Id</th>
<th>Date of Joining</th>
<th>Salary</th>
<th>Deptno</th>
</tr>
<c:forEach items="${emps}" var="emps">
<tr>
<td>${emps.empno}</td>
<td>${emps.ename}</td>
<td>${emps.job}</td>
<td>${emps.mgr}</td>
<td>${emps.hiredate}</td>
<td>${emps.sal}</td>
<td>${emps.deptno}</td>

<td><a href="deleteEmp?empno=${emps.empno}">Delete</a></td>
<td><a href="updateEmp?empno=${emps.empno}">Edit</a></td>
</tr>
</c:forEach>
</table>
<a href="addemp">Add Employee</a>
</body>
</html>