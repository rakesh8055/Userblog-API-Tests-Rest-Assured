package com.api.tests;

import blog.modules.posts.Posts;
import blog.modules.users.Users;
import common.RestUtilities;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;


public class UserTests {

    Users users = new Users();
    Posts posts = new Posts();
    RequestSpecification withReqSpec;
    ResponseSpecification withResSpec;
    private int userId = 0;
    private List<Long> idsForAllPosts = new ArrayList<Long>();

    @BeforeClass
    public void setup() {
        RestUtilities restUtilities = new RestUtilities();
        withReqSpec = restUtilities.getRequestSpecification();
        withResSpec = restUtilities.getResponseSpecification();
    }

    @Test
    public void getUsersData() {
        users.getUsers(withReqSpec)
             .getUsersIsExecutedSuccessfully(withResSpec);
    }

    @Test(dependsOnMethods = "getUsersData")
    public void searchForGivenUser() {
        userId = users.searchForGivenUserAndFetchUserId("Samantha");
        assertTrue(userId > 0,"Given user does not exist in the system");
    }

    @Test(dependsOnMethods = "searchForGivenUser")
    public void getAllPostsForGivenUser(){
        idsForAllPosts = posts.getResponseOfAllPostsForGivenUserId(withReqSpec, withResSpec, userId)
                              .extractIdsForAllThePosts();
    }
}
