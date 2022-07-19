package com.swaraj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swaraj.dao.EmployeeDAO;
import com.swaraj.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		
		return employeeDAO.findAll();
	}

}
