import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RequestMethodsTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGet() {
        Response response = RestAssured.given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get");

        assertEquals(200, response.statusCode());

        assertEquals("bar1", response.jsonPath().getString("args.foo1"));
        assertEquals("bar2", response.jsonPath().getString("args.foo2"));

        String expectedUrl = "https://postman-echo.com/get?foo1=bar1&foo2=bar2";
        assertEquals(expectedUrl, response.jsonPath().getString("url"));
    }

    @Test
    public void testPostRaw() {
        String requestBody = "{\n   \"test\": \"value\"\n}";

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/post");

        assertEquals(200, response.getStatusCode());
        assertEquals("[test:value]", response.jsonPath().getString("data"));

        String expectedUrl = "https://postman-echo.com/post";
        assertEquals(expectedUrl, response.jsonPath().getString("url"));
    }

    @Test
    public void testPut() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = RestAssured.given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .put("/put");

        assertEquals(200, response.getStatusCode());
        assertEquals(requestBody, response.jsonPath().getString("data"));

        String expectedUrl = "https://postman-echo.com/put";
        assertEquals(expectedUrl, response.jsonPath().getString("url"));
    }

    @Test
    public void testPatch() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = RestAssured.given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .patch("/patch");

        assertEquals(200, response.getStatusCode());
        assertEquals(requestBody, response.jsonPath().getString("data"));

        String expectedUrl = "https://postman-echo.com/patch";
        assertEquals(expectedUrl, response.jsonPath().getString("url"));
    }

    @Test
    public void testDelete() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = RestAssured.given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .delete("/delete");

        assertEquals(200, response.getStatusCode());
        assertEquals(requestBody, response.jsonPath().getString("data"));

        String expectedUrl = "https://postman-echo.com/delete";
        assertEquals(expectedUrl, response.jsonPath().getString("url"));
    }
}

