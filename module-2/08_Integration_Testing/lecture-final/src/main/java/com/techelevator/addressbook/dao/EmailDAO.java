package com.techelevator.addressbook.dao;

import com.techelevator.addressbook.model.Email;

public interface EmailDAO {

    Email get(long emailId);
    Email getByPersonId(long personId);
    void add(Email email);
    void update(Email email);
    void delete(long emailId);
}
