package independentTests;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class testMockService {

    WireMockServer wireMockServer = new WireMockServer( 8080);

    @BeforeClass
    public void setup() {
        wireMockServer.start();
        configureFor("localhost", 8080);
        stubFor(get(urlEqualTo("/baeldung")).willReturn(aResponse().withBody("Welcome Abhijit")));
    }

    @Test
    public void exactUrlOnly() {
        ValidatableResponse then = given().
                baseUri("http://localhost:8080/baeldung")
                .when()
                .get()
                .then();
        then
                .assertThat()
                .body(equalTo("Welcome Abhijit"));
    }

    @AfterClass
    public void teardown() {
        wireMockServer.stop();
    }

}
