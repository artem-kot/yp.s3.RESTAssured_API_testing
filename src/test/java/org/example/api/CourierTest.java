package org.example.api;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class CourierTest extends CourierTestSteps {

    @Test
    @DisplayName("Courier Creation: courier can be created")
    public void createCourierTest(){
        createCourier().then().statusCode(201).assertThat().body("ok", equalTo(true));
        removeCourier().then().statusCode(200);
    }

    @Test
    @DisplayName("Courier Creation: courier record must be unique")
    public void createCourierErrorDuplicateTest(){
        createCourier().then().statusCode(201);
        createCourier().then().statusCode(409)
                .assertThat().body("message", equalTo(courierCreatedErrorDuplicate));
        removeCourier().then().statusCode(200);
    }

    @Test
    @DisplayName("Courier Creation: courier without mandatory field value cannot be created")
    public void createCourierErrorNotEnoughDataTest(){
        removeLogin();
        createCourier().then().statusCode(400)
                .assertThat().body("message", equalTo(courierCreatedErrorNotEnoughData));
    }

    @Test
    @DisplayName("Courier Login: login with incorrect credentials")
    public void loginCourierWrongCredentials(){
        loginCourier().then().statusCode(404)
                .assertThat().body("message", equalTo(courierLoginErrorWrongCredentials));
    }

}