package com.hillel.converters;

import com.hillel.dtos.AddressDto;
import com.hillel.models.Address;

public class AddressConverter {

    public static Address convertAddressDtoToAddress(AddressDto dto) {
        Address address = new Address();
        address.setCountry(dto.getCountry());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setHouseNumber(dto.getHouseNumber());
        address.setApartmentNumber(dto.getApartmentNumber());
        return address;
    }

    public static AddressDto convertAddressToAddressDto(Address address) {
        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setCountry(address.getCountry());
        dto.setCity(address.getCity());
        dto.setStreet(address.getStreet());
        dto.setHouseNumber(address.getHouseNumber());
        dto.setApartmentNumber(address.getApartmentNumber());
        return dto;
    }
}
