package com.api.tests;

import dto.PostsPojo;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class CreatePostsTest extends BaseTest {

    @Test
    public void verifyCreatePosts(){
        PostsPojo newPost = new PostsPojo(3, 1, "Test Title", "Test Body");
        assertTrue(posts.createANewPostForAUserId(withReqSpec, newPost)==201, "Adding the given post was Unsuccessful");
    }

}
