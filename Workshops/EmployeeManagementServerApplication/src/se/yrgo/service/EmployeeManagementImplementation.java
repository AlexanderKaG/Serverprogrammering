package se.yrgo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import se.yrgo.domain.Employee;

@Stateless
public class EmployeeManagementImplementation implements EmployeeManagementService {

	@Override
	public void registerEmployee(Employee employee) {

	}

	@Override
	public List<Employee> getAllEmployees() {
		return null;
	}

	@Override
	public List<Employee> searchBySurname(String surname) {
		return null;
	}

}
