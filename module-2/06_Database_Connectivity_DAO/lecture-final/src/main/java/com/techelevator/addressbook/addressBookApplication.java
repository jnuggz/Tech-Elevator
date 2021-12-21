package com.techelevator.addressbook;

import com.techelevator.addressbook.dao.JdbcPersonDAO;
import com.techelevator.addressbook.dao.PersonDAO;
import com.techelevator.addressbook.model.Person;
import org.apache.commons.dbcp2.BasicDataSource;

import java.time.LocalDate;
import java.util.List;

public class addressBookApplication {

    public static void main(String[] args) {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        PersonDAO personDao = new JdbcPersonDAO(dataSource);

        List<Person> persons = personDao.list();

        System.out.println(persons);

        Person personToAdd = new Person();
        personToAdd.setFirstName("John");
        personToAdd.setLastName("Fulton");
        personToAdd.setDateAdded(LocalDate.now());

        personDao.create(personToAdd);

        personToAdd.setFirstName("THE JOHN");
        personToAdd.setLastName("FULTON");

        personDao.update(personToAdd);

        System.out.println( personDao.findByStartOfLastName("c"));

        System.out.println( personDao.get(3));

    }
}
