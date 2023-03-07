package independentTests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class testDeleteEmployee {

    private String empId = "11255";

    @BeforeClass
    public void prepareData() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/";
        RestAssured.basePath = "delete/" + empId;
    }

    @Test
    public void testDeleteEmployee() {
        given()
        .when()
                .delete()
        .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .body("status", equalTo("success"))
                .body("data", equalTo(empId))
                .body("message", equalTo("Successfully! Record has been deleted"));
    }

}
