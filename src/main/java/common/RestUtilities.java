package common;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class RestUtilities {
    public static RequestSpecBuilder REQUEST_BUILDER;
    public static RequestSpecification REQUEST_SPEC;
    public static ResponseSpecBuilder RESPONSE_BUILDER;
    public static ResponseSpecification RESPONSE_SPEC;

    BaseConfiguration config = new BaseConfiguration();
    String baseUri = config.getProperty("baseurl");

    public RequestSpecification getRequestSpecification() {
        REQUEST_BUILDER = new RequestSpecBuilder();
        REQUEST_BUILDER.setBaseUri(baseUri);
        REQUEST_SPEC = REQUEST_BUILDER.build();
        return REQUEST_SPEC;
    }

    public ResponseSpecification getResponseSpecification() {
        RESPONSE_BUILDER = new ResponseSpecBuilder();
        RESPONSE_BUILDER.expectStatusCode(200);
        RESPONSE_BUILDER.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);
        RESPONSE_SPEC = RESPONSE_BUILDER.build();
        return RESPONSE_SPEC;
    }
}
