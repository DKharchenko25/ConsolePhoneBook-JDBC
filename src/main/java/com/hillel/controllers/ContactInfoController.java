package com.hillel.controllers;

import com.hillel.converters.ContactInfoConverter;
import com.hillel.dtos.ContactInfoDto;
import com.hillel.services.ContactInfoService;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.hillel.converters.ContactInfoConverter.convertContactInfoDtoToContactInfo;
import static com.hillel.converters.ContactInfoConverter.convertContactInfoToContactInfoDto;

public class ContactInfoController {

    private final ContactInfoService contactInfoService;
    private final Scanner scanner = new Scanner(System.in);

    public ContactInfoController(ContactInfoService contactInfoService) {
        this.contactInfoService = contactInfoService;
    }

    public void addContact() {
        ContactInfoDto contactInfoDto = new ContactInfoDto();
        System.out.println("Insert first name:");
        contactInfoDto.setFirstName(requireNonEmpty(scanner.nextLine()));
        System.out.println("Insert last name:");
        contactInfoDto.setLastName(requireNonEmpty(scanner.nextLine()));
        System.out.println("Insert age:");
        contactInfoDto.setAge(requireNonEmpty(Integer.parseInt(scanner.nextLine())));
        System.out.println("Insert phone number:");
        contactInfoDto.setPhoneNumber(requireNonEmpty(scanner.nextLine()));
        System.out.println("Insert address id:");
        contactInfoDto.setAddressId(requireNonEmpty(Integer.parseInt(scanner.nextLine())));
        contactInfoService.addContact(convertContactInfoDtoToContactInfo(contactInfoDto));
        System.out.println("Contact is added to phone book");
    }

    private <T> T requireNonEmpty(T input) {
        if (input.toString().isEmpty()) throw new IllegalArgumentException("Field can`t be empty");
        return input;
    }

    public void deleteContactById() {
        System.out.println("Insert contact id to delete it:");
        int result = contactInfoService.deleteContactById(requireNonEmpty(scanner.nextInt()));
        System.out.println("Contact with ID #" + result + " is deleted from phone book");
    }

    public String getContactById() {
        System.out.println("Insert contact id to get it:");
        int inputId = requireNonEmpty(scanner.nextInt());
        ContactInfoDto dto = convertContactInfoToContactInfoDto(contactInfoService.getContactById(inputId));
        return dto + "\n" + dto.getAddress();
    }

    public List<ContactInfoDto> getAllContacts() {
        return contactInfoService.getAllContacts().stream()
                .map(ContactInfoConverter::convertContactInfoToContactInfoDto).collect(Collectors.toList());
    }

    public void updateFirstNameById() {
        int id = Integer.parseInt(getInsertId());
        System.out.println("Insert first name:");
        String firstName = requireNonEmpty(scanner.nextLine());
        int result = contactInfoService.updateFirstNameById(id, firstName);
        System.out.println("Contact with ID #" + result + " is updated");
    }

    public void updateLastNameById() {
        int id = Integer.parseInt(getInsertId());
        System.out.println("Insert last name:");
        String lastName = requireNonEmpty(scanner.nextLine());
        int result = contactInfoService.updateLastNameById(id, lastName);
        System.out.println("Contact with ID #" + result + " is updated");
    }

    public void updateAgeById() {
        int id = Integer.parseInt(getInsertId());
        System.out.println("Insert age:");
        int age = requireNonEmpty(scanner.nextInt());
        int result = contactInfoService.updateAgeById(id, age);
        System.out.println("Contact with ID #" + result + " is updated");
    }

    public void updatePhoneNumberById() {
        int id = Integer.parseInt(getInsertId());
        System.out.println("Insert phone number:");
        String phoneNumber = requireNonEmpty(scanner.nextLine());
        int result = contactInfoService.updatePhoneNumberById(id, phoneNumber);
        System.out.println("Contact with ID #" + result + " is updated");
    }

    public void updateAddressIdById() {
        int id = Integer.parseInt(getInsertId());
        System.out.println("Insert address id:");
        int addressId = requireNonEmpty(scanner.nextInt());
        int result = contactInfoService.updateAgeById(id, addressId);
        System.out.println("Contact with ID #" + result + " is updated");
    }

    private String getInsertId() {
        System.out.println("Insert contact id to update it:");
        return requireNonEmpty(scanner.nextLine());
    }
}
