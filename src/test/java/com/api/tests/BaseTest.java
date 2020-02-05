package com.api.tests;

import blog.modules.comments.Comments;
import blog.modules.posts.Posts;
import blog.modules.users.Users;
import common.RestUtilities;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    Users users = new Users();
    Posts posts = new Posts();
    Comments comments = new Comments();
    RequestSpecification withReqSpec;
    ResponseSpecification withResSpec;

    @BeforeClass
    public void setup() {
        RestUtilities restUtilities = new RestUtilities();
        withReqSpec = restUtilities.getRequestSpecification();
        withResSpec = restUtilities.getResponseSpecification();
    }
}
