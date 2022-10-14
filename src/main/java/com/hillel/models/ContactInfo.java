package com.hillel.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactInfo {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private Address address;
    private int addressId;

    @Override
    public String toString() {
        return "[ContactInfo " +
                "ID: " + id  +
                ", First Name: " + firstName +
                ", Last Name: " + lastName +
                ", Age: " + age +
                ", Phone Number: " + phoneNumber + "]";
    }
}
