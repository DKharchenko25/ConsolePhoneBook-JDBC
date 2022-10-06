package com.hillel.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private String country;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer apartmentNumber;
}
