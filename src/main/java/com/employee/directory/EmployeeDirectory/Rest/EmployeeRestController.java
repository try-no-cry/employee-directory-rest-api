package com.employee.directory.EmployeeDirectory.Rest;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.directory.EmployeeDirectory.Entity.Employee;
import com.employee.directory.EmployeeDirectory.Entity.EmployeeDAO;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	@GetMapping("/")
	public String hi()
	{
		return "Hi";
	}
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployees()
	{
		System.out.println("Inside List<Employee> findAllEmployees()");
		return employeeDao.findAll();
		
 
	}
	
}
