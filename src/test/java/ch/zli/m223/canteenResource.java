package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class CanteenResource {
    String adminJwt = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3psaS5leGFtcGxlLmNvbS9pc3N1ZXIiLCJ1cG4iOiJzLnN2ZW5zb25AZXhhbXBsZS5jb20iLCJncm91cHMiOlsiYWRtaW4iXSwiaWF0IjoxNzAwNTczNDkwLCJleHAiOjE3MDA2NTk4OTAsImp0aSI6ImI0MjY1N2VlLTRhZTYtNDI1OC1iNDhmLTAxYjk1ZTJmYWNlMCJ9.IYIPlbEuk9Pd2A_yRpur5xf4AmVtk7k3-ffhOPaCbXY3ZeU5v7a51eGxxXAMrZ4frv-5W692XNsmeMCHOZeuiRFFH3W4DkbEFr6L2N8fYzFQy_kx9jdxbIo0pzrQqje5ObwcbBY-3VMaRNrd9RHN9JsVckCvCKDLyaMXHPFQIovwjh3mXnDswpZNMOzR6MWshDiCTWpIcBobjVctg7yNoj4FjFwKHIJKZ5X8QuAqkC6mU6qbTMFeQ83QrW40C9IsNzBk5EWj6Jdhx6z8MHhEVxWVW2lv4yr3rcLMRHw8d75aw-FSr8uPXOBebR2FvN5sC6scw-5J4ANaSoXU3AXRQA";
    String memberJwt = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3psaS5leGFtcGxlLmNvbS9pc3N1ZXIiLCJ1cG4iOiJtLm1hbnVlbHNvbkBleGFtcGxlLmNvbSIsImdyb3VwcyI6WyJtZW1iZXIiXSwiaWF0IjoxNzAwNTc1Nzc0LCJleHAiOjE3MDA2NjIxNzQsImp0aSI6IjM2NTYwZGI2LTJiYzctNGNhMC1hYjM0LWZjZTk2NDQ4NDUxZCJ9.JY6Gy_ohBsy3O5NoBa7XAEtTH7s42TjxoQyyCjM2ztHsnf5r5uI3AH7_kenNogK9toBoakmtrxoMjiXFK6Kfkimp35N2ntnMwz6_t4ZA_OuPEvNwYMZ6DlYS-cLOw_VunfVpavukPpcwR8E-83ipT5Aq4hIIEUzTs0kZVioR3_5fvD--M_b45ghATabrofK8siZObUEWKrz4eYrR77_f93vYtcspg6xfpb9h_RZpSbpJllthiP6Bzm2pzp3cbKf8Qu2qcOyih07wZCse1dnGTYD0Qw9hpxFAONC1Nb0wsfnPMsBYB-FJNgD-Qw6Vc7Cn7cQAAlyuu7vUhwxFsk_lFw";

    @Test
    public void testfindById() {
        given()
                .when().get("/products/1")
                .then()
                .statusCode(404);
    }

    @Test
    public void testFindByIdInvalid() {
        given()
                .when().get("/products/999")
                .then()
                .statusCode(404);
    }
}
