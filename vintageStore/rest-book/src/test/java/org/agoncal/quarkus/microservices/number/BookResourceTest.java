package org.agoncal.quarkus.microservices.number;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void testCreateBook(){
        given()
            .formParam("title", "Understanding quarkus")
            .formParam("author", "Nassim")
            .formParam("year", 2020)
            .formParam("genre", "it")
        .when()
            .post("/api/books")
        .then()
            .statusCode(201)
            .body("isbn13", startsWith("13-"))
            .body("title", is("Understanding quarkus"))
            .body("author", is("Nassim"))
            .body("year", is(2020))
            .body("creation", startsWith("20"))
            ;

    }

}