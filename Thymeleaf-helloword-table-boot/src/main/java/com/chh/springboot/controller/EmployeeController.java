package com.chh.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chh.springboot.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	List<Employee> employeelist = new ArrayList<Employee>();
	@PostConstruct
	public void loadData() {
		

		Employee employee1 =  new Employee("Harish","Chh","Harihschh@gmail.com");
		Employee employee2 =  new Employee("Manohar","M","manohar@gmail.com");
		Employee employee3 =  new Employee("Mukesh","V","mukesj@gmail.com");
		employeelist.add(employee1);
		employeelist.add(employee2);
		employeelist.add(employee3);

		
	}
	
@RequestMapping("/list")
public String helloword(Model model) {
	
	model.addAttribute("employeelist",this.employeelist);
	
	return "employee-list";
}

}
