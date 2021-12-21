package com.techelevator.addressbook.services;


import com.techelevator.addressbook.model.Person;

import java.util.List;
import java.util.Scanner;

public class ConsoleService {

  private static final Scanner in = new Scanner(System.in);;

  public String showMainMenu() {
    String userInput = null;
    while (userInput == null) {
      System.out.println("S) how Contacts");
      System.out.println("Q) uit");

      userInput = in.nextLine();
      if (!userInput.equalsIgnoreCase("S") &&
        !userInput.equalsIgnoreCase("Q")) {
        userInput = null;
      }
    }

    return userInput;
  }

  public void printPersons(List<Person> persons) {

    for(Person person : persons) {
      System.out.println("Name: " + person.getFullName());
    }
  }


}
