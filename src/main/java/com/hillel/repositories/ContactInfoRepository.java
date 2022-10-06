package com.hillel.repositories;

import com.hillel.db_connectors.DatabaseConnector;
import com.hillel.dtos.ContactInfoDto;
import com.hillel.models.ContactInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactInfoRepository {
    private final DatabaseConnector databaseConnector;

    private final AddressRepository addressRepository;

    public ContactInfoRepository(DatabaseConnector databaseConnector, AddressRepository addressRepository) {
        this.databaseConnector = databaseConnector;
        this.addressRepository = addressRepository;
    }

    public void addContact(ContactInfoDto dto) {
        Connection connection = databaseConnector.createConnection();
        String sql = "insert into CONTACT_INFO values (DEFAULT, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, dto.getFirstName());
            statement.setString(2, dto.getLastName());
            statement.setInt(3, dto.getAge());
            statement.setString(4, dto.getPhoneNumber());
            statement.setInt(5, addressRepository.getAddressById(dto.getAddressId()).getId());
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteContactById(int id) {
        Connection connection = databaseConnector.createConnection();
        String sql = "delete from CONTACT_INFO where ID = ?";
        if (getContactById(id).getId() != 0) {
            try {
                connection.setAutoCommit(false);
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                connection.commit();
                connection.close();
            } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                throw new RuntimeException(e);
            }
            return id;
        } else {
            throw new IllegalArgumentException("Contact is not found");
        }
    }

    public ContactInfo getContactById(int id) {
        Connection connection = databaseConnector.createConnection();
        ContactInfo contactInfo = new ContactInfo();
        String sql = "select * from CONTACT_INFO where ID=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                contactInfo.setId(resultSet.getInt(1));
                contactInfo.setFirstName(resultSet.getString(2));
                contactInfo.setLastName(resultSet.getString(3));
                contactInfo.setAge(resultSet.getInt(4));
                contactInfo.setPhoneNumber(resultSet.getString(5));
                contactInfo.setAddress(addressRepository.getAddressById(resultSet.getInt(6)));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contactInfo;
    }

    public List<ContactInfo> getAllContacts() {
        Connection connection = databaseConnector.createConnection();
        List<ContactInfo> resultList = new ArrayList<>();
        String sql = "select * from CONTACT_INFO";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ContactInfo contact = new ContactInfo();
                contact.setId(resultSet.getInt(1));
                contact.setFirstName(resultSet.getString(2));
                contact.setLastName(resultSet.getString(3));
                contact.setAge(resultSet.getInt(4));
                contact.setPhoneNumber(resultSet.getString(5));
                resultList.add(contact);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    public int updateFirstNameById(int id, ContactInfoDto dto) {
        Connection connection = databaseConnector.createConnection();
        String sql = "update CONTACT_INFO set FIRST_NAME = ? where ID = ?";
        if (getContactById(id).getFirstName() != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, dto.getFirstName());
                statement.setInt(2, id);
                statement.execute();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return id;
        } else {
            throw new IllegalArgumentException("Contact is not found");
        }
    }

    public int updateLastNameById(int id, ContactInfoDto dto) {
        Connection connection = databaseConnector.createConnection();
        String sql = "update CONTACT_INFO set LAST_NAME = ? where ID = ?";
        if (getContactById(id).getLastName() != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, dto.getLastName());
                statement.setInt(2, id);
                statement.execute();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return id;
        } else {
            throw new IllegalArgumentException("Contact is not found");
        }
    }

    public int updateAgeById(int id, ContactInfoDto dto) {
        Connection connection = databaseConnector.createConnection();
        String sql = "update CONTACT_INFO set AGE = ? where ID = ?";
        if (getContactById(id).getAge() != 0) {
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, dto.getAge());
                statement.setInt(2, id);
                statement.execute();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return id;
        } else {
            throw new IllegalArgumentException("Contact is not found");
        }
    }

    public int updatePhoneNumberById(int id, ContactInfoDto dto) {
        Connection connection = databaseConnector.createConnection();
        String sql = "update CONTACT_INFO set PHONE_NUMBER = ? where ID = ?";
        if (getContactById(id).getPhoneNumber() != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, dto.getPhoneNumber());
                statement.setInt(2, id);
                statement.execute();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return id;
        } else {
            throw new IllegalArgumentException("Contact is not found");
        }
    }

    public int updateAddressIdById(int id, ContactInfoDto dto) {
        Connection connection = databaseConnector.createConnection();
        String sql = "update CONTACT_INFO set ADDRESS_ID = ? where ID = ?";
        if (getContactById(id).getAddress() != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, dto.getAddressId());
                statement.setInt(2, id);
                statement.execute();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return id;
        } else {
            throw new IllegalArgumentException("Contact is not found");
        }
    }
}
