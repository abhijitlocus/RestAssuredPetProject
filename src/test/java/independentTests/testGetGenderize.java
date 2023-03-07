package independentTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class testGetGenderize {

    public static final String URL = "https://api.genderize.io";
    private Map<String, String> dataSet = new HashMap<>();

    @BeforeClass
    public void prepareData() {
        dataSet.put("rupam", "male");
        dataSet.put("Abhijit", "male");
        dataSet.put("", null);
        dataSet.put("Sayanti", "female");
        dataSet.put("12345", null);
        dataSet.put("rup@#%&^%*am", null);
        dataSet.put("hhgfsdkjfhgkjhsdfkjhgjkhsdgfkjhgsdkjhfgkjhsgdkjhgakjhgkjhgdfkjhgaskdjhfgkajhsdgkfjhgaskjdhfakjhsdgfkjhagsdjfhgaksjdhgfkjahsgdkjfhagskdjfhgaksjdhfg", null);
        dataSet.put("Ashok Kumar Das", null);
    }

    @Test
    public void getGender() {

        for (Map.Entry<String, String> data : dataSet.entrySet()) {

            System.out.println(data.getKey());

            given()
                    .queryParam("name", data.getKey())
                    .when()
                    .get(URL)
                    .then()
                    .statusCode(200)
                    .assertThat()
                    .body("Gender", equalTo(data.getValue()))
                    .header("Connection", "keep-alive");
        }
    }
}
