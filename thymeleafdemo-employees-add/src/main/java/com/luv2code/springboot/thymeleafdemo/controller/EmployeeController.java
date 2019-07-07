package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	//load employee data
	
	private EmployeeService employeeServie;
	
	public EmployeeController(EmployeeService employeeServie) {
		this.employeeServie = employeeServie;
	}

	//add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel)
	{
		List<Employee> theEmployees = employeeServie.findAll();
		//add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Employee theEmployee =  new Employee();
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save") // employee ---> form data 
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee)
	{
		//save the employee
		employeeServie.save(theEmployee);
		
		//Employee Controller -> Employee Service -> Employee Repository -> Database
		
		//use a redirect to prevent duplicate submission
		
		return "redirect:/employees/list";//redirect to request mapping /employees/list
	}
}
