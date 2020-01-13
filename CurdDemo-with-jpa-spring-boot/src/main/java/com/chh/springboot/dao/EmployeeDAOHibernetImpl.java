package com.chh.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.chh.springboot.entity.Employee;

@Repository
public class EmployeeDAOHibernetImpl implements EmployeeDAO {
	
	private EntityManager  entityManager;

	
	public EmployeeDAOHibernetImpl (EntityManager entityManager) {
		
		this.entityManager =  entityManager;
	}
	
	
	@Override
	public List<Employee> getAllEmployees() {
		
		Session session = this.entityManager.unwrap(Session.class);
		List<Employee> listEmployees =  session.createQuery("from Employee",Employee.class).list();
		return listEmployees;
	}


	@Override
	public Employee getEmployeeById(int employeeId) {
		Session session = this.entityManager.unwrap(Session.class);		
		
		return session.get(Employee.class,employeeId);
	}


	@Override
	public void saveEmployee(Employee employee) {
		Session session = this.entityManager.unwrap(Session.class);	
		session.saveOrUpdate(employee);
	}


	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Session session = this.entityManager.unwrap(Session.class);	
		Query query = session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId",id);
		query.executeUpdate();
		
		
		
	}

}
