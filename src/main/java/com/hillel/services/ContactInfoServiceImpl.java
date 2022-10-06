package com.hillel.services;

import com.hillel.dtos.ContactInfoDto;
import com.hillel.models.ContactInfo;
import com.hillel.repositories.ContactInfoRepository;

import java.util.Scanner;

public class ContactInfoServiceImpl implements ContactInfoService {
    private final ContactInfoRepository contactInfoRepository;

    private final Scanner scanner = new Scanner(System.in);

    public ContactInfoServiceImpl(ContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
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
        contactInfoRepository.addContact(contactInfoDto);
        System.out.println("Contact is added to phone book");
    }

    private <T> T requireNonEmpty(T input) {
        if (input.toString().isEmpty()) throw new IllegalArgumentException("Field can`t be empty");
        return input;
    }

    @Override
    public void deleteContactById() {
        System.out.println("Insert contact id to delete it:");
        int result = contactInfoRepository.deleteContactById(requireNonEmpty(scanner.nextInt()));
        System.out.println("Contact with ID #" + result + " is deleted from phone book");

    }

    @Override
    public String getContactById() {
        System.out.println("Insert contact id to get it:");
        int inputId = requireNonEmpty(scanner.nextInt());
        if (contactInfoRepository.getContactById(inputId).getId() != 0) {
            ContactInfo contactInfo = contactInfoRepository.getContactById(inputId);
            return contactInfo.toString() + "\n" + "address: " +  contactInfo.getAddress();
        } else {
            throw new IllegalArgumentException("Contact with ID #" + inputId + " is not found");
        }
    }

    @Override
    public String getAllContacts() {
        return contactInfoRepository.getAllContacts().toString();
    }

    @Override
    public void updateFirstNameById() {
        ContactInfoDto contactInfoDto = new ContactInfoDto();
        int id = Integer.parseInt(getInsertId());
        System.out.println("Insert first name:");
        contactInfoDto.setFirstName(requireNonEmpty(scanner.nextLine()));
        int result = contactInfoRepository.updateFirstNameById(id, contactInfoDto);
        System.out.println("Contact with ID #" + result + " is updated");
    }

    @Override
    public void updateLastNameById() {
        ContactInfoDto contactInfoDto = new ContactInfoDto();
        int id = Integer.parseInt(getInsertId());
        System.out.println("Insert last name:");
        contactInfoDto.setLastName(requireNonEmpty(scanner.nextLine()));
        int result = contactInfoRepository.updateLastNameById(id, contactInfoDto);
        System.out.println("Contact with ID #" + result + " is updated");
    }

    @Override
    public void updateAgeById() {
        ContactInfoDto contactInfoDto = new ContactInfoDto();
        int id = Integer.parseInt(getInsertId());
        System.out.println("Insert age:");
        contactInfoDto.setAge(requireNonEmpty(scanner.nextInt()));
        int result = contactInfoRepository.updateAgeById(id, contactInfoDto);
        System.out.println("Contact with ID #" + result + " is updated");
    }

    @Override
    public void updatePhoneNumberById() {
        ContactInfoDto contactInfoDto = new ContactInfoDto();
        int id = Integer.parseInt(getInsertId());
        System.out.println("Insert phone number:");
        contactInfoDto.setPhoneNumber(requireNonEmpty(scanner.nextLine()));
        int result = contactInfoRepository.updatePhoneNumberById(id, contactInfoDto);
        System.out.println("Contact with ID #" + result + " is updated");
    }

    @Override
    public void updateAddressIdById() {
        ContactInfoDto contactInfoDto = new ContactInfoDto();
        int id = Integer.parseInt(getInsertId());
        System.out.println("Insert address id:");
        int addressId = Integer.parseInt(requireNonEmpty(scanner.nextLine()));
        contactInfoDto.setAddressId(addressId);
        int result = contactInfoRepository.updateAddressIdById(id, contactInfoDto);
        System.out.println("Contact with ID #" + result + " is updated");
    }

    private String getInsertId() {
        System.out.println("Insert contact id to update it:");
        return requireNonEmpty(scanner.nextLine());
    }
}
