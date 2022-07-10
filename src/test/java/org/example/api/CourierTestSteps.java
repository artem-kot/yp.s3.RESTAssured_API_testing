package org.example.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.pojo.Courier;
import org.junit.Before;

public abstract class CourierTestSteps {
    public String courierLogin = "JohnDoe";
    public String courierPassword = "123";
    public String courierFirstName = "John";

    public String courierCreatedErrorNotEnoughData = "Недостаточно данных для создания учетной записи";
    public String courierCreatedErrorDuplicate = "Этот логин уже используется. Попробуйте другой.";
    public String courierLoginErrorWrongCredentials = "Учетная запись не найдена";

    private QaScooterApiClient client;
    private Courier courier;

    @Before
    public void setup(){
        courier = new Courier(courierLogin, courierPassword, courierFirstName);
        client = new QaScooterApiClient(courier);
    }

    @Step("Create courier")
    public Response createCourier(){
        return client.createCourier(courier);
    }

    @Step("Login courier")
    public Response loginCourier(){
        return client.loginCourier(courier);
    }

    @Step("Prepare json courier object without login")
    public void removeLogin(){
        courier.setLogin(null);
    }

    @Step("Remove courier")
    public Response removeCourier(){
        return client.removeCourier(courier);
    }
}
