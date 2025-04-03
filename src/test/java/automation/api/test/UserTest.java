package automation.api.test;

import automation.api.domain.User;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class UserTest extends BaseTest {

    private static final String LIST_USERS_ENDPOINT = "/users";
    private static final String CREATE_USERS_ENDPOINT = "/user";


    @Test
    @DisplayName("Scnerario: User creation")
    public void testUserListData() {
        given().
            params("page", "2").
        when().
            get(LIST_USERS_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_OK).
            body("page", is(2)).
            body("data", is(notNullValue()));
    }

    @Test
    public void testUserCreationWithSuccess() {
        User user = new User("Roni", "QA", "email@gmail.com");
        given().
            body(user).
        when().
            post(CREATE_USERS_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_CREATED).
            body("name", is("Roni"));
    }
}

