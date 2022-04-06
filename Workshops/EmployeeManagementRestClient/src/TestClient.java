import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class TestClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

		Response response = client.target("http://localhost:8080/EmployeeManagement/webservice/employees/4")
				.request("application/JSON").buildGet().invoke();

		System.out.println(response.getHeaders().toString());
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		response.close();
	}
}
