package com.api.tests;

import blog.modules.users.GetUsers;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class GetUserTest {

    GetUsers getUsersAndTheirData = new GetUsers();

    @Test
    public void testGetUsers(){
        assertEquals(getUsersAndTheirData.getUsers().statusCode(),200);
    }
}
