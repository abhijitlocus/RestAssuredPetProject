package request;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import models.User;
import route.GoRestRoute;

import static io.restassured.RestAssured.given;

public class GoRestRequest {

    //TODO: get the token form env variable
    private static final String AUTH_TOKEN = "a70ff12470d169e868e27a3babe63746a162c14efac8b7d6ef0b2c073c57f6ec";

    public static ValidatableResponse postUsers(User user) {
        return getAuthorization(AUTH_TOKEN)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(GoRestRoute.getUsers()).then().log().all();
    }

    private static RequestSpecification getAuthorization(String authToken) {
        return given()
                .header("Authorization", "Bearer " + authToken).log().all();
    }
}
