package com.employee.directory.EmployeeDirectory.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.directory.EmployeeDirectory.DAO.EmployeeDAO;
import com.employee.directory.EmployeeDirectory.Entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.save(employee);
		
	}

	@Override
	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findEmployeeById(id);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		employeeDao.deleteById(id);
		
 	}

	@Override
	public List<Employee> findAllSortedByLastName() {
		// TODO Auto-generated method stub
		return employeeDao.findAllSortedByLastName();
	}

}
