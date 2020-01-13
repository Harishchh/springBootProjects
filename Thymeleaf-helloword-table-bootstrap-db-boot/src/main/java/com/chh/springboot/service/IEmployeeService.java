package com.chh.springboot.service;

import java.util.List;

import com.chh.springboot.entity.Employee;

public interface IEmployeeService {
	
public List<Employee> findAll();
public List<Employee> findAllByOrderByLastName();
	
	public Employee findById(int employeeId );
	
	public void save(Employee employee);
	
	public void deleteById(int employeeId);

}
