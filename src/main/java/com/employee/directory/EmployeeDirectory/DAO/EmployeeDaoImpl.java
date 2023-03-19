package com.employee.directory.EmployeeDirectory.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.directory.EmployeeDirectory.Entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Employee> query=entityManager.createQuery("FROM Employee",Employee.class);
		return query.getResultList();
	}

}
