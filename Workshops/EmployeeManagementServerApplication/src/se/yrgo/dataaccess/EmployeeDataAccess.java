package se.yrgo.dataaccess;

import java.util.List;

import javax.ejb.Local;

import se.yrgo.domain.Employee;

@Local
public interface EmployeeDataAccess {
	public void insert(Employee newEmployee);

	public List<Employee> findAll();

	public List<Employee> findBySurname(String surname);
}
