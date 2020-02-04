package blog.modules.posts;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Reporter;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Posts {

    private Response response;

    /**
     * @param withReqSpec
     * @param withResSpec
     * @param userId
     * @return : returns all posts response
     */
    public Posts getResponseOfAllThePostsForGivenUserId(RequestSpecification withReqSpec, ResponseSpecification withResSpec, int userId) {
        response = given().spec(withReqSpec)
                .when()
                .queryParam("userId", userId)
                .get("/posts")
                .then().spec(withResSpec)
                .extract().response();
        return this;
    }

    /**
     * @return : list of ids of Posts
     */
    public List<Integer> extractIdsForThesePosts(){
        return response.jsonPath().getList("id");
    }
}
