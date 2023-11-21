package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class UserResource {
    String admimJwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3psaS5leGFtcGxlLmNvbS9pc3N1ZXIiLCJ1cG4iOiJzLnN2ZW5zb25AZXhhbXBsZS5jb20iLCJncm91cHMiOlsiY2guemxpLm0yMjMubW9kZWwuUm9sZUA1MDQ5NjNiMyJdLCJpYXQiOjE3MDA1NjMyNTIsImV4cCI6MTcwMDY0OTY1MiwianRpIjoiYzc5NGYxODUtMzA1OS00MjI5LTg3YjMtMWIxOGZkMDRjMjBiIn0.ecH7UIhSU5GtLYoeUBftaLArVeYKB4Awq9IP1TdCxqy7gEtU__gGvw6wX1uvgrhid54686mOO55YCWD-Gjw8Keyfa_3JG-oHTRLnBm3B8LQCK3NeOXXXYfk9wwhDgKHCwUcqGvo1LwsbmgdJ0JB4euXMNsy1-RlLMVUdnKGJAXVW5ZcCg7ieaylK7mrh2kXO0HZaVp6bLT0yqWEZ3z0LCHSsyFB_ocTH0JUabPIlIrpeSFGp8w21jIDhSeIZ651I-wIsIfJEfr_cAPDIpAbPHpJi5632wviKl_lNyWsNMiMnbheG6Qq14nvlgOHB-Z3r9b4niwwkqJWDM2qMLAOT8w";
    String memberJwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3psaS5leGFtcGxlLmNvbS9pc3N1ZXIiLCJ1cG4iOiJzLm1hbnVlbHNvbkBleGFtcGwuZWNvbSIsImdyb3VwcyI6WyJjaC56bGkubTIyMy5tb2RlbC5Sb2xlQDcwYjFkMTkxIl0sImlhdCI6MTcwMDU2MzMxOCwiZXhwIjoxNzAwNjQ5NzE4LCJqdGkiOiI5ODkwNTgyZC1hOTlmLTQ2NzktYWI5NS0yZWI5YWRlNjdhNTcifQ.K5W3Na4Qz1hd7FayDmmJvgykCIiEi3-mQz66Y3V-fXQuRjkVcvyKDbHO75WXasgMykMJHtkNb3y_S4qCuPSJBv6eeqn-K_rf9dHuJ50gk7kiO6asdCY5E0ePIUphWiNA3-AB8rYHRxCk9s5VaT9ruqtz9mt9DgoOlwTx3q4NlvCf2QpQZLm7kOUBJzz9qm440F3IoZhHRM7qTiAh4zNj8_p8zNPYX9KZQRPaQBXznDnEEDSREiCFVxoNZyTQdO6TOHmXcyi76U0n21_oHA6PTcs4tYPSXQn6_CwZwZL6K4fsXZMfQJ0sc-ghylJfkMPblXUS9SysLRU0K9fHsVNWMA";

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
