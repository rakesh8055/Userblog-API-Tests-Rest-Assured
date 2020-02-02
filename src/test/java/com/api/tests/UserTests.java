package com.api.tests;

import blog.modules.users.Users;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class UserTests {

    Users users = new Users();

    @Test
    public void getUsersData() {
        users.getUsers()
             .getUsersIsExecutedSuccessfully();
    }

    @Test
    public void searchForGivenUser() {
        int userId = users.searchForGivenUserAndFetchUserId("Samantha");
        assertTrue(userId>0,"User Does not Exist");
    }
}
