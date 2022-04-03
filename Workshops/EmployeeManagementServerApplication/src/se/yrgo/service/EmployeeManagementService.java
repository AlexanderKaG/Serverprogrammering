package se.yrgo.service;

import java.util.List;

import javax.ejb.Local;

import se.yrgo.domain.Employee;

@Local
public interface EmployeeManagementService {

	public Employee getById(int id);

	public void registerEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public List<Employee> searchBySurname(String surname);
}
