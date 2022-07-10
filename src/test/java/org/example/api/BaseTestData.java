package org.example.api;

public interface BaseTestData {
    public String courierLogin = "JohnDoe";
    public String courierPassword = "123";
    public String courierFirstName = "John";

    public String courierCreatedErrorNotEnoughData = "Недостаточно данных для создания учетной записи";
    public String courierCreatedErrorDuplicate = "Этот логин уже используется. Попробуйте другой.";
    public String courierLoginErrorWrongCredentials = "Учетная запись не найдена";
    public String courierLoginErrorNotEnoughData = "Недостаточно данных для входа";
}
