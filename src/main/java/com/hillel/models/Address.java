package com.hillel.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private int id;
    private String country;
    private String city;
    private String street;
    private int houseNumber;
    private int apartmentNumber;

    @Override
    public String toString() {
        return "[Address ID: " + id + ", Country: " + country +
                ", City: " + city + ", Street: " + street +
                ", House Number: " + houseNumber +
                ", Apartment Number: " + apartmentNumber + "]";
    }
}
