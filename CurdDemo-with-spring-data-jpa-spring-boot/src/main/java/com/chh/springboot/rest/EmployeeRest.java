package com.chh.springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chh.springboot.entity.Employee;
import com.chh.springboot.service.IEmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRest {
	
	@Autowired
	private IEmployeeService employeeService;
	
	
	
	@GetMapping("/employee")
	public  List<Employee> getAllEmpolyee(){
		
		return this.employeeService.getAllEmployees();
	}
	
	@GetMapping("/employee/{employeeId}")
	public  Employee getAllEmpolyee(@PathVariable  int employeeId){
		
		Employee employee = this.employeeService.getEmployeeById(employeeId);
		if(employee == null ) {
			throw new RuntimeException("Employee not found for the ID"+employeeId);
		}
		
		return employee;
	}
	 
	@PostMapping("/employee")
	public void addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		this.employeeService.saveEmployee(employee);
		
	}
	
	@PutMapping("/employee")
	public void updateEmployee(@RequestBody Employee employee) {
		System.out.println(employee);
		this.employeeService.saveEmployee(employee);
		
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public  void deleteEmpolyee(@PathVariable  int employeeId){
		  System.out.println(employeeId);
		 this.employeeService.deleteEmployee(employeeId);
	}
	
	
	

}
