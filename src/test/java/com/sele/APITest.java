package come.sele;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {

    @Test
    public void verifyUserAPI() {

        // Base URI
        baseURI = "https://jsonplaceholder.typicode.com";

        // Send request + store response
        Response response =
                given()
                    .header("Content-Type", "application/json")
                .when()
                    .get("/users/1")
                .then()
                    .assertThat()
                    .statusCode(200)
                    .time(lessThan(2000L))   // performance check
                    .body("id", equalTo(1))
                    .body("name", notNullValue())
                    .body("email", containsString("@"))
                    .extract()
                    .response();

        // Extra validations (important for interview)
        String responseBody = response.asString();
        System.out.println("Response: " + responseBody);

        // Validate headers
        String contentType = response.getHeader("Content-Type");
        Assert.assertTrue(contentType.contains("application/json"));

        // Validate response size
        Assert.assertTrue(responseBody.length() > 0);

        System.out.println("API validated successfully ✅");
    }
}