package com.swaraj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.swaraj.entity.Employee;
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findAll() {
		
		Session currentSession =  entityManager.unwrap(Session.class);
		
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, id);

		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
		
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", id);
		theQuery.executeUpdate();	
		
	}
	

}
