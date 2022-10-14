package com.hillel.services;

import com.hillel.models.ContactInfo;
import com.hillel.repositories.ContactInfoRepository;

import java.util.List;

public class ContactInfoServiceImpl implements ContactInfoService {
    private final ContactInfoRepository contactInfoRepository;

    public ContactInfoServiceImpl(ContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
    }

    @Override
    public void addContact(ContactInfo contactInfo) {
        contactInfoRepository.addContact(contactInfo);
    }

    @Override
    public int deleteContactById(int id) {
        return contactInfoRepository.deleteContactById(id);
    }

    @Override
    public ContactInfo getContactById(int id) {
        if (contactInfoRepository.getContactById(id).getId() != 0) {
            return contactInfoRepository.getContactById(id);
        } else {
            throw new IllegalArgumentException("Contact with ID #" + id + " is not found");
        }
    }

    @Override
    public List<ContactInfo> getAllContacts() {
        return contactInfoRepository.getAllContacts();
    }

    @Override
    public int updateFirstNameById(int id, String firstName) {
        return contactInfoRepository.updateFirstNameById(id, firstName);
    }

    @Override
    public int updateLastNameById(int id, String lastName) {
        return contactInfoRepository.updateLastNameById(id, lastName);
    }

    @Override
    public int updateAgeById(int id, int age) {
        return contactInfoRepository.updateAgeById(id, age);
    }

    @Override
    public int updatePhoneNumberById(int id, String phoneNumber) {
        return contactInfoRepository.updatePhoneNumberById(id, phoneNumber);
    }

    @Override
    public int updateAddressIdById(int id, int addressId) {
        return contactInfoRepository.updateAddressIdById(id, addressId);
    }
}
