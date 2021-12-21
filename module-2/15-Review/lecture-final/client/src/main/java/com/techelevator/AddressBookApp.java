package com.techelevator;

import com.techelevator.addressbook.model.Person;
import com.techelevator.addressbook.services.AddressBookService;
import com.techelevator.addressbook.services.ConsoleService;

import java.util.List;

public class AddressBookApp {

    private static final String API_URL = "http://localhost:8080/";
    private AddressBookService api = new AddressBookService(API_URL);
    private ConsoleService console = new ConsoleService();

    public void run() {

        while(true) {
            String input = console.showMainMenu();
            if (input.equalsIgnoreCase("S")) {
                showAllContacts();
            } else {
                break;
            }
        }

    }

    private void showAllContacts() {

        List<Person> persons = api.getListOfPersons();
        console.printPersons(persons);

    }



    public static void main(String[] args) {
        new AddressBookApp().run();
    }
}
