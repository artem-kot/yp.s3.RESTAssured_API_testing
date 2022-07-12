package org.example.api;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.example.pojo.Courier;
import io.restassured.response.Response;

public class CourierApiClient {
    public static final String url = "http://qa-scooter.praktikum-services.ru";
    public static String createCourierApi = "/api/v1/courier";
    public static String loginCourierApi = "/api/v1/courier/login";
    public static String removeCourierApi = "/api/v1/courier/";

    private final Filter requestFilter = new RequestLoggingFilter();
    private final Filter responseFiler = new ResponseLoggingFilter();

    private final Courier courier;

    public CourierApiClient(Courier courier) {
        this.courier = courier;
    }

    public Response createCourier(Courier courier){
        return RestAssured
                .with()
                .filters(requestFilter, responseFiler)
                .baseUri(url)
                .contentType(ContentType.JSON)
                .and()
                .body(courier)
                .post(createCourierApi);
    }

    public Response loginCourier(Courier courier){
        return RestAssured
                .with()
                .filters(requestFilter, responseFiler)
                .baseUri(url)
                .contentType(ContentType.JSON)
                .and()
                .body(courier)
                .post(loginCourierApi);
    }

    public String getCreatedCourierId(){
        Integer id = loginCourier(courier)
                .then()
                .extract()
                .body()
                .path("id");
        return id.toString();
    }

    public Response removeCourier(Courier courier){
        String id = getCreatedCourierId();
        return RestAssured
                .with()
                .filters(requestFilter, responseFiler)
                .baseUri(url)
                .contentType(ContentType.JSON)
                .and()
                .body("{\"id\": " + id + "}")
                .delete(removeCourierApi + id);
    }
}
