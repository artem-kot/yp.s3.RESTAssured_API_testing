package org.example.api.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.api.BaseTestData;
import org.example.api.CourierApiClient;
import org.example.pojo.Courier;
import org.junit.Before;

public class CourierTestSteps implements BaseTestData {

    private CourierApiClient client;
    private Courier courier;

    @Before
    public void setup(){
        courier = new Courier(courierLogin, courierPassword, courierFirstName);
        client = new CourierApiClient(courier);
    }

    @Step("Create courier")
    public Response createCourier(){
        return client.createCourier(courier);
    }

    @Step("Login courier")
    public Response loginCourier(){
        return client.loginCourier(courier);
    }

    @Step("Modify json courier login")
    public void changeCourierLoginValue(){
        courier.setLogin(null);
    }

    @Step("Modify json courier login")
    public void changeCourierLoginValue(String newLogin){
        courier.setLogin(newLogin);
    }

    @Step("Remove courier")
    public Response removeCourier(){
        return client.removeCourier(courier);
    }
}
