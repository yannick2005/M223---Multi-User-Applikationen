package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class RoomResource {

    @Test
    public void testGetAllRooms() {
        given()
            .when().get("/room")
            .then()
                .statusCode(404);
    }

    @Test
    public void testGetRoom() {
        given()
            .when().get("/room/1")
            .then()
                .statusCode(200);
    }

    @Test
    public void testGetRoomInvlaid() {
        given()
            .when().get("/room/2")
            .then()
                .statusCode(404);
    }

    @Test
    public void testCreateRoomInvlid() {
        given()
            .contentType(ContentType.JSON)
            .body("{\"name\":\"TestRoom\",\"description\":\"TestRoom\",\"capacity\":10}")
            .when().post("/room")
            .then()
                .statusCode(404);
    }
    
}