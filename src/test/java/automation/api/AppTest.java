package automation.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class AppTest {

    @BeforeAll
    public static void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void testUserListData() {
        when().
                get(("https://reqres.in/api/users?page=2")).
        then().
                statusCode(HttpStatus.SC_OK).
                body("page", is(2)).
                body("data", is(notNullValue()));
    }

    @Test
    public void testUserCreationWithSuccess() {
        given().
            contentType(ContentType.JSON).
            body("{\"name\": \"Roni\", \"job\": \"QA\"}").
        when().
            post("https://reqres.in/api/users").
        then().
            statusCode(HttpStatus.SC_CREATED).
            body("name", is("Roni"));
    }
}

