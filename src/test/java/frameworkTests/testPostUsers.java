package frameworkTests;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import models.User;
import request.GoRestRequest;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;

public class testPostUsers {

    private User user = new User();

    @Test
    public void testPostUsers() {

        ValidatableResponse response = GoRestRequest.postUsers(user);
        response
                .assertThat()
                .statusCode(201)
                .and()
                .body("id", isA(Integer.class))
                .body("name", equalTo(user.getName()))
                .body("email", equalTo(user.getEmail()))
                .body("gender", equalTo(user.getGender().toString()))
                .body("status", equalTo(user.getStatus().toString()));
    }
}
