package blog.modules.comments;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Comments {

    Response response;

    /**
     * @param withReqSpec
     * @param withResSpec
     * @param postId
     * @return : response of all comments
     */
    public Comments getResponseOfAllTheCommentsForGivenPost(RequestSpecification withReqSpec, ResponseSpecification withResSpec, int postId) {
            response = given().spec(withReqSpec)
                              .queryParam("postId", postId)
                       .when()
                              .get("/comments")
                       .then()
                              .spec(withResSpec)
                              .extract()
                              .response();
            return this;
    }

    /**
     * @return : list of email ids
     */
    public List<String> extractEmailIdFromResponseAndVerifyFormat() {
         return response.jsonPath().getList("email");
    }

    /**
     * @return : returns response body as String
     */
    public String getResponseBody() {
        return response.getBody().asString();
    }
}
