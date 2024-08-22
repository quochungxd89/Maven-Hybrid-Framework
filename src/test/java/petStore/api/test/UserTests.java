package petStore.api.test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petStore.api.endpoints.UserEndPoints;
import petStore.api.payload.User;

public class UserTests {
	Faker faker;
	User userPayload;
	public Logger logger;

	@BeforeClass
	public void setupData() {
		faker = new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		// logs
		logger = LogManager.getLogger(this.getClass());
	}

	@Test(priority = 1)
	public void testPostUser() {
		logger.info("**************Creating user**************");
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**************User info is displayed**************");

	}

	@Test(priority = 2)
	public void testGetUserByName() {
		logger.info("**************Reading user info**************");

		Response response = UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();

		// verify du lieu
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().body("username", equalTo(this.userPayload.getUsername()));
		logger.info("**************User info is displayed**************");

	}

	 @Test(priority = 3)
	public void testUpdateUserByName() {
		 Response response = UserEndPoints.readUser(this.userPayload.getUsername());
		 response.then().log().body();
		logger.info("**************Updating user**************");
		// Update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());

		response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

		logger.info("**************User updated**************");
		// checking data after update
		Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	}

	 @Test(priority = 4)
	public void testDeleteUserByName() {
		logger.info("**************Deleting user**************");
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**************user deleted**************");
	}
}
