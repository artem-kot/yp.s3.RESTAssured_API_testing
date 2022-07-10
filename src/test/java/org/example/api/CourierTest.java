package org.example.api;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

//@RunWith(Parameterized.class)
public class CourierTest extends CourierTestSteps {

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

    @Test
    @DisplayName("Courier Login: successful login returns id")
    public void loginCourierTest(){
        createCourier().then().statusCode(201);
        loginCourier().then().statusCode(200)
                .assertThat().body("id", notNullValue());
        removeCourier();
    }

    @Test
    @DisplayName("Courier Login: login with incorrect credentials")
    public void loginCourierWrongCredentials(){
        loginCourier().then().statusCode(404)
                .assertThat().body("message", equalTo(courierLoginErrorWrongCredentials));
    }

    @Test
    @DisplayName("Courier Login: error, mandatory fields must be specified")
    public void loginCourierErrorNotEnoughDataTest(){
        createCourier().then().statusCode(201);
        changeCourierLoginValue();
        loginCourier().then().statusCode(400)
                .assertThat().body("message", equalTo(courierLoginErrorNotEnoughData));
        changeCourierLoginValue(courierLogin);
        removeCourier().then().statusCode(200);
    }

}