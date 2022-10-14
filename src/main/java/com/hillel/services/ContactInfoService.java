package com.hillel.services;

import com.hillel.models.ContactInfo;

import java.util.List;

public interface ContactInfoService {
    void addContact(ContactInfo contactInfo);
    int deleteContactById(int id);
    ContactInfo getContactById(int id);
    List<ContactInfo> getAllContacts();
    int updateFirstNameById(int id, String firstName);
    int updateLastNameById(int id, String lastName);
    int updateAgeById(int id, int age);
    int updatePhoneNumberById(int id, String phoneNumber);
    int updateAddressIdById(int id, int addressId);
}
