package com.hillel;

import com.hillel.db_connectors.DatabaseConnector;
import com.hillel.db_connectors.H2DatabaseConnector;
import com.hillel.repositories.AddressRepository;
import com.hillel.repositories.ContactInfoRepository;
import com.hillel.services.AddressService;
import com.hillel.services.AddressServiceImpl;
import com.hillel.services.ContactInfoService;
import com.hillel.services.ContactInfoServiceImpl;

public class PhoneBook {

    public static void main(String[] args) {
        DatabaseConnector databaseConnector = new H2DatabaseConnector();
        AddressService addressService = new AddressServiceImpl(new AddressRepository(databaseConnector));
        ContactInfoService contactInfoService = new ContactInfoServiceImpl(new ContactInfoRepository(databaseConnector,
                new AddressRepository(databaseConnector)));

        System.out.println(addressService.getAllAddresses());
//        addressService.addAddress();
//        addressService.updateCountryById();
//        addressService.updateCityById();
        System.out.println(addressService.getAddressById());
//        addressService.updateHouseNumberById();
//        System.out.println(addressService.getAddressById());
//
        System.out.println(contactInfoService.getAllContacts());
//        contactInfoService.updateAgeById();
        System.out.println(contactInfoService.getContactById());
//        contactInfoService.updatePhoneNumberById();
//        System.out.println(contactInfoService.getContactById());
//        contactInfoService.addContact();
//        System.out.println(contactInfoService.getAllContacts());
//        System.out.println(contactInfoService.getContactById());
//        contactInfoService.deleteContactById();

    }
}
