package com.hillel.repositories;

import com.hillel.db_connectors.DatabaseConnector;
import com.hillel.models.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressRepository {

    private final DatabaseConnector databaseConnector;

    public AddressRepository(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }


    public void addAddress(Address address) {
        Connection connection = databaseConnector.createConnection();
        String sql = "insert into ADDRESS values (DEFAULT, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, address.getCountry());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getStreet());
            statement.setInt(4, address.getHouseNumber());
            statement.setInt(5, address.getApartmentNumber());
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteAddressById(int id) {
        Connection connection = databaseConnector.createConnection();
        String sql = "delete from ADDRESS where ID = ?";
        if(getAddressById(id).getCountry() != null) {
            try {
                connection.setAutoCommit(false);
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, getAddressById(id).getId());
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
        }
        throw new IllegalArgumentException("Address is not found");
    }

    public Address getAddressById(int id) {
        Connection connection = databaseConnector.createConnection();
        Address address = new Address();
        String sql = "select * from ADDRESS where ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                address.setId(resultSet.getInt(1));
                address.setCountry(resultSet.getString(2));
                address.setCity(resultSet.getString(3));
                address.setStreet(resultSet.getString(4));
                address.setHouseNumber(resultSet.getInt(5));
                address.setApartmentNumber(resultSet.getInt(6));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return address;
    }

    public List<Address> getAllAddresses() {
        Connection connection = databaseConnector.createConnection();
        List<Address> resultList = new ArrayList<>();
        String sql = "select * from ADDRESS";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Address address = new Address();
                address.setId(resultSet.getInt(1));
                address.setCountry(resultSet.getString(2));
                address.setCity(resultSet.getString(3));
                address.setStreet(resultSet.getString(4));
                address.setHouseNumber(resultSet.getInt(5));
                address.setApartmentNumber(resultSet.getInt(6));
                resultList.add(address);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    public int updateCountryById(int id, String country) {
        Connection connection = databaseConnector.createConnection();
        String sql = "update ADDRESS set COUNTRY=? where ID=?";
        if (getAddressById(id).getCountry() != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, country);
                statement.setInt(2, id);
                statement.execute();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return id;
        } else {
            throw new IllegalArgumentException("Address is not found");
        }
    }

    public int updateCityById(int id, String city) {
        Connection connection = databaseConnector.createConnection();
        String sql = "update ADDRESS set CITY=? where ID=?";
        if (getAddressById(id).getCity() != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, city);
                statement.setInt(2, id);
                statement.execute();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return id;
        } else {
            throw new IllegalArgumentException("Address is not found");
        }
    }

    public int updateStreetById(int id, String street) {
        Connection connection = databaseConnector.createConnection();
        String sql = "update ADDRESS set STREET=? where ID=?";
        if (getAddressById(id).getStreet() != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, street);
                statement.setInt(2, id);
                statement.execute();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return id;
        } else {
            throw new IllegalArgumentException("Address is not found");
        }
    }

    public int updateHouseNumberById(int id, Integer houseNumber) {
        Connection connection = databaseConnector.createConnection();
        String sql = "update ADDRESS set HOUSE_NUMBER=? where ID=?";
        if (getAddressById(id).getHouseNumber() != 0) {
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, houseNumber);
                statement.setInt(2, id);
                statement.execute();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return id;
        } else {
            throw new IllegalArgumentException("Address is not found");
        }
    }

    public int updateApartmentNumberById(int id, Integer apartmentNumber) {
        Connection connection = databaseConnector.createConnection();
        String sql = "update ADDRESS set APARTMENT_NUMBER=? where ID=?";
        if (getAddressById(id).getApartmentNumber() != 0) {
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, apartmentNumber);
                statement.setInt(2, id);
                statement.execute();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return id;
        } else {
            throw new IllegalArgumentException("Address is not found");
        }
    }
}
