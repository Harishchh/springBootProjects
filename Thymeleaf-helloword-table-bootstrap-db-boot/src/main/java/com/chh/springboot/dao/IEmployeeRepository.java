package com.chh.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chh.springboot.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	
	// hey  no need to write code , spring data jpa already given default impleation
	
	
	//custom implemation
	List<Employee> findAllByOrderByLastName();
}
