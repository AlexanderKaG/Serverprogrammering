package se.yrgo.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import se.yrgo.domain.Employee;

@Stateless
public class EmployeeDataAccessTestingVersion implements EmployeeDataAccess {

	@Override
	public void insert(Employee newEmployee) {
		
	}

	@Override
	public List<Employee> findAll() {
		Employee emp1 = new Employee("Nahid", "V", "teacher", 120);
		Employee emp2 = new Employee("Sara", "Bild", "programmer", 200);
		Employee emp3 = new Employee("David", "Baron", "Manager", 4000);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		return employees;
	}

	@Override
	public List<Employee> findBySurname(String surname) {
		return null;
	}

}
