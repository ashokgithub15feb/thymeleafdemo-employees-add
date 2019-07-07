package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//that's it. no need to write Implementation
	
	//add a method to sort by last name
	
	public List<Employee> findAllByOrderByLastNameAsc();
	
	//Spring data JPA will parse the method name - 
	//Looks for a specific format and pattern create appropriate query behind the scenes
	//behind -> "from Employee order by lastName asc" Spring data JPA Magic
}
