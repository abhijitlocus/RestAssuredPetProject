package independentTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Employee;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class testPutEmployee {

    Employee employee;

    @BeforeClass
    public void prepareData() {
        employee = new Employee();
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/";
        RestAssured.basePath = "update/" + employee.getId();
    }

    @Test
    public void testPutEmployee() {
        given()
                .contentType(ContentType.JSON)
                .body(employee).log().all()
        .when()
                .put()
        .then()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo("success"))
                .body("data.name", equalTo(employee.getName()))
                .body("data.salary", equalTo(employee.getSalary()))
                .body("data.age", equalTo(employee.getAge()))
                .body("message", equalTo("Successfully! Record has been updated.")).log().all();
    }
}
