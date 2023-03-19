package com.employee.directory.EmployeeDirectory.Rest;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.employee.directory.EmployeeDirectory.Entity.Employee;
import com.employee.directory.EmployeeDirectory.Service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String hi()
	{
		return "Hi";
	}
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployees()
	{
		System.out.println("Inside List<Employee> findAllEmployees()");
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId)
	{
		System.out.println("Inside getEmployeeById(@PathVariable int employeeId)");
		Employee emp=employeeService.findEmployeeById(employeeId);
		
		if(emp==null)
		{
			throw new RuntimeException("Employee with  id:"+employeeId+" not found.");
		}
		
		return emp;
	}
	
}
