package com.techelevator.address.services;

import com.techelevator.addressbook.model.Person;
import com.techelevator.addressbook.services.AddressBookService;
import org.junit.*;

import java.util.List;

public class AddressBookServiceTests {

    private AddressBookService service;

    @Before
    public void setup() {
        service = new AddressBookService("http://localhost:8080/");
    }

    @Test
    public void verify_api_returns_list_of_persons() {
        List<Person> persons = service.getListOfPersons();
        Assert.assertNotNull(persons);
        Assert.assertTrue(persons.size() > 0);
    }

}
