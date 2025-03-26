package automation.api.test;

import automation.api.domain.User;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class RegisterTest extends BaseTest {

    private static final String REGISTER_USER_ENDPOINT = "/register";

    @Test
    public void testDontRegisterWithouthAPassword() {
        User user = new User();
        user.setEmail("sydney@fife");

        given().
            body(user).
        when().
            post(REGISTER_USER_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_BAD_REQUEST).
            body("error", is("Missing password"));
    }

}
