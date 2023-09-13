package autoApiRestAssure;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import groovyjarjarantlr4.v4.codegen.model.SrcOp;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LoggingDemo {
    @Test(priority = 1)
    void testLogs(){
        given()

                .when()
                .get("https://reqres.in/api/users?page=2")

                .then()
                //.log().body();
                //.log().cookies();
                .log().headers();

    }
}
