package com.techelevator.addressbook.controller;

import com.techelevator.addressbook.model.Person;
import com.techelevator.addressbook.model.dao.PersonDAO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressbookController {

    private PersonDAO personDAO;

    public AddressbookController(PersonDAO personDao) {
        this.personDAO = personDao;
    }


    // /persons
    @RequestMapping(path="/persons", method=RequestMethod.GET)
    public List<Person> list() {
        List<Person> persons = personDAO.list();
        return persons;
    }

}
