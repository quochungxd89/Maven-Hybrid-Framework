package petStore.api.test;

import io.restassured.response.Response;
import net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly;

import org.testng.Assert;
import org.testng.annotations.Test;
import petStore.api.endpoints.UserEndPoints;
import petStore.api.payload.User;
import petStore.api.utilities.DataProviders;
import static org.hamcrest.Matchers.equalTo;

public class DataDrivenTests {
	User userPayload;
	Response response;

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String ID, String username, String firstname, String lastname, String email, String password, String phone) {
		userPayload = new User();
		userPayload.setId(Integer.parseInt(ID));
		userPayload.setUsername(username);
		userPayload.setFirstName(firstname);
		userPayload.setLastName(lastname);
		userPayload.setEmail(email);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);

		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testGetUserByName(String userName) {
		Response response = UserEndPoints.readUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().body("username", equalTo(userName));

	}

	@Test(priority = 3, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testGetfirstNameByName(String userName) {
		Response response = UserEndPoints.readUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().body("firstName", equalTo("John"));
		response.then().body("firstName", equalTo("Kim"));
		response.then().body("firstName", equalTo("Smith"));

	}

	@Test(priority = 4, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String userName) {
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
