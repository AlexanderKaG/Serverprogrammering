import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class TestClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

		Employee ben = new Employee();
		ben.setFirstName("Ben");
		ben.setSurname("Red");
		ben.setJobRole("Tester");
		ben.setSalary(1000);

		Entity benEntity = Entity.entity(ben, "application/JSON");

		Response response = client.target("http://localhost:8080/EmployeeManagement/webservice/employees").request()
				.buildPost(benEntity).invoke();

		System.out.println(response.readEntity(Employee.class).getId());
		response.close();

		response = client.target("http://localhost:8080/EmployeeManagement/webservice/employees").request().buildGet()
				.invoke();

		List<Employee> employees = response.readEntity(new GenericType<List<Employee>>() {
		});

		for (Employee e : employees) {
			System.out.println(e);
		}

		response.close();
	}
}
