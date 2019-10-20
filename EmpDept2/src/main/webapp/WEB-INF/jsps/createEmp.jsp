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

EmpId:		<input type="text" name="empno"/>
name: 		<input type="text" name="ename"/>
Job: 		<input type="text" name="job"/>
Manager:	<input type="text" name="mgr"/>
Hiredate:	<input type="text" name="hiredate"/>
Salary: 	<input type="text" name="sal"/>
Commission: 	<input type="text" name="comm"/>
Dept no:	<input type="text" name="deptno"/>
</pre>
<input type="submit" value="Save"/>

</form>

<a href="displayAllEmployees">View All Employees</a>

</body>
</html>