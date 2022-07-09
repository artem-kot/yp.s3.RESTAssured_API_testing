package org.example.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.example.pojo.Courier;
import io.restassured.response.Response;

public class QaScooterApiClient {
    public static final String baseURI = "http://qa-scooter.praktikum-services.ru";
    public static String createCourierApi = "/api/v1/courier";


    public Response createCourier(Courier courier){
        return RestAssured
                .with()
                .baseUri(baseURI)
                .accept(ContentType.JSON)
                .post(createCourierApi);
    }
}
