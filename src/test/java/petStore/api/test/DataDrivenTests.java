package petStore.api.test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import petStore.api.endpoints.UserEndPoints;
import petStore.api.payload.User;
import petStore.api.utilities.DataProviders;

public class DataDrivenTests {
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String ID, String username, String firstname, String lastname, String email, String password, String phone) {
		User userPayload = new User();

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
	public void testDeleteUserByName(String userName) {
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
