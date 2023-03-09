package request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User;
import org.testng.Assert;
import route.GoRestRoute;

import static io.restassured.RestAssured.given;

public class GoRestRequest {

    //-DAUTH_TOKEN=a70ff12470d169e868e27a3babe63746a162c14efac8b7d6ef0b2c073c57f6ec
    private static final String AUTH_TOKEN = System.getProperty("AUTH_TOKEN");

    public static User postUser(User user) {
        Response postResponse = getAuthorization(AUTH_TOKEN)
                .contentType(ContentType.JSON)
                .body(user)
                .post(GoRestRoute.postUser());
        Assert.assertEquals(postResponse.getStatusCode(), 201);
        return postResponse.as(User.class);
    }

    public static User getUser(String userId) {
        Response getResponse = getAuthorization(AUTH_TOKEN)
                .contentType(ContentType.JSON)
                .when()
                .get(GoRestRoute.getUser(userId));
        Assert.assertEquals(getResponse.getStatusCode(), 200);
        return getResponse.as(User.class);
    }

    private static RequestSpecification getAuthorization(String authToken) {
        return given()
                .header("Authorization", "Bearer " + authToken).log().all();
    }
}
