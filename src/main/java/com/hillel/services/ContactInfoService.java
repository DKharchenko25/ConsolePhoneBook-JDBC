package com.hillel.services;

public interface ContactInfoService {
    void addContact();
    void deleteContactById();
    String getContactById();
    String getAllContacts();
    void updateFirstNameById();
    void updateLastNameById();
    void updateAgeById();
    void updatePhoneNumberById();
    void updateAddressIdById();
}
