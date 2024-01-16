package com.restful.booker.testsuite;

import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserDeleteBookingTest extends TestBase {
    @Test
    public void VerifyBookingDeleteSuccessfully() {
        Response response = given().log().all()
                .header("Content-Type", "application/json")
//                .header("cookie", "token=b19a42e1ab35137")
                .auth().preemptive().basic("admin", "password123")
              .pathParam("id", 29)
                .when()
                .delete("/booking/{id}");
        response.prettyPrint();
        response.then().statusCode(201);


               given()
               .header("cookie", "token=b19a42e1ab35137")
               .pathParam("id",29)
                .when()
                .get("/booking/{id}")
                .then()
                .statusCode(404);

    }}

