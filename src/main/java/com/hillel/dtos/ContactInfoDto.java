package com.hillel.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactInfoDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private String phoneNumber;
    private Integer addressId;
}
