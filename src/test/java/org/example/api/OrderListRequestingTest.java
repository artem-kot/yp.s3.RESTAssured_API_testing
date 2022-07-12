package org.example.api;

import io.qameta.allure.junit4.DisplayName;
import org.example.api.steps.OrderTestSteps;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.notNullValue;

public class OrderListRequestingTest extends OrderTestSteps {

    @Test
    @DisplayName("Order List: requesting a list of existing orders")
    public void createOrderTest(){
        getOrders().then().statusCode(200).assertThat().body("orders[0].track", notNullValue());
    }
}
