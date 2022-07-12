package org.example.pojo;

import java.util.List;

public class OrderBuilder {
    private String firstName;
    private String lastName;
    private String address;
    private int metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private List<String> color;

    public OrderBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public OrderBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public OrderBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public OrderBuilder withMetroStation(int metroStation) {
        this.metroStation = metroStation;
        return this;
    }

    public OrderBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public OrderBuilder withRentTime(int rentTime) {
        this.rentTime = rentTime;
        return this;
    }

    public OrderBuilder withDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public OrderBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public OrderBuilder withColor(List<String> color) {
        this.color = color;
        return this;
    }

    public Order build(){
        return new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
    }
}
