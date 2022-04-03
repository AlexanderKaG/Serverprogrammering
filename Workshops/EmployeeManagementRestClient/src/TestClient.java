import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class TestClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/EmployeeManagement/webservice/employees/4").request()
				.buildGet().invoke();

		Employee employee = response.readEntity(Employee.class);
		System.out.println(employee);

		response.close();

		response = client.target("http://localhost:8080/EmployeeManagement/webservice/employees").request().buildGet()
				.invoke();

		List<Employee> employees = response.readEntity(new GenericType<List<Employee>>() {
		});

		for (Employee e : employees) {
			System.out.println(e);
		}
	}
}
