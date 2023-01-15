package org.agoncal.quarkus.microservices.number;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
public class NumberResourceTest {

    @Test
    public void testGenerateIsbnNumbers() {
        given()
          .when().get("/api/numbers")
          .then()
             .statusCode(201)
             .body("isbn13", startsWith("13-"))
             .body("isbn10", startsWith("10-"))
             ;

    }

}