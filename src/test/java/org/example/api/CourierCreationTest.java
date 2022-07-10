package org.example.api;

import io.qameta.allure.junit4.DisplayName;
import org.example.api.steps.CourierTestSteps;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;

public class CourierCreationTest extends CourierTestSteps {

    @Test
    @DisplayName("Courier Creation: courier can be created")
    public void createCourierTest(){
        createCourier().then().statusCode(201).assertThat().body("ok", equalTo(true));
        removeCourier().then().statusCode(200);
    }

    @Test
    @DisplayName("Courier Creation: error, courier record must be unique")
    public void createCourierErrorDuplicateTest(){
        createCourier().then().statusCode(201);
        createCourier().then().statusCode(409)
                .assertThat().body("message", equalTo(courierCreatedErrorDuplicate));
        removeCourier().then().statusCode(200);
    }

    @Test
    @DisplayName("Courier Creation: error, mandatory fields must be specified")
    public void createCourierErrorNotEnoughDataTest(){
        changeCourierLoginValue();
        createCourier().then().statusCode(400)
                .assertThat().body("message", equalTo(courierCreatedErrorNotEnoughData));
    }
}