package com.hillel.services;

import com.hillel.models.Address;
import com.hillel.repositories.AddressRepository;

import java.util.List;

public class AddressServiceImpl implements com.hillel.services.AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void addAddress(Address address) {
        addressRepository.addAddress(address);
    }

    @Override
    public void deleteAddressById(int id) {
        addressRepository.deleteAddressById(id);
    }

    @Override
    public Address getAddressById(int id) {
        if (addressRepository.getAddressById(id) != null) {
            return addressRepository.getAddressById(id);
        } else {
            throw new IllegalArgumentException("Address with ID #" + id + " is not found");
        }
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.getAllAddresses();
    }

    @Override
    public int updateCountryById(int id, String country) {
        return addressRepository.updateCountryById(id, country);
    }

    @Override
    public int updateCityById(int id, String city) {
        return addressRepository.updateCityById(id, city);
    }

    @Override
    public int updateStreetById(int id, String street) {
        return addressRepository.updateStreetById(id, street);
    }

    @Override
    public int updateHouseNumberById(int id, int houseNumber) {
        return addressRepository.updateHouseNumberById(id, houseNumber);
    }

    @Override
    public int updateApartmentNumberById(int id, int apartmentNumber) {
        return addressRepository.updateApartmentNumberById(id, apartmentNumber);
    }
}
