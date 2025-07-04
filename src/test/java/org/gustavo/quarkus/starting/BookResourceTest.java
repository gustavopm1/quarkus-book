package org.gustavo.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTest {

    @Test
    public void shouldGetAllBooks(){
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .when()
            .get("/api/books")
        .then()
            .statusCode(200)
            .body("size()", is(4));
    }

    @Test
    public void shouldCountAllBooks(){
        given()
                .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
                .when()
                .get("/api/books/count")
                .then()
                .statusCode(200)
                .body( is("4"));
    }

    @Test
    public void shouldGetABook(){
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
            .pathParam("id", 1)
        .when()
            .get("/api/books/{id}")
        .then()
            .statusCode(200)
                .body("title", is("Crime and Punishment"))
                .body("author", is("Fyodor Dostoevsky"))
                .body("yearOfPublication", is(1886))
                .body("genre", is("Literary Fiction"));
    }

}