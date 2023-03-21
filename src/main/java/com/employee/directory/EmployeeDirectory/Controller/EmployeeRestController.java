package com.employee.directory.EmployeeDirectory.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.employee.directory.EmployeeDirectory.Entity.Employee;
import com.employee.directory.EmployeeDirectory.Service.EmployeeService;

//@RestController rest controller when api
/// when thymeleaf use controller
@Controller
@RequestMapping("/employees")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/hi")
	public String hi(Model model)
	{
		model.addAttribute("theDate",new Date());
		return "helloworld";
	}
	
//	@GetMapping("/")
//	public List<Employee> findAllEmployees()
//	{
//		System.out.println("Inside List<Employee> findAllEmployees()");
//		return employeeService.findAll();
//	}
	
	@GetMapping("/")
	public String listEmployees(Model model)
	{
		System.out.println("Inside listEmployees(Model model)");
//		model.addAttribute("employees",employeeService.findAll());
		model.addAttribute("employees",employeeService.findAllSortedByLastName());
		return "employees/list-employees";
	}
	
	@GetMapping("/{employeeId}")
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
	
	@PostMapping("/")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		employee.setId(0);// putting id 0 incase someone has already provided id....now it will create new emp
		Employee emp=employeeService.save(employee);
		
		return emp;
		
	}
	
	@PostMapping("/save")
	public String saveEmployeeFormData(@ModelAttribute("employee") Employee employee)
	{
		employee.setId(0);// putting id 0 incase someone has already provided id....now it will create new emp
		Employee emp=employeeService.save(employee);
		
		return "redirect:/employees/";
		
	}
	
	
	
	@PutMapping("/")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		Employee emp=employeeService.save(employee);
		return emp;
	}
	
	@DeleteMapping("/{employeeId}")
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
	
	@GetMapping("/addEmployeeForm")
	public String addNewEmployee(Model model)
	{
		Employee emp=new Employee();
		model.addAttribute(emp);
		
		return "employees/addEmployeeForm";
	}
	
}
