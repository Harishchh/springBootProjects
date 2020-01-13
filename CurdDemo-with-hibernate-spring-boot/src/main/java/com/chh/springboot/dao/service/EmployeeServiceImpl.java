package com.chh.springboot.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chh.springboot.dao.EmployeeDAO;
import com.chh.springboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		return  employeeDAO.getEmployeeById(employeeId);
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);

	}

	@Override
	public void deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		employeeDAO.deleteEmployee(employeeId);
	}

}
