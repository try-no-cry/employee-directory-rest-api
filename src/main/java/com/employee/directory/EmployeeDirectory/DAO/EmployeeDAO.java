package com.employee.directory.EmployeeDirectory.DAO;

import java.util.List;

import com.employee.directory.EmployeeDirectory.Entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();

}
