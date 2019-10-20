package com.empdept.reposotoryes;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.empdept.entities.Emp;

public interface EmpRepository extends CrudRepository<Emp, Integer> {
		@Query(value="select (select d.dname from dept d where d.deptno=e.deptno )dname,count(*) from emp e group by deptno",nativeQuery = true)	
		public List<Object[]> findDeptwiseCount();
		
		@Query(value="select job,count(*) from emp group by job;",nativeQuery = true)	
		public List<Object[]> findJobwiseCount();
		
		
		//select ename,empno,job,IFNULL(mgr,0),sal,IFNULL(comm,0),deptno from emp
		@Query(value="select ename,job from emp",nativeQuery = true)	
		public List<Object[]> findAllEmp();



}
