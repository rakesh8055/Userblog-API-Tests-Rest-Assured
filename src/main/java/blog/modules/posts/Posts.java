package blog.modules.posts;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Posts {

    private Response response;

    public Posts getResponseOfAllPostsForGivenUserId(RequestSpecification withReqSpec, ResponseSpecification withResSpec, int userId) {
        response = given().spec(withReqSpec)
                .when()
                .queryParam("userId", userId)
                .get("/posts")
                .then().spec(withResSpec)
                .extract().response();
        return this;
    }

    public List<Long> extractIdsForAllThePosts(){
        return response.jsonPath().getList("id");
    }
}
