package autoApiRestAssure;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import groovyjarjarantlr4.v4.codegen.model.SrcOp;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ParsingJsonResponseData {
    @Test(priority = 1)
    void testJsonResponse(){
        given()
                .contentType("ContentType.JSON")
                .when()
                .get("https://reqres.in/api/users")

                .then()
                .statusCode(200)
                .header("Content-Type","application/json; charset=utf-8")
                .body("data[2].email",equalTo("emma.wong@reqres.in"));
    }
    @Test(priority = 2)
    void testJsonResponse2(){
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users");
        Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
        String email = res.jsonPath().get("data[2].email").toString();

        Assert.assertEquals(email,"emma.wong@reqres.in");
    }
    @Test(priority = 3)
    void testJsonResponseBodyData() {
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users");
       /* Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
        String email = res.jsonPath().get("data[2].email").toString();

        Assert.assertEquals(email,"emma.wong@reqres.in");*/

        //JSONObject class
        JSONObject jo = new JSONObject(res.asString()); // chuyen doi response sang Json Object Type
//        for (int i=0;i<jo.getJSONArray("data").length();i++){
//           String email = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
//            System.out.println(email);
//            String firstName = jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
//            System.out.println(firstName);
        //search for email of data in json - validation
        boolean status = false;
        for (int i = 0; i < jo.getJSONArray("data").length(); i++) {
            String email = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
            if (email.equals("janet.weaver@reqres.in")) {
                status = true;
                break;
            }
        }
        Assert.assertEquals(status,true);

        //validate total id
        int totalID = 0;
        for (int i = 0; i < jo.getJSONArray("data").length(); i++) {
            String id = jo.getJSONArray("data").getJSONObject(i).get("id").toString();
            totalID = totalID + Integer.parseInt(id);
            }
        System.out.println("Total of id= " + totalID);
        Assert.assertEquals(totalID,21);
        }
    }



