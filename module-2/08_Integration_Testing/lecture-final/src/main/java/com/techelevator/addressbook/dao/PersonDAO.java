package com.techelevator.addressbook.dao;

import com.techelevator.addressbook.model.Person;

import java.util.List;

public interface PersonDAO {

    // Get a list of all contacts
    List<Person> list();

    // Get a single contact by the contact id
    Person getById(long id);

    // Create a new contact
    void create(Person person);

    // Save changes to an existing contact (update it)
    void save(Person person);

    // delete a contact
    void delete(long id);
}
