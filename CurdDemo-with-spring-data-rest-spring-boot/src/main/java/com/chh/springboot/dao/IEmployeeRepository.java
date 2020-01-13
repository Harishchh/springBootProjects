package com.chh.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.chh.springboot.entity.Employee;

//@RepositoryRestResource(path="members")
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	
	// hey  no need to write code , spring data jpa already given default impleation
}
