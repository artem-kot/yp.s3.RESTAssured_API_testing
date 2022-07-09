package org.example.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.example.pojo.Courier;
import io.restassured.response.Response;

public class QaScooterApiClient {
    public static final String baseURI = "http://qa-scooter.praktikum-services.ru";
    public static String createCourierApi = "/api/v1/courier";
    public static String loginCourierApi = "/api/v1/courier/login";
    public static String removeCourierApi = "/api/v1/courier/";

    public String login = "JohnDoe";
    public String password = "123";
    public String firstName = "John";

    public Response createCourier(Courier courier){
        return RestAssured
                .with()
                .baseUri(baseURI)
                .accept(ContentType.JSON)
                .post(createCourierApi);
    }

    public Response loginCourier(Courier courier){
        return RestAssured
                .with()
                .baseUri(baseURI)
                .accept(ContentType.JSON)
                .and()
                .body(courier)
                .post(loginCourierApi);
    }

    public Response removeCourier(Courier courier){
        return RestAssured
                .with()
                .baseUri(baseURI)
                .accept(ContentType.JSON)
                .delete(removeCourierApi + courier.getId().toString());
    }
}
