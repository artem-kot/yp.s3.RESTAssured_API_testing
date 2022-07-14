package org.example.api.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.api.BaseTestData;
import org.example.api.OrderApiClient;
import org.example.pojo.Order;
import org.example.pojo.OrderBuilder;
import org.junit.After;
import org.junit.Before;
import java.util.List;

public class OrderTestSteps implements BaseTestData {
    private OrderApiClient client;
    private Order order;

    @Before
    public void setup(){
        order = new OrderBuilder()
                .withFirstName(orderFirstName)
                .withLastName(orderLastName)
                .withAddress(orderAddress)
                .withMetroStation(orderMetroStation)
                .withPhone(orderPhone)
                .withRentTime(orderRentTime)
                .withDeliveryDate(orderDeliveryDate)
                .withComment(orderComment)
                .withColor(orderColor)
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

    @After
    public void teardown(){
        cancelOrder();
    }
}
