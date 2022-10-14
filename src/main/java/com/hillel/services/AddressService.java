package com.hillel.services;

import com.hillel.dtos.AddressDto;
import com.hillel.models.Address;

import java.util.List;

public interface AddressService {

    void addAddress(Address address);
    void deleteAddressById(int id);
    Address getAddressById(int id);
    List<Address> getAllAddresses();
    int updateCountryById(int id, String country);
    int updateCityById(int id, String city);
    int updateStreetById(int id, String street);
    int updateHouseNumberById(int id, int houseNumber);
    int updateApartmentNumberById(int id, int apartmentNumber);

}
