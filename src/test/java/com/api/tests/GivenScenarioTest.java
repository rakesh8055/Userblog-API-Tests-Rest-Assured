package com.api.tests;

import blog.modules.comments.Comments;
import blog.modules.posts.Posts;
import blog.modules.users.Users;
import common.RestUtilities;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;

public class GivenScenarioTest extends BaseTest {

    private int userId = 0;
    private List<Integer> idsForAllPosts = new ArrayList<Integer>();

    @DataProvider(name = "username")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "Samantha" }};
    }

    @Test
    public void getUsersData() {
        users.getUsers(withReqSpec)
             .getUsersIsExecutedSuccessfully(withResSpec);
    }

    @Test(dependsOnMethods = "getUsersData", dataProvider = "username")
    public void searchForGivenUser(String username) {
        userId = users.searchForGivenUserAndFetchUserId(username);
                       assertTrue(userId > 0,"Given user does not exist in the system");
    }

    @Test(dependsOnMethods = "searchForGivenUser")
    public void getAllPostsForGivenUser(){
        idsForAllPosts = posts.getResponseOfAllThePostsForGivenUserId(withReqSpec, withResSpec, userId)
                              .extractIdsForThesePosts();
                               assertTrue(idsForAllPosts.size() > 0, "No Records returned for given post id");
    }

    @Test(dependsOnMethods = "getAllPostsForGivenUser")
    public void getCommentsForGivenPostsAndVerifyEmailFormat() {
        List<String> emailIds = new ArrayList<String>();
        //Used the below regex assuming there is no specific validation on characters allowed for email format.
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);

        for(int postId : idsForAllPosts){
            emailIds.addAll(comments.getResponseOfAllTheCommentsForGivenPost(withReqSpec, withResSpec, postId)
                    .extractEmailIdFromResponseAndVerifyFormat());
        }
        for(String email : emailIds){
            Matcher matcher = pattern.matcher(email);
            assertTrue(matcher.matches(),"The given email Id = "+email+" is not valid");
        }
    }

}