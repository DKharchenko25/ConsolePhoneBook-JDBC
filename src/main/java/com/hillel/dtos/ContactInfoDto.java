package com.hillel.dtos;

import com.hillel.models.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactInfoDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String phoneNumber;
    private Integer addressId;
    private Address address;

    @Override
    public String toString() {
        return "[ContactInfo " +
                "ID: " + id +
                ", First Name: " + firstName +
                ", Last Name: " + lastName +
                ", Age: " + age +
                ", Phone Number: " + phoneNumber + "]";
    }
}
