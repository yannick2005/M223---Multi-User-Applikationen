package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class RoleResource {

  @Test
  public void testfindById() {
    given()
        .when().get("/role/1")
        .then()
        .statusCode(401);
  }

  @Test
  public void testFindByIdInvalid() {
    given()
        .when().get("/role/999")
        .then()
        .statusCode(401);
  }
}
