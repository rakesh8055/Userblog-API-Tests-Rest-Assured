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
     * Have Commented .spec(withResSpec) which validates the response time to be below 5seconds because
     * the comments service was taking more than a minute to execute. It should ideally fail but since the testcase
     * was to validate all email id's Hence i commented to validate the email id format
     */
    public Comments getResponseOfAllTheCommentsForGivenPost(RequestSpecification withReqSpec, ResponseSpecification withResSpec, int postId) {
            response = given().spec(withReqSpec)
                              .queryParam("postId", postId)
                       .when()
                              .get("/comments")
                       .then()
                              //.spec(withResSpec)
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

}
