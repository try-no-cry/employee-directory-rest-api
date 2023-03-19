package com.employee.directory.EmployeeDirectory.Rest;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		employee.setId(0);// putting id 0 incase someone has already provided id....now it will create new emp
		Employee emp=employeeService.save(employee);
		
		return emp;
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		Employee emp=employeeService.save(employee);
		return emp;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployeeById(@PathVariable int employeeId)
	{
		Employee emp=employeeService.findEmployeeById(employeeId);
		
		if(emp==null)
		{
			throw new RuntimeException("Employee with id:"+employeeId+" not found.");
		}
	 
		employeeService.deleteById(employeeId);
		
		return "Employee deleted with id:"+employeeId;
	}
	
}
