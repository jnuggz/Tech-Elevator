package com.techelevator.addressbook.services;

import com.techelevator.addressbook.model.Person;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class AddressBookService {

    private RestTemplate restTemplate = new RestTemplate();
    private String baseUrl;

    public AddressBookService(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<Person> getListOfPersons() {
        Person[] personArray = restTemplate.getForObject(this.baseUrl + "persons", Person[].class);
        return Arrays.asList(personArray);
    }

}
