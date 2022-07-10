package org.example.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.pojo.Courier;
import org.junit.Before;
import org.junit.Test;

public class CourierCreationTest extends BaseTestData{

    private QaScooterApiClient client;
    private Courier courier;

    @Before
    public void setup(){
        courier = new Courier(courierLogin, courierPassword, courierFirstName);
        client = new QaScooterApiClient(courier);
    }


    @Test
    public void createCourierTest(){
        createCourier().then().statusCode(201);
        removeCourier().then().statusCode(200);
    }

    @Step("Create courier")
    public Response createCourier(){
        return client.createCourier(courier);
    }
    @Step("Clean test data after the test")
    public Response removeCourier(){
        return client.removeCourier(courier);
    }
}