package com.chh.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chh.springboot.entity.Employee;
@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> getAllEmployees() {
		TypedQuery<Employee> employeeQuery = entityManager.createQuery("from Employee", Employee.class);
		return employeeQuery.getResultList();
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Employee employee = entityManager.find(Employee.class,employeeId);
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
        //for save and update
		entityManager.merge(employee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
	  Query query =	entityManager.createQuery("delete from Employee where id =: empId");
	  query.setParameter("empId",employeeId);
	  query.executeUpdate();
	}

}
