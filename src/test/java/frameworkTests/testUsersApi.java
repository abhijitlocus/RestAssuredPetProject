package frameworkTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import models.User;
import request.UserServiceRequests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isA;

public class testUsersApi {

    @Test
    public void testPostUsers() {

        User expectedUser = new User();

        User actualUser = UserServiceRequests.postUser(expectedUser);

        assertThat(actualUser.getId(), isA(String.class));
        Assert.assertEquals(actualUser.getName(), expectedUser.getName());
        Assert.assertEquals(actualUser.getEmail(), expectedUser.getEmail());
        Assert.assertEquals(actualUser.getGender(), expectedUser.getGender());
        Assert.assertEquals(actualUser.getStatus(), expectedUser.getStatus());
    }

    @Test
    public void testGetUser() {

        User expectedUser = UserServiceRequests.postUser(new User());

        User actualUser = UserServiceRequests.getUser(expectedUser.getId());

        Assert.assertEquals(actualUser.getId(), expectedUser.getId());
        Assert.assertEquals(actualUser.getName(), expectedUser.getName());
        Assert.assertEquals(actualUser.getEmail(), expectedUser.getEmail());
        Assert.assertEquals(actualUser.getGender(), expectedUser.getGender());
        Assert.assertEquals(actualUser.getStatus(), expectedUser.getStatus());
    }
}
