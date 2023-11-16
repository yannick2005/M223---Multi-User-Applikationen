package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class UserResource {
    String admimJwt = "";
    String memberJwt = "";

    @Test
    public void TestgetAllUsersValid() {
        given()
                .auth().oauth2(admimJwt)
                .when().get("/user/all")
                .then()
                .statusCode(401);
    }

    @Test
    public void TestgetAllUsersNoToken() {
        given()
                .when().get("/user/all")
                .then()
                .statusCode(401);
    }

    @Test
    public void TestgetUserInvalid() {
        given()
                .auth().oauth2(memberJwt)
                .when().get("/user/1")
                .then()
                .statusCode(401);
    }

    @Test
    public void TestDeleteUserByIdNoToken() {
        given()
                .when().delete("/user/1")
                .then()
                .statusCode(401);
    }

    @Test
    public void TestUpdateUserValid() {
        given()
                .auth().oauth2(admimJwt)
                .contentType(ContentType.JSON)
                .body("{\"firstname\":\"abdu\",\"lastname\":\"ahmed\", \"age\":\"11\",\"description\":\"ahmed\", \"email\":\"abdullahde197@gmail.com\", \"password\":\"Nobody\"}")
                .when().put("/user/1")
                .then()
                .statusCode(401);

    }

    @Test
    public void TestUpdateUserInvalid() {
        given()
                .auth().oauth2(memberJwt)
                .contentType(ContentType.JSON)
                .body("{\"firstname\":\"yannick\",\"lastname\":\"Schönhaar\", \"age\":\"11\",\"description\":\"Nobody\", \"email\":\"y.schoenhaar@example.com\", \"password\":\"Nobody\"}")
                .when().put("/user/1")
                .then()
                .statusCode(401);
    }

    @Test
    public void TestUpdateUserNoToken() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"firstname\":\"yannick\",\"lastname\":\"Schönhaar\", \"age\":\"11\",\"description\":\"Nobody\", \"email\":\"y.schoenhaar@example.com\", \"password\":\"AK19997\"}")
                .when().put("/user/1")
                .then()
                .statusCode(401);
    }
}
