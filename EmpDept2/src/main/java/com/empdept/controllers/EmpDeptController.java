package com.empdept.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.empdept.entities.Emp;
import com.empdept.reposotoryes.EmpRepository;
import com.empdept.util.ReportUtil;


@Controller
public class EmpDeptController {

	@Autowired
	EmpRepository repository;
	@Autowired
	ServletContext sc;
	@Autowired
	ReportUtil reportsUtil;

	@RequestMapping("/Home")
	public String showHome() {
		return "home";
	}
	
@RequestMapping("/addemp")	
	public String showEmp() {
		return "createEmp";
	}
@RequestMapping("/saveemp")
public String addEmployee(@ModelAttribute("emp") Emp emp, ModelMap modelMap) {
	repository.save(emp);
	String msg= emp.getEmpno()+" "+emp.getEname()+" Employee has been created Successfully!!!";
	List<Emp> emps= (List<Emp>) repository.findAll();
	modelMap.addAttribute("emps", emps);
	modelMap.addAttribute("msg", msg);
	return "DisplayEmp";
}

@RequestMapping("/displayAllEmployees")
public String saveEmp(ModelMap modelMap) {
	List<Emp> emps= (List<Emp>) repository.findAll();
	modelMap.addAttribute("emps", emps);
	
	return "DisplayEmp";
}

@RequestMapping("/deleteEmp")
public String deleteEmp(@RequestParam("empno") int empno,ModelMap modelmap) {
	repository.deleteById(empno);
	List<Emp> emps= (List<Emp>) repository.findAll();
	modelmap.addAttribute("emps", emps);
	return "DisplayEmp";
	
}
@RequestMapping("/updateEmp")
public String editEmp(@RequestParam("empno") Integer empno,ModelMap modelmap) {
	System.out.println("rrrrrrrrr");
	Emp emp = repository.findById(empno).get();
	//repository.save(emp);
	modelmap.addAttribute("emp", emp);
	System.out.println(emp);
	return "createEmp";
}


	@RequestMapping("/generateReport")
	// public String generateReport(ModelMap modelmap) {
	public String generateReport() {
		List<Object[]> data = repository.findDeptwiseCount();
		String path = sc.getRealPath("/");
		String deptpath = path + "/DeptwisePieChart.jpeg";
		String name = "Deportment wise Employees Count";
		reportsUtil.generatePieChart(name, deptpath, data);

		data = repository.findJobwiseCount();
		path = sc.getRealPath("/");
		String jobpath = path + "/JobwisePieChart.jpeg";
		name = "Job wise Employees Count";
		reportsUtil.generatePieChart(name, jobpath, data);

		/*
		 * List <Object[]> emps= repository.findAllEmp();
		 * 
		 * for(Object[] objects:emps) { System.out.println(objects[0].toString());
		 * System.out.println(objects[1].toString());
		 * objects[0].toString();objects[1].toString(); objects[0].toString(); new
		 * Double (objects[1].toString());objects[3].toString(); new Double
		 * (objects[4].toString());new Double (objects[5].toString()); new Double
		 * (objects[6].toString());new Double (objects[6].toString()); }
		 * 
		 * 
		 * modelmap.addAttribute("emps", emps); System.out.println("ramram1");
		 */

		return "EmpDeptReport";

	}
}
