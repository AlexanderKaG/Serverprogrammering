package se.yrgo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import se.yrgo.dataaccess.EmployeeDataAccess;
import se.yrgo.domain.Employee;

@Stateless
public class EmployeeManagementImplementation implements EmployeeManagementService {

	@Inject
	private EmployeeDataAccess dao;

	@Override
	public void registerEmployee(Employee employee) {
		dao.insert(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.findAll();
	}

	@Override
	public List<Employee> searchBySurname(String surname) {
		return dao.findBySurname(surname);
	}

}
