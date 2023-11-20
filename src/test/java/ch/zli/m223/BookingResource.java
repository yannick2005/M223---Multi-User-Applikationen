package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class BookingResource {
    String adminJwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3psaS5leGFtcGxlLmNvbS9pc3N1ZXIiLCJ1cG4iOiJub2JvZHlAZXhhbXBsZS5jb20iLCJncm91cHMiOlsiY2guemxpLm0yMjMubW9kZWwuUm9sZUA0ZGJlMmYxMiJdLCJpYXQiOjE3MDA0OTQyMTcsImV4cCI6MTcwMDU4MDYxNywianRpIjoiZmZkYWM1ZjItY2QxZS00MDgyLWIzMzgtNzQxYjkxMDljYjYyIn0.sr-FcB-zPLiewOi0aNnfqYkpTy5nv0vK8OZPHDjgYl7cqiQTbxP7oZc3D2_ylhhulEdRgCCVh3eT74-Yvom0hFrknE76PWx7rI5K83XCWBAn8MLAqANo-rUfxgwdhN6HSMOcCUx3p1zpg1ImvcaPDGsJUcpGPUt7BFQJPEW0TaAcgaU4gLbgJLz4GdFCqAy0SjD9ku839x2etxP3VlBtz0ISpahA5XikhyLnAUYtOH884kjLTRrgmIryDiRUj2BIc8WsEkfQ8TyTPC7oP205w7Yeq1PLoLENoe_ccwP4xIpYVdaw4yTK7A_iCw-fMC8j90R1Hy7dNMMe0-QYjOeY_g ";
    String memberJwt = "";

    @Test
    public void testGetAllBookings() {
        given()
                .auth().oauth2(adminJwt)
                .when().get("/booking")
                .then()
                .statusCode(401);
    }

    @Test
    public void testGetAllBookingsAsAdmin() {
        given()
                .auth().oauth2(adminJwt)
                .when().get("/booking")
                .then()
                .statusCode(401);
    }

    @Test
    public void testGetAllBookingsAsMitglied() {
        given()
                .auth().oauth2(memberJwt)
                .when().get("/booking")
                .then()
                .statusCode(401);
    }

    @Test
    public void testGetAllBookingsAsAdminWithWrongRole() {
        given()
                .auth().oauth2(adminJwt)
                .when().get("/booking")
                .then()
                .statusCode(401);
    }

    @Test
    public void testGetBookingById() {
        given()
                .auth().oauth2(adminJwt)
                .when().get("/booking/1")
                .then()
                .statusCode(401);
    }

    @Test
    public void testGetBookingByIdAsAdmin() {
        given()
                .auth().oauth2(adminJwt)
                .when().get("/booking/1")
                .then()
                .statusCode(401);
    }

    @Test
    public void testGetBookingByIdAsMitglied() {
        given()
                .auth().oauth2(memberJwt)
                .when().get("/booking/1")
                .then()
                .statusCode(401);
    }

    @Test
    public void testGetBookingByIdInvalid() {
        given()
                .auth().oauth2(adminJwt)
                .when().get("/booking/999")
                .then()
                .statusCode(401);
    }

    @Test
    public void testDeleteBookingById() {
        given()
                .auth().oauth2(adminJwt)
                .when().delete("/booking/1")
                .then()
                .statusCode(401);
    }

    @Test
    public void delete() {
        given()
                .header("Authorization", "B" + memberJwt)
                .when().delete("/booking/1")
                .then()
                .assertThat()
                .statusCode(401);
    }

    @Test
    public void testDeleteBookingInvalid() {
        given()
                .auth().oauth2(adminJwt)
                .when().delete("/booking/999")
                .then()
                .statusCode(401);
    }

    @Test
    public void testUpdateBookingInvalid() {
        given()
                .auth().oauth2(adminJwt)
                .contentType(ContentType.JSON)
                .body("{\"id\": 999, \"name\": \"Test\", \"description\": \"Test\", \"start\": \"2021-06-01T00:00:00.000+00:00\", \"end\": \"2021-06-01T00:00:00.000+00:00\", \"room\": {\"id\": 1, \"name\": \"Test\", \"description\": \"Test\", \"capacity\": 1}}")
                .when().put("/booking/999")
                .then()
                .statusCode(401);
    }

}
