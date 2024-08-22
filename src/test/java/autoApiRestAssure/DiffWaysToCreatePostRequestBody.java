package autoApiRestAssure;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class DiffWaysToCreatePostRequestBody {
    //1. Post request body using Hashmap
   @Test(priority = 1)
    void testPostUsingHashmap(){
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("name","Scott");
        data.put("location", "France");
        data.put("phone","1232325");
       String courseArr[] = {"C","C++"};
       data.put("course",courseArr);

       given()
               .contentType("application/json")
                       .body(data)

               .when()
                       .post("https://reqres.in/api/users")

               .then()
               .statusCode(201)
               .body("name",equalTo("Scott"))
               .body("location",equalTo("France"))
               .body("phone",equalTo("1232325"))
               .body("course[0]",equalTo("C"))
               .body("course[1]",equalTo("C++"))
               .header("content-Type","application/json;charset=utf-8")
               .log().all();

    }
    @Test(priority = 2)
    void testDelete(){
       given()

               .when()
               .delete("https://reqres.in/api/users/3")

               .then()
               .statusCode(200);
    }

    //2. Post request body using org.json library
    @Test(priority = 3)
    void testPostUsingJsonLibrary(){
        JSONObject data = new JSONObject();
            data.put("name", "Scott");
            data.put("location", "France");
            data.put("phone","1232325");

            String courseArr[] = {"C","C++"};
            data.put("course",courseArr);

        given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://reqres.in/api/users")

                .then()
                .statusCode(201)
                .body("name",equalTo("Scott"))
                .body("location",equalTo("France"))
                .body("phone",equalTo("1232325"))
                .body("course[0]",equalTo("C"))
                .body("course[1]",equalTo("C++"))
                .header("content-Type","application/json;charset=utf-8")
                .log().all();

    }
    //3. Post request body using PoJo class
    @Test(priority = 3)
    void testPostUsingPojoClass(){
        Pojo_PostRequest data = new Pojo_PostRequest();
            data.setName("Scott");
            data.setLocation("France");
            data.setPhone("1232325");

            String courseArr[] = {"C","C++"};
            data.setCourse(courseArr);

        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://reqres.in/api/users")

                .then()
                .statusCode(201)
                .body("name",equalTo("Scott"))
                .body("location",equalTo("France"))
                .body("phone",equalTo("1232325"))
                .body("course[0]",equalTo("C"))
                .body("course[1]",equalTo("C++"))
                .header("content-Type","application/json;charset=utf-8")
                .log().all();

    }//4. Post request body using External Json file
    @Test(priority = 3)
    void testPostUsingExternalJsonfile() throws FileNotFoundException {
       File f = new File(".\\body.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);

        given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://reqres.in/api/users")

                .then()
                .statusCode(201)
                .body("name",equalTo("Scott"))
                .body("location",equalTo("France"))
                .body("phone",equalTo("1232325"))
                .body("course[0]",equalTo("C"))
                .body("course[1]",equalTo("C++"))
                .header("content-Type","application/json;charset=utf-8")
                .log().all();

    }

}
