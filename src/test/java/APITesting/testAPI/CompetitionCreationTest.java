package APITesting.testAPI;

import APITesting.files.Payload;
import APITesting.files.ReusableMethods;
import lt.techin.utils.DataGenerator;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class CompetitionCreationTest extends BaseTest {

    @Test
    void adminCanCreateCompetition() {

        String token = ReusableMethods.getToken("admin@mail.com", "qweQWE123!");

        given().log().all().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(Payload.createCompetition("Mano geriausia " + DataGenerator.addSixLetters(), "My best", 5))
                .when().post("/api/v1/competition")
                .then().log().all().assertThat().statusCode(200).time(lessThan(2000L));
    }

    @Test
    void adminCanCreateUpdateDeleteCompetition() {

        String token = ReusableMethods.getToken("admin@mail.com", "qweQWE123!");

        String response = given().log().all().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(Payload.createCompetition("Mano geriausia " + DataGenerator.addSixLetters(), "My best", 5))
                .when().post("/api/v1/competition")
                .then().log().all().assertThat().statusCode(200).time(lessThan(2000L)).extract().response().asString();

        String uuid = ReusableMethods.rawToJson(response).getString("competition.uuid");

        given().log().all()
                .header("Authorization", "Bearer " + token)
                .when().get("/api/v1/competition/" + uuid)
                .then().log().all().assertThat().statusCode(200).time(lessThan(2000L));

        given().log().all().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(Payload.createCompetition("Mano blogiausia " + DataGenerator.addSixLetters(), "My worst", 5))
                .when().put("/api/v1/competition/" + uuid)
                .then().log().all().assertThat().statusCode(200).time(lessThan(2000L));

        given().log().all().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when().delete("/api/v1/competition/" + uuid)
                .then().log().all().assertThat().statusCode(200).time(lessThan(2000L));

        given().log().all()
                .header("Authorization", "Bearer " + token)
                .when().get("/api/v1/competition/" + uuid)
                .then().log().all().assertThat().statusCode(404).time(lessThan(2000L));
    }
}
