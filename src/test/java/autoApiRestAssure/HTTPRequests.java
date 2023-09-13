package autoApiRestAssure;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import java.util.HashMap;
/*
	given()
		content type, set cookie, add auth, add param, set headers info ...
	when()
		get, post, put, delete
	then()
		validate status  code, axtract response, extract headers cookies & response body
		*/


public class HTTPRequests {
	int id;
	@Test(priority = 1)
	void getUser() {

		given().when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2)).log().all();

	}
	@Test(priority = 2)
	void creatUser() {
		HashMap data = new HashMap<>();
		data.put("name","pavan");
		data.put("job","trainer");
		id = given()
				.contentType("application/json")
				.body(data)
		.when()
				.post("https://reqres.in/api/users")
				.jsonPath().getInt("id");
//				.then()
//				.statusCode(201)
//				.log().all();
		System.out.println(id);

					}
	@Test(priority = 3, dependsOnMethods = {"creatUser"})
	void updateUser() {
		HashMap data = new HashMap<>();
		data.put("name","john");
		data.put("job","teacher");
		given()
				.contentType("application/json")
				.body(data)
				.when()
				.put("https://reqres.in/api/users/" + id)
				.then()
				.statusCode(200)
				.log().all();
	}
	@Test(priority = 4)
	void deleteUser(){
		given()
				.when()
				.delete("https://reqres.in/api/users/" + id)

				.then()
				.statusCode(204)
				.log().all();
	}
}
