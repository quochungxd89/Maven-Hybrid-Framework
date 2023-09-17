package petStore.api.endpoints;
//UserEndPoints.java

//Created for perform Create, Read, Update, Delete requests the user API

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petStore.api.payload.User;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

public class UserEndPoints2 {

	// method created for getting URL's from properties file
	static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes"); // Load properties file
		return routes;
	}

	public static Response createUser(User payload) {
		String post_url = getURL().getString("post_url");
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when().post(post_url);
		return response;
	}

	public static Response readUser(String username) {
		String get_url = getURL().getString("get_url");
		Response response = given().pathParams("username", username).when().get(get_url);
		return response;
	}

	public static Response updateUser(String username, User payload) {
		String update_url = getURL().getString("update_url");

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParams("username", username).body(payload).when().put(update_url);
		return response;
	}

	public static Response deleteUser(String username) {
		String delete_url = getURL().getString("delete_url");

		Response response = given().pathParams("username", username).when().delete(delete_url);
		return response;
	}

}
