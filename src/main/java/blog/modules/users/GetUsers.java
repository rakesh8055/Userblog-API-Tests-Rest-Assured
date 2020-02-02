package blog.modules.users;

import common.BaseConfiguration;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class GetUsers {

    BaseConfiguration baseConfiguration = new BaseConfiguration();
    String baseurl = baseConfiguration.getProperty("baseurl");

    public Response getUsers() {
        return given().
               when().get(baseurl).
               then().extract().response();
    }

}
