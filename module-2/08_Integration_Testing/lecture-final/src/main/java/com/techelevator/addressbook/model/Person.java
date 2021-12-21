package com.techelevator.addressbook.model;

import java.time.LocalDate;
import java.util.Objects;

public class Person {

    private long contactId;
    private String firstName;
    private String lastName;
    private LocalDate dateAdded;

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return contactId == person.contactId && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(dateAdded, person.dateAdded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, firstName, lastName, dateAdded);
    }
}
