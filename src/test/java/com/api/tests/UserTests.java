package com.api.tests;

import blog.modules.users.Users;
import common.RestUtilities;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;


public class UserTests {

    Users users = new Users();
    RequestSpecification reqSpec;

    @BeforeClass
    public void setup() {
        RestUtilities restUtilities = new RestUtilities();
        reqSpec = restUtilities.getResponseSpecification();
    }

    @Test
    public void getUsersData() {
        users.getUsers(reqSpec)
             .getUsersIsExecutedSuccessfully();
    }

    @Test(dependsOnMethods = "getUsersData")
    public void searchForGivenUser() {
        int userId = users.searchForGivenUserAndFetchUserId("Samantha");
        assertTrue(userId > 0,"Given user does not exist in the system");
    }
}
