package com.techelevator.addressbook.dao;

import com.techelevator.addressbook.model.Address;

import java.util.List;

public interface AddressDAO {

    List<Address> getByPersonId(long personId);
    void add(Address address, long personId);
    void update(Address address);
    void delete(long addressId);

}
