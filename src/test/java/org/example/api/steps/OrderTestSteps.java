package org.example.api.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.api.OrderApiClient;
import org.example.pojo.Order;
import org.example.pojo.OrderBuilder;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

public class OrderTestSteps {
    private OrderApiClient client;
    private Order order;

    @Before
    public void setup(){
        order = new OrderBuilder()
                .withFirstName("Jane")
                .withLastName("Doe")
                .withAddress("The Middle of Nowhere, -0 apt.")
                .withMetroStation(7)
                .withPhone("555-12-12")
                .withRentTime(5)
                .withDeliveryDate("2022-09-01")
                .withComment("♥")
                .withColor(Arrays.asList("BLACK", "GREY"))
                .build();
        client = new OrderApiClient(order);
    }

    @Step("Create order")
    public Response createOrder(){
        return client.createOrder(order);
    }

    @Step("Cancel order")
    public Response cancelOrder(){
        return client.cancelOrder(order);
    }

    @Step("Modify order colors")
    public void changeColorValue(List<String> colors){
        order.setColor(colors);
    }

    @Step("Modify order colors")
    public void changeColorValue(){
        order.setColor(null);
    }

    @Step("Get list of all orders")
    public Response getOrders(){
        return client.getOrders();
    }
}
