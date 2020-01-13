package com.chh.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chh.springboot.entity.Employee;
import com.chh.springboot.service.IEmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService  employeeService ;
	
	
	
	@GetMapping("/showFormToAdd")
	public String showFormToAdd(Model model) {
		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "employee-create-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		System.out.println(theEmployee);
		employeeService.save(theEmployee);
        return "redirect:/employees/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int employeeID,Model model) {
	
		System.out.println("Employee ID"+employeeID);
		Employee employee = this.employeeService.findById(employeeID);	
		
		model.addAttribute("employee",employee);
		return "employee-create-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int employeeID,Model model) {
	
		this.employeeService.deleteById(employeeID);	
		
		return "redirect:/employees/list";
	}

	@RequestMapping("/list")
	public String helloword(Model model) {

//		List<Employee>employeelist = employeeService.findAll();
		List<Employee>employeelist = employeeService.findAllByOrderByLastName();
		model.addAttribute("employeelist", employeelist);

		return "employee-list";
	}

}
