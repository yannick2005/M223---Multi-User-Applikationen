package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class UserResource {
    String admimJwt = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3psaS5leGFtcGxlLmNvbS9pc3N1ZXIiLCJ1cG4iOiJzLnN2ZW5zb25AZXhhbXBsZS5jb20iLCJncm91cHMiOlsiYWRtaW4iXSwiaWF0IjoxNzAwNTczNDkwLCJleHAiOjE3MDA2NTk4OTAsImp0aSI6ImI0MjY1N2VlLTRhZTYtNDI1OC1iNDhmLTAxYjk1ZTJmYWNlMCJ9.IYIPlbEuk9Pd2A_yRpur5xf4AmVtk7k3-ffhOPaCbXY3ZeU5v7a51eGxxXAMrZ4frv-5W692XNsmeMCHOZeuiRFFH3W4DkbEFr6L2N8fYzFQy_kx9jdxbIo0pzrQqje5ObwcbBY-3VMaRNrd9RHN9JsVckCvCKDLyaMXHPFQIovwjh3mXnDswpZNMOzR6MWshDiCTWpIcBobjVctg7yNoj4FjFwKHIJKZ5X8QuAqkC6mU6qbTMFeQ83QrW40C9IsNzBk5EWj6Jdhx6z8MHhEVxWVW2lv4yr3rcLMRHw8d75aw-FSr8uPXOBebR2FvN5sC6scw-5J4ANaSoXU3AXRQA";
    String memberJwt = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3psaS5leGFtcGxlLmNvbS9pc3N1ZXIiLCJ1cG4iOiJtLm1hbnVlbHNvbkBleGFtcGxlLmNvbSIsImdyb3VwcyI6WyJtZW1iZXIiXSwiaWF0IjoxNzAwNTc1Nzc0LCJleHAiOjE3MDA2NjIxNzQsImp0aSI6IjM2NTYwZGI2LTJiYzctNGNhMC1hYjM0LWZjZTk2NDQ4NDUxZCJ9.JY6Gy_ohBsy3O5NoBa7XAEtTH7s42TjxoQyyCjM2ztHsnf5r5uI3AH7_kenNogK9toBoakmtrxoMjiXFK6Kfkimp35N2ntnMwz6_t4ZA_OuPEvNwYMZ6DlYS-cLOw_VunfVpavukPpcwR8E-83ipT5Aq4hIIEUzTs0kZVioR3_5fvD--M_b45ghATabrofK8siZObUEWKrz4eYrR77_f93vYtcspg6xfpb9h_RZpSbpJllthiP6Bzm2pzp3cbKf8Qu2qcOyih07wZCse1dnGTYD0Qw9hpxFAONC1Nb0wsfnPMsBYB-FJNgD-Qw6Vc7Cn7cQAAlyuu7vUhwxFsk_lFw";

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
