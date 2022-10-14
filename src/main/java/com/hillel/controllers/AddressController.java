package com.hillel.controllers;

import com.hillel.converters.AddressConverter;
import com.hillel.dtos.AddressDto;
import com.hillel.services.AddressService;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.hillel.converters.AddressConverter.convertAddressDtoToAddress;
import static com.hillel.converters.AddressConverter.convertAddressToAddressDto;

public class AddressController {

    private final AddressService addressService;
    private final Scanner scanner = new Scanner(System.in);


    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    public void addAddress() {
        AddressDto addressDto = new AddressDto();
        System.out.println("Insert country:");
        addressDto.setCountry(requireNonEmpty(scanner.nextLine()));
        System.out.println("Insert city:");
        addressDto.setCity(requireNonEmpty(scanner.nextLine()));
        System.out.println("Insert street:");
        addressDto.setStreet(requireNonEmpty(scanner.nextLine()));
        System.out.println("Insert house number:");
        addressDto.setHouseNumber(requireNonEmpty(scanner.nextInt()));
        System.out.println("Insert apartment number:");
        addressDto.setApartmentNumber(scanner.nextInt());
        addressService.addAddress(convertAddressDtoToAddress(addressDto));
        System.out.println("Address is added to phone book");
    }

    private <T> T requireNonEmpty(T input) {
        if (input.toString().isEmpty()) throw new IllegalArgumentException("Field can`t be empty");
        return input;
    }

    public void deleteAddressById() {
        System.out.println("Insert address id to delete it:");
        int id = requireNonEmpty(scanner.nextInt());
        addressService.deleteAddressById(id);
        System.out.println("Address with ID #" + id + " is deleted from phone book");
    }

    public AddressDto getAddressById() {
        System.out.println("Insert address id to get it:");
        int inputId = requireNonEmpty(scanner.nextInt());
        return convertAddressToAddressDto(addressService.getAddressById(inputId));
    }

    public List<AddressDto> getAllAddresses() {
        return addressService.getAllAddresses().stream()
                .map(AddressConverter::convertAddressToAddressDto).collect(Collectors.toList());
    }

    public void updateCountryById() {
        System.out.println("Insert address id to update it:");
        int id = Integer.parseInt(requireNonEmpty(scanner.nextLine()));
        System.out.println("Insert country:");
        String country = requireNonEmpty(scanner.nextLine());
        int result = addressService.updateCountryById(id, country);
        System.out.println("Address with ID #" + result + " is updated");
    }

    public void updateCityById() {
        System.out.println("Insert address id to update it:");
        int id = Integer.parseInt(requireNonEmpty(scanner.nextLine()));
        System.out.println("Insert city:");
        String city = requireNonEmpty(scanner.nextLine());
        int result = addressService.updateCityById(id, city);
        System.out.println("Address with ID #" + result + " is updated");
    }

    public void updateStreetById() {
        System.out.println("Insert address id to update it:");
        int id = Integer.parseInt(requireNonEmpty(scanner.nextLine()));
        System.out.println("Insert street:");
        String street = requireNonEmpty(scanner.nextLine());
        int result = addressService.updateStreetById(id, street);
        System.out.println("Address with ID #" + result + " is updated");
    }

    public void updateHouseNumberById() {
        System.out.println("Insert address id to update it:");
        int id = Integer.parseInt(requireNonEmpty(scanner.nextLine()));
        System.out.println("Insert house number:");
        int houseNumber = requireNonEmpty(scanner.nextInt());
        int result = addressService.updateHouseNumberById(id, houseNumber);
        System.out.println("Address with ID #" + result + " is updated");
    }

    public void updateApartmentNumberById() {
        System.out.println("Insert address id to update it:");
        int id = Integer.parseInt(requireNonEmpty(scanner.nextLine()));
        System.out.println("Insert apartment number:");
        int apartmentNumber = requireNonEmpty(scanner.nextInt());
        int result = addressService.updateApartmentNumberById(id, apartmentNumber);
        System.out.println("Address with ID #" + result + " is updated");
    }
}
