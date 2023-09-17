package petStore.api.endpoints;
//UserEndPoints.java

//Created for perform Create, Read, Update, Delete requests the user API

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petStore.api.payload.User;

import static io.restassured.RestAssured.given;

public class UserEndPoints {
	public static Response createUser(User payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when().post(Routes.post_url);
		return response;
	}

	public static Response readUser(String username) {
		Response response = given().pathParams("username", username).when().get(Routes.get_url);
		return response;
	}

	public static Response updateUser(String username, User payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParams("username", username).body(payload).when().put(Routes.update_url);
		return response;
	}

	public static Response deleteUser(String username) {
		Response response = given().pathParams("username", username).when().delete(Routes.delete_url);
		return response;
	}

}
