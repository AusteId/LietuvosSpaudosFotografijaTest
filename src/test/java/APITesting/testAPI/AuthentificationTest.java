package APITesting.testAPI;

import APITesting.files.Payload;
import lt.techin.utils.DataGenerator;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class AuthentificationTest extends BaseTest {

    String email = DataGenerator.addSixLetters() + "name.surname@yahoo.com";

    @Test
    void userCanRegister() {

        given().log().all().header("Content-Type", "application/json")
                .body(Payload.addUser(email))
                .when().post("/api/v1/register")
                .then().log().all().assertThat().statusCode(200).time(lessThan(2000L));
    }

    @Test
    void userCanLogin() {

        given().log().all().header("Content-Type", "application/json")
                .body(Payload.loginUser("user@mail.com", "qweQWE123!"))
                .when().post("/api/v1/login")
                .then().log().all().assertThat().statusCode(200).time(lessThan(2000L));
    }

    @Test
    void adminCanLogin() {
        given().log().all().header("Content-Type", "application/json")
                .body(Payload.loginUser("admin@mail.com", "qweQWE123!"))
                .when().post("/api/v1/login")
                .then().log().all().assertThat().statusCode(200).time(lessThan(2000L));
    }

    @Test
    void moderatorCanLogin() {

        given().log().all().header("Content-Type", "application/json")
                .body(Payload.loginUser("moderator@mail.com", "qweQWE123!"))
                .when().post("/api/v1/login")
                .then().log().all().assertThat().statusCode(200).time(lessThan(2000L));
    }

    @Test
    void juryCanLogin() {

        given().log().all().header("Content-Type", "application/json")
                .body(Payload.loginUser("jury@mail.com", "qweQWE123!"))
                .when().post("/api/v1/login")
                .then().log().all().assertThat().statusCode(200).time(lessThan(2000L));
    }

    @Test
    void userCanNotLoginWithWrongPassword() {

        String expectedErrorMessage = "Bad credentials";

        given().log().all().header("Content-Type", "application/json")
                .body(Payload.loginUser("user@mail.com", "QQww11!"))
                .when().post("/api/v1/login")
                .then().log().all().assertThat().statusCode(401).time(lessThan(2000L)).extract().response().asString()
                .equalsIgnoreCase(expectedErrorMessage);
    }

    @Test
    void userCanUseForgotPasswordFunctionality() {

        String expectedErrorMessage = "If the user exists in our database, an email link will be sent.";

        given().log().all().header("Content-Type", "application/json")
                .body(Payload.changePassword("user@mail.com"))
                .when().post("/api/v1/forget-password")
                .then().log().all().assertThat().time(lessThan(2000L)).extract().response().asString()
                .equalsIgnoreCase(expectedErrorMessage);
    }
}
