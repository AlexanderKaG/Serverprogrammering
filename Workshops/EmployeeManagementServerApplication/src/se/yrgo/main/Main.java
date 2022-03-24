package se.yrgo.main;

import java.util.List;

import se.yrgo.domain.Employee;
import se.yrgo.service.EmployeeManagementImplementation;
import se.yrgo.service.EmployeeManagementService;

public class Main {

	public static void main(String[] args) {

		EmployeeManagementService service = new EmployeeManagementImplementation();

		List<Employee> employees = service.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee);
		}

	}

}
