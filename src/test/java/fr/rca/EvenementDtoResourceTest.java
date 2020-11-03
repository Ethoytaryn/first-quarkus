package fr.rca;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class EvenementDtoResourceTest {

    @Inject
    EvenementService service;

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get(ResourceConstante.VERSION_1 + ResourceConstante.ENDPOINT_EVENEMENT)
          .then()
             .statusCode(200);
//                .body(is("[]"));
    }

}
