package automation.api;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    public void testUserListData() {
        when().
                get(("https://reqres.in/api/users?page=2")).
        then().
                statusCode(HttpStatus.SC_OK).
                body("page", is(2)).
                body("data", is(notNullValue()));
    }
}

