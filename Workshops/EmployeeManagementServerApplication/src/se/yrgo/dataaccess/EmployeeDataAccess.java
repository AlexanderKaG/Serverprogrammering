package se.yrgo.dataaccess;

import java.util.List;

import se.yrgo.domain.Employee;

public interface EmployeeDataAccess {
	public void insert(Employee newEmployee);

	public List<Employee> findAll();

	public List<Employee> findBySurname(String surname);
}
