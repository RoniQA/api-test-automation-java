package automation.api.test;

import automation.api.domain.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class UserTest {

    @BeforeAll
    public static void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI = "https://reqres.in";
        basePath = "/api";
    }

    @Test
    public void testUserListData() {
        given().
            params("page", "2").
        when().
            get("/users").
        then().
            statusCode(HttpStatus.SC_OK).
            body("page", is(2)).
            body("data", is(notNullValue()));
    }

    @Test
    public void testUserCreationWithSuccess() {
        User user = new User("Roni", "QA");
        given().
            contentType(ContentType.JSON).
            body(user).
        when().
            post("/users").
        then().
            statusCode(HttpStatus.SC_CREATED).
            body("name", is("Roni"));
    }
}

