package com.chh.springboot.dao;

import java.util.List;

import com.chh.springboot.entity.Employee;

public interface EmployeeDAO {

	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int employeeId );
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployee(int employeeId);
}
