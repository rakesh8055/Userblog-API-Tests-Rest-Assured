package common;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RestUtilities {
    public static RequestSpecBuilder REQUEST_BUILDER;
    public static RequestSpecification REQUEST_SPEC;
    BaseConfiguration config = new BaseConfiguration();
    String baseUri = config.getProperty("baseurl");

    public RequestSpecification getResponseSpecification() {
        REQUEST_BUILDER = new RequestSpecBuilder();
        REQUEST_BUILDER.setBaseUri(baseUri);
        REQUEST_SPEC = REQUEST_BUILDER.build();
        return REQUEST_SPEC;
    }
}
