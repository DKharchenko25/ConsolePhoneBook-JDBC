package com.hillel.services;

import com.hillel.dtos.AddressDto;
import com.hillel.models.Address;

import java.util.List;

public interface AddressService {

    void addAddress();
    void deleteAddressById();
    Address getAddressById();
    List<Address> getAllAddresses();
    void updateCountryById();
    void updateCityById();
    void updateStreetById();
    void updateHouseNumberById();
    void updateApartmentNumberById();

}
