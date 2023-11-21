package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class AuthentificationResource {

    @Test
    public void testPostLogin() {
        given()
            .contentType(ContentType.JSON)
            .when()
                .post("/auth/login?email=s.svenson%40example.com&password=Sui")
            .then()
            .statusCode(500);
    }

    @Test
    public void testPostLoginInvalid() {
        given()
            .contentType(ContentType.JSON)
            .when()
                .post("/auth/login?email=M.Michersen@bluewin.com&password=test123")
            .then()
            .statusCode(500);
    }

    @Test
    public void testPostRegisterInvalid() {
        given()
            .contentType(ContentType.JSON)
            .when()
                .post("/register?email=and%40bat.com&password=and")
            .then()
            .statusCode(404);
    }

    @Test
    public void testPostRegisterValid() {
        given()

        .body("{\"firstname\":\"yannick\",\"lastname\":\"Schönhaar\", \"age\":\"18\",\"description\":\"Nobody\", \"email\":\"y.schoenhaar@example.com\", \"password\":\"Nobody\", \"gender\": \"Male\"},")

        .contentType(ContentType.JSON)
        .when()
            .post("/auth/register")
            .then()
            .statusCode(400);
    }
    @Test
    public void testGetLogout() {
        given()
            .contentType(ContentType.JSON)
            .when()
                .get("/auth/logout")
            .then()
            .statusCode(405);
    }
}
