package org.example.api;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.pojo.Order;

public class OrderApiClient{
    public static final String url = "http://qa-scooter.praktikum-services.ru";
    public static String mainOrderApi = "/api/v1/orders";
    public static String cancelOrderApi = "/api/v1/orders/cancel";

    private final Filter requestFilter = new RequestLoggingFilter();
    private final Filter responseFiler = new ResponseLoggingFilter();
    private static Integer track;

    public OrderApiClient(Order order){
    }

    public Response createOrder(Order order){
        Response response = RestAssured
                .with()
                .filters(requestFilter, responseFiler)
                .baseUri(url)
                .contentType(ContentType.JSON)
                .and()
                .body(order)
                .post(mainOrderApi);
        track = response.then().extract().body().path("track");
        return response;
    }

    public Response cancelOrder(Order order){
        return RestAssured
                .with()
                .filters(requestFilter, responseFiler)
                .baseUri(url)
                .contentType(ContentType.JSON)
                .and()
                .queryParam("track", track)
                .body("{\"track\": " + track + "}")
                .put(cancelOrderApi);
    }

    public Response getOrders(){
        return RestAssured
                .with()
                .filters(requestFilter, responseFiler)
                .baseUri(url)
                .get(mainOrderApi);
    }
}
