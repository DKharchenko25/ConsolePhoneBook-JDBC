package com.hillel.services;

import com.hillel.dtos.AddressDto;
import com.hillel.models.Address;
import com.hillel.repositories.AddressRepository;

import java.util.List;
import java.util.Scanner;

public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final Scanner scanner = new Scanner(System.in);

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
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
        addressRepository.addAddress(addressDto);
        System.out.println("Address is added to phone book");
    }

    private <T> T requireNonEmpty(T input) {
        if(input.toString().isEmpty()) throw new IllegalArgumentException("Field can`t be empty");
        return input;
    }


    @Override
    public void deleteAddressById() {
        System.out.println("Insert address id to delete it:");
        int result = addressRepository.deleteAddressById(requireNonEmpty(scanner.nextInt()));
        System.out.println("Address with ID #" + result + " is deleted from phone book");
    }

    @Override
    public Address getAddressById() {
        System.out.println("Insert address id to get it:");
        int inputId = requireNonEmpty(scanner.nextInt());
        if (addressRepository.getAddressById(inputId) != null) {
            return addressRepository.getAddressById(inputId);
        } else {
            throw new IllegalArgumentException("Address with ID #" + inputId + " is not found");
        }
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.getAllAddresses();
    }

    @Override
    public void updateCountryById() {
        AddressDto addressDto = new AddressDto();
        System.out.println("Insert address id to update it:");
        int id = Integer.parseInt(requireNonEmpty(scanner.nextLine()));
        System.out.println("Insert country:");
        addressDto.setCountry(requireNonEmpty(scanner.nextLine()));
        int result = addressRepository.updateCountryById(id, addressDto);
        System.out.println("Address with ID #" + result + " is updated");
    }

    @Override
    public void updateCityById() {
        AddressDto addressDto = new AddressDto();
        System.out.println("Insert address id to update it:");
        int id = Integer.parseInt(requireNonEmpty(scanner.nextLine()));
        System.out.println("Insert city:");
        addressDto.setCity(requireNonEmpty(scanner.nextLine()));
        int result = addressRepository.updateCityById(id, addressDto);
        System.out.println("Address with ID #" + result + " is updated");
    }

    @Override
    public void updateStreetById() {
        AddressDto addressDto = new AddressDto();
        System.out.println("Insert address id to update it:");
        int id = Integer.parseInt(requireNonEmpty(scanner.nextLine()));
        System.out.println("Insert street:");
        addressDto.setStreet(requireNonEmpty(scanner.nextLine()));
        int result = addressRepository.updateStreetById(id, addressDto);
        System.out.println("Address with ID #" + result + " is updated");
    }

    @Override
    public void updateHouseNumberById() {
        AddressDto addressDto = new AddressDto();
        System.out.println("Insert address id to update it:");
        int id = Integer.parseInt(requireNonEmpty(scanner.nextLine()));
        System.out.println("Insert house number:");
        addressDto.setHouseNumber(requireNonEmpty(scanner.nextInt()));
        int result = addressRepository.updateHouseNumberById(id, addressDto);
        System.out.println("Address with ID #" + result + " is updated");
    }

    @Override
    public void updateApartmentNumberById() {
        AddressDto addressDto = new AddressDto();
        System.out.println("Insert address id to update it:");
        int id = Integer.parseInt(requireNonEmpty(scanner.nextLine()));
        System.out.println("Insert apartment number:");
        addressDto.setApartmentNumber(requireNonEmpty(scanner.nextInt()));
        int result = addressRepository.updateApartmentNumberById(id, addressDto);
        System.out.println("Address with ID #" + result + " is updated");
    }

}
