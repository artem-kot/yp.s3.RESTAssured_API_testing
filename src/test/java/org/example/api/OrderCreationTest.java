package org.example.api;

import io.qameta.allure.junit4.DisplayName;
import org.example.api.steps.OrderTestSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class OrderCreationTest extends OrderTestSteps {

    private final List<String> colors;

    public OrderCreationTest(List<String> colors) {
        this.colors = colors;
    }

    @Parameterized.Parameters
    public static Object[] getColorsData(){
        return new Object[][]{
                {Arrays.asList("BLACK","GREY")},
                {Arrays.asList("BLACK")},
                {Arrays.asList("GREY")},
                {null},
        };
    }

    @Test
    @DisplayName("Order Creation: order can be created with different color parameters")
    public void createOrderTest(){
        changeColorValue(colors);
        createOrder().then().statusCode(201).assertThat().body("track", notNullValue());
    }
}
