package client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;

import static io.restassured.RestAssured.given;

public class UserClient {

    private static final String BASE_URL = "https://stellarburgers.education-services.ru/";

    public UserClient() {
        RestAssured.baseURI = BASE_URL;
    }

    // Регистрация пользователя
    public Response create(User user) {
        return given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/api/auth/register");
    }

    // Вход пользователя (этого метода не хватало!)
    public Response login(User user) {
        return given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/api/auth/login");
    }

    // Удаление пользователя
    public Response delete(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .when()
                .delete("/api/auth/user");
    }
}