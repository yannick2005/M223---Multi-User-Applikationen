package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class BookingResource {
    String adminJwt = "";
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
