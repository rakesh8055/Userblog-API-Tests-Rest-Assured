package com.api.tests;

import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class JsonSchemaValidations extends BaseTest{

    @Test
    public void verifyJsonSchemaForGetUserDetails() {
        String responseBody = users.getUsers(withReqSpec)
                                   .getResponseBody();
        assertThat(responseBody, matchesJsonSchemaInClasspath("userdetails.json"));
    }

    @Test
    public void verifyJsonSchemaForGetPostswithValidUserId() {
        String responseBody = posts.getResponseOfAllThePostsForGivenUserId(withReqSpec, withResSpec, 3)
                                   .getResponseBody();
        assertThat(responseBody, matchesJsonSchemaInClasspath("userposts.json"));
    }

    @Test
    public void verifyJsonSchemaForGetPostswithInvalidUserId() {
        String responseBody = posts.getResponseOfAllThePostsForGivenUserId(withReqSpec, withResSpec, 0)
                .getResponseBody();
        assertThat(responseBody, matchesJsonSchemaInClasspath("emptydata.json"));
    }

    @Test
    public void verifyJsonSchemaForGetCommentsForValidPostId() {
        String responseBody = comments.getResponseOfAllTheCommentsForGivenPost(withReqSpec, withResSpec, 1)
                                      .getResponseBody();
        assertThat(responseBody, matchesJsonSchemaInClasspath("comments.json"));
    }

    @Test
    public void verifyJsonSchemaForGetCommentsForInvalidPostId() {
        String responseBody = comments.getResponseOfAllTheCommentsForGivenPost(withReqSpec, withResSpec, 1000)
                .getResponseBody();
        assertThat(responseBody, matchesJsonSchemaInClasspath("comments.json"));
    }

}
