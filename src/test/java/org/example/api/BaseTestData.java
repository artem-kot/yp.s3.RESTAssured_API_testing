package org.example.api;

import java.util.Arrays;
import java.util.List;

public interface BaseTestData {
    String courierLogin = "JohnDoe";
    String courierPassword = "123";
    String courierFirstName = "John";

    String orderFirstName = "Jane";
    String orderLastName = "Doe";
    String orderAddress = "The Middle of Nowhere, -0 apt.";
    int orderMetroStation = 7;
    String orderPhone = "555-12-12";
    int orderRentTime = 5;
    String orderDeliveryDate = "2022-09-01";
    String orderComment = "♥";
    List<String> orderColor = Arrays.asList("BLACK", "GREY");

    String courierCreatedErrorNotEnoughData = "Недостаточно данных для создания учетной записи";
    String courierCreatedErrorDuplicate = "Этот логин уже используется. Попробуйте другой.";
    String courierLoginErrorWrongCredentials = "Учетная запись не найдена";
    String courierLoginErrorNotEnoughData = "Недостаточно данных для входа";
}
