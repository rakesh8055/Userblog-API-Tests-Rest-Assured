package blog.modules.users;

import common.BaseConfiguration;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Users {

    private Response response;
    private int userId = 0;
    BaseConfiguration baseConfiguration = new BaseConfiguration();
    String baseurl = baseConfiguration.getProperty("baseurl");

    public Users getUsers() {
        response =  given().
               when().get(baseurl+"/users").
               then().extract().response();
        return this;
    }

    public Users getUsersIsExecutedSuccessfully() {
        response.then().statusCode(200);
        return this;
    }

    public int searchForGivenUserAndFetchUserId(String username){
        userId = (Integer) response.path("find { it.username == '%s' }.id", username);
        return userId;
    }
}
