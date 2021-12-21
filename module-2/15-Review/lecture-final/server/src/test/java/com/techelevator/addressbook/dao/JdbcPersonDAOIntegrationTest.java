package com.techelevator.addressbook.dao;

import com.techelevator.DAOIntegrationTest;
import com.techelevator.addressbook.model.Person;
import com.techelevator.addressbook.model.dao.JdbcPersonDAO;
import com.techelevator.addressbook.model.dao.PersonDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

public class JdbcPersonDAOIntegrationTest extends DAOIntegrationTest {

    private JdbcTemplate jdbcTemplate;
    private PersonDAO personDao;

    @Before
    public void setup() {
        jdbcTemplate = new JdbcTemplate(getDataSource());
        personDao = new JdbcPersonDAO(jdbcTemplate);
    }

    @Test
    public void get_all_persons() {
        truncatePersons();
        Person one = createPerson("testFirst", "testLast");
        insertPerson(one);
        Person two = createPerson("secondFirst", "secondLast");
        insertPerson(two);

        List<Person> persons = personDao.list();
        Assert.assertEquals(2, persons.size());
        Assert.assertTrue(persons.contains(one));
        Assert.assertTrue(persons.contains(two));

    }

    private Person createPerson(String firstName, String lastName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setDateAdded(LocalDate.now());
        return person;
    }

    private void insertPerson(Person person) {

        Long personId = jdbcTemplate.queryForObject(
                "INSERT INTO person (person_id, first_name, last_name, " +
                        "date_added) VALUES (DEFAULT, ?, ?, ?) RETURNING person_id",
                Long.class,
                person.getFirstName(), person.getLastName(), person.getDateAdded());
        person.setPersonId(personId);
    }

    private void truncatePersons() {
        jdbcTemplate.update("TRUNCATE person CASCADE");
    }

}
