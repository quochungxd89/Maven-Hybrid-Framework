package autoApiRestAssure;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

public class CookiesDemo {
   @Test(priority = 1)
    void testCookies(){
        given()

                .when()
                .get("https://www.google.com/")

                .then()
                .cookie("AEC","Ad49MVEXxoHheKoitzuSh5PpX7EwWZJHdVrZYo6d6n9H3L43GGZ_HckXW4g")
                .log().all();
    }
    @Test(priority = 2)
    void getCookiesInfo(){
       Response res = given()

                .when()
                .get("https://www.google.com/");

       //get single cookie info
       // String Cookie_value = res.getCookie("AEC");
   // System.out.println("Value of cookie is ===>" + Cookie_value);

        //get all cookies info
        Map<String,String> cookies_values = res.getCookies();
        for (String k : cookies_values.keySet()){
            String cookie_value = res.getCookie(k);
            System.out.println(k + "  "+ cookie_value);
        }
    }
}
