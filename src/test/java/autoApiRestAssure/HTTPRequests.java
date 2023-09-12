package autoApiRestAssure;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class HTTPRequests {

	@Test
	void getUser() {

		given().when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2)).log().all();

	}
	void creatUser() {

		given().body("pre condition")
				.when().get("https://reqres.in/api/users")
				.then().statusCode(201).body()
	}
}
