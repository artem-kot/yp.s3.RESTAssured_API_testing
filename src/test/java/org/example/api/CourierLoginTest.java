package org.example.api;

import io.qameta.allure.junit4.DisplayName;
import org.example.api.steps.CourierTestSteps;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CourierLoginTest extends CourierTestSteps {

    @Test
    @DisplayName("Courier Login: successful login returns id")
    public void loginCourierTest(){
        createCourier().then().statusCode(201);
        loginCourier().then().statusCode(200)
                .assertThat().body("id", notNullValue());
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
    }
}