package com.techelevator.addressbook.dao;

import com.techelevator.addressbook.model.Phone;

import java.util.List;

public interface PhoneDAO {

    List<Phone> getByPerson(long personId);
    void add(Phone phone);
    void update(Phone phone);
    void delete(long phoneId);
}
