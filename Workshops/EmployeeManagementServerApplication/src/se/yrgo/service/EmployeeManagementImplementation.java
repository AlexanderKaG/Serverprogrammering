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
		Employee emp1 = new Employee("James", "Green", "Writer", 3700);
		Employee emp2 = new Employee("Sara", "Bild", "Editor", 2200);
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(emp1);
		employees.add(emp2);
		return employees;
	}

	@Override
	public List<Employee> searchBySurname(String surname) {
		return null;
	}

}
