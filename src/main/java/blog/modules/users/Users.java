package blog.modules.users;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class Users {

    private Response response;
    private int userId = 0;

    public Users getUsers(RequestSpecification withReqSpec) {
        response =  given().spec(withReqSpec).
               when().get("/users").
               then().extract().response();
        return this;
    }

    public Users getUsersIsExecutedSuccessfully(ResponseSpecification withResSpec) {
        response.then().spec(withResSpec);
        return this;
    }

    public int searchForGivenUserAndFetchUserId(String username){
        try {
            userId = (Integer) response.path("find { it.username == '%s' }.id", username);
            return userId;
        }catch(NullPointerException e){
            return 0;
        }
    }
}
