package org.example.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.pojo.Courier;
import org.junit.Before;
import org.junit.Test;

public class CourierCreationTest {

    private QaScooterApiClient client;

    @Before
    public void setup(){
        client = new QaScooterApiClient();
    }

    @Test
    public void createCourierTest(){
        Courier courier = new Courier(client.login, client.password, client.firstName);
        client.createCourier(courier)
                .then().statusCode(201);
    }

    @Step("Create courier")
    public void createCourier(){
        client.createCourier(new Courier(client.login, client.password, client.firstName));
    }
    @Step("Clean test data after the test")
    public void removeCourier(){

    }
}