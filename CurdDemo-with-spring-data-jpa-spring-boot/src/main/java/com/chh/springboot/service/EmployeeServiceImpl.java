package com.chh.springboot.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chh.springboot.dao.IEmployeeRepository;
import com.chh.springboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Optional<Employee> findById = employeeRepository.findById(employeeId);
		Employee employee = null;
		if(findById.isPresent()) {
			employee = findById.get();
		}else {
			throw new RuntimeException("Employee not present for ID -"+employeeId);
		}
		return  employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public void deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(employeeId);
	}

}
