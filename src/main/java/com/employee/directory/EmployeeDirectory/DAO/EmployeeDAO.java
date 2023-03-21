package com.employee.directory.EmployeeDirectory.DAO;

import java.util.List;

import com.employee.directory.EmployeeDirectory.Entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	Employee  save(Employee employee);
	Employee  findEmployeeById(int id);
	void  deleteById(int id);
	List<Employee> findAllSortedByLastName();

}
