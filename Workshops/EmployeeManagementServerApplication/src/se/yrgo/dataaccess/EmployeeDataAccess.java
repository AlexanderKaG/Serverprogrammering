package se.yrgo.dataaccess;

import java.util.List;

import javax.ejb.Local;

import se.yrgo.domain.Employee;

@Local
public interface EmployeeDataAccess {

	public Employee findById(int id);

	public void insert(Employee newEmployee);

	public List<Employee> findAll();

	public List<Employee> findBySurname(String surname);
}