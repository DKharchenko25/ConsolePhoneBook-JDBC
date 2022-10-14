package com.hillel.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private Integer id;
    private String country;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer apartmentNumber;

    @Override
    public String toString() {
        return "[Address ID: " + id + ", Country: " + country +
                ", City: " + city + ", Street: " + street +
                ", House Number: " + houseNumber +
                ", Apartment Number: " + apartmentNumber + "]";
    }
}
