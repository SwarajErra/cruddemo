package com.swaraj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swaraj.dao.EmployeeDAO;
import com.swaraj.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {

		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		
		employeeDAO.save(employee);

	}

	@Override	
	@Transactional
	public void deleteById(int id) {
		employeeDAO.deleteById(id);

	}

}
