<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Employee</title>
</head>
<body>

<h2>Add Employee Details!!!</h2>

<form action="saveemp" method="post">
<pre>

EmpId:		<input type="text" name="empno" value="${emp.empno}" readonly/>
name: 		<input type="text" name="ename" value="${emp.ename}" />
Job: 		<input type="text" name="job" value="${emp.job}" />
Manager:	<input type="text" name="mgr" value="${emp.mgr}" />
Hiredate:	<input type="text" name="hiredate" value="${emp.hiredate}"/ >
Salary: 	<input type="text" name="sal" value="${emp.sal}" / >
Commission: 	<input type="text" name="comm" value="${emp.comm}"/ >
Dept no:	<input type="text" name="deptno" value="${emp.deptn}"/ >
</pre>
<input type="submit" value="Save"/>

</form>

<a href="displayAllEmployees">View All Employees</a>

</body>
</html>