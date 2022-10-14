package com.hillel;

import com.hillel.controllers.AddressController;
import com.hillel.controllers.ContactInfoController;
import com.hillel.db_connectors.DatabaseConnector;
import com.hillel.db_connectors.H2DatabaseConnector;
import com.hillel.repositories.AddressRepository;
import com.hillel.repositories.ContactInfoRepository;
import com.hillel.services.AddressServiceImpl;
import com.hillel.services.ContactInfoService;
import com.hillel.services.ContactInfoServiceImpl;

public class PhoneBook {

    public static void main(String[] args) {
        DatabaseConnector databaseConnector = new H2DatabaseConnector();
        com.hillel.services.AddressService addressService = new AddressServiceImpl(
                new AddressRepository(databaseConnector));
        AddressController addressController = new AddressController(addressService);

        ContactInfoService contactInfoService = new ContactInfoServiceImpl(
                new ContactInfoRepository(databaseConnector, addressService));
        ContactInfoController contactInfoController = new ContactInfoController(contactInfoService);


        System.out.println(addressController.getAllAddresses());
//        System.out.println(addressController.getAddressById());
//        addressController.addAddress();
//        addressController.deleteAddressById();
//        addressController.updateCountryById();
        System.out.println(addressController.getAllAddresses());

        System.out.println(contactInfoController.getAllContacts());
//        contactInfoController.addContact();
//        contactInfoController.getContactById();
//        contactInfoController.deleteContactById();
//        contactInfoController.updateFirstNameById();
//        contactInfoController.updateAddressIdById();
//        System.out.println(contactInfoController.getContactById());
        System.out.println(contactInfoController.getAllContacts());
    }
}
