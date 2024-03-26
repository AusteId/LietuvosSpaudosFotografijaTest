package APITesting.files;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class ReusableMethods {

    public static JsonPath rawToJson(String response) {
        JsonPath json = new JsonPath(response);
        return json;
    }

    public static String getToken(String email, String password) {

        String response = given().log().all().header("Content-Type", "application/json")
                .body(Payload.loginUser(email, password))
                .when().post("/api/v1/login")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        String token = rawToJson(response).getString("token");

        return token;
    }
}
