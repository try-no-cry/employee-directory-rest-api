package com.employee.directory.EmployeeDirectory.Service;

import java.util.List;

import com.employee.directory.EmployeeDirectory.Entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	Employee  save(Employee employee);
	Employee  findEmployeeById(int id);
	void  deleteById(int id);

}
