package com.swaraj.rest;

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

import com.swaraj.entity.Employee;
import com.swaraj.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		
		return employeeService.findAll();
	}
	@GetMapping("/employee/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		
		Employee employee = employeeService.findById(employeeId);
		
		if(employee == null) {
			throw new RuntimeException("couldn't find employee - " + employeeId);
		}
		
		
		return employee;
		
	}
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		employee.setId(0);
		employeeService.save(employee);
		
		return employee;
		
	}
	
	@PutMapping("employees")
	public Employee update(@RequestBody Employee employee) {
		
		employeeService.save(employee);
		
		return employee;
		
	}
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployeeById(@PathVariable int employeeId) {
		
		Employee employee = employeeService.findById(employeeId);
		if(employee == null) {
			throw new RuntimeException("Employee id " +employeeId+ " is not found");
		}
		employeeService.deleteById(employeeId);
		
		return "Employee with id "+employeeId+" is deleted";
		
		
		
	}
	
	
	

}
