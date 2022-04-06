package se.yrgo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import se.yrgo.dataaccess.EmployeeNotFoundException;
import se.yrgo.domain.Employee;
import se.yrgo.service.EmployeeManagementService;

@Stateless
@Path("/employees")
public class EmployeeResource {

	@Inject
	private EmployeeManagementService service;

	@GET
	@Produces("application/JSON")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}

	@GET
	@Produces("application/JSON")
	@Path("{employeeNumber}")
	public Response findEmployeeById(@PathParam("employeeNumber") int id) {
		try {
			Employee result = service.getById(id);
			return Response.ok(result).build();
		} catch (EmployeeNotFoundException e) {
			return Response.status(404).build();
		}
	}

	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Employee createEmployee(Employee employee) {
		service.registerEmployee(employee);
		return employee;
	}
}
