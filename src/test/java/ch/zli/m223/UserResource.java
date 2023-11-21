package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class UserResource {
    String admimJwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3psaS5leGFtcGxlLmNvbS9pc3N1ZXIiLCJ1cG4iOiJub2JvZHlAZXhhbXBsZS5jb20iLCJncm91cHMiOlsiY2guemxpLm0yMjMubW9kZWwuUm9sZUA0ZGJlMmYxMiJdLCJpYXQiOjE3MDA0OTQyMTcsImV4cCI6MTcwMDU4MDYxNywianRpIjoiZmZkYWM1ZjItY2QxZS00MDgyLWIzMzgtNzQxYjkxMDljYjYyIn0.sr-FcB-zPLiewOi0aNnfqYkpTy5nv0vK8OZPHDjgYl7cqiQTbxP7oZc3D2_ylhhulEdRgCCVh3eT74-Yvom0hFrknE76PWx7rI5K83XCWBAn8MLAqANo-rUfxgwdhN6HSMOcCUx3p1zpg1ImvcaPDGsJUcpGPUt7BFQJPEW0TaAcgaU4gLbgJLz4GdFCqAy0SjD9ku839x2etxP3VlBtz0ISpahA5XikhyLnAUYtOH884kjLTRrgmIryDiRUj2BIc8WsEkfQ8TyTPC7oP205w7Yeq1PLoLENoe_ccwP4xIpYVdaw4yTK7A_iCw-fMC8j90R1Hy7dNMMe0-QYjOeY_g";
    String memberJwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3psaS5leGFtcGxlLmNvbS9pc3N1ZXIiLCJ1cG4iOiJzLnVuaW1wb3J0YW50QHMuY29tIiwiZ3JvdXBzIjpbImNoLnpsaS5tMjIzLm1vZGVsLlJvbGVAMjBiOGUyMTIiXSwiaWF0IjoxNzAwNTUxMzExLCJleHAiOjE3MDA2Mzc3MTEsImp0aSI6IjA4NzNlM2ZlLTU3NWMtNDY2NC05Y2FkLTdjMmQwZWQ2N2YwZiJ9.F4CWS1o_JAk5FdkykF96iFqr2zKZGfAFZwZPOe89HxIb4_YeBAcc9Jy8ToJ3hRiwEktuG6HQvERYFxZY7qnRuUGO06bcnyEbBs8mPwHQbqlHMXbJn8ea957gyoJU3Lu-Y7lAREtA5QithvILgBHRmsUrcXOKJE221UBMAVNqcpD8bQ1CMZyFy2UYlJyP6dZhvHLezZI4jV7rRr84vtnrpkSb7-3ssso_ugy1wYHuifaHJc5kc_qft2-dTi_xxJQfiFlLfQ-ztBsMeRvjzwwetGnCS_dxruYFZtpG9d6PVzL9fSYDas15pRykoXK06c6EHJo_zDAEodN3lCoJlyqyyA";

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
                .body("{\"firstname\":\"No\",\"lastname\":\"nobody\", \"age\":\"11\",\"description\":\"nobody\", \"email\":\"nobody@gmail.com\", \"password\":\"Nobody\"}")
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
