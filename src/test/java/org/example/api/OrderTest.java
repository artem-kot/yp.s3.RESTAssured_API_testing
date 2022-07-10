package org.example.api;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class OrderTest extends OrderTestSteps{
    @Test
    @DisplayName("Order Creation: order can be created")
    public void createOrderAllColorsTest(){
        createOrder().then().statusCode(201);
        cancelOrder().then().statusCode(200);
    }

    @Test
    @DisplayName("Order Creation: order can be created")
    public void createOrderNoColorsTest(){
        changeColorValue();
        createOrder().then().statusCode(201);
        cancelOrder().then().statusCode(200);
    }
}
