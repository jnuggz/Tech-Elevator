package com.techelevator.addressbook.dao;

import com.techelevator.addressbook.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDAO implements PersonDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcPersonDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public List<Person> list() {
        String sql = "SELECT person_id, first_name, last_name, date_added FROM person";
        List<Person> persons = new ArrayList<Person>();

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()) {
            persons.add( mapRowToPerson(results) );
        }


        return persons;
    }

    @Override
    public void create(Person personToAdd) {
        String sql = "INSERT INTO person (person_id, first_name, last_name, date_added) " +
                "VALUES (DEFAULT, ?, ?, ?) RETURNING person_id";

        Long personId = jdbcTemplate.queryForObject(sql, Long.class, personToAdd.getFirstName(),
                personToAdd.getLastName(), personToAdd.getDateAdded());

        personToAdd.setPersonId(personId);

    }

    @Override
    public void update(Person newValues) {

        String sql = "UPDATE person SET first_name = ?, last_name = ? WHERE person_id = ?";
        jdbcTemplate.update(sql, newValues.getFirstName(),
                newValues.getLastName(), newValues.getPersonId());

    }

    @Override
    public List<Person> findByStartOfLastName(String startsWith) {
        List<Person> persons = new ArrayList<Person>();
        String sql = "SELECT person_id, first_name, last_name, date_added FROM person WHERE last_name ILIKE ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, startsWith + "%");
        while (rows.next()) {
            persons.add( mapRowToPerson(rows) );
        }
        return persons;
    }

    @Override
    public Person get(long personId) {
        Person person = null;
        String sql = "SELECT person_id, first_name, last_name, date_added FROM person WHERE person_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, personId);
        if (rows.next()) {
            person = mapRowToPerson(rows);
        }
        return person;
    }

    private Person mapRowToPerson(SqlRowSet row) {
        Person person = new Person();

        person.setPersonId( row.getLong("person_id") );
        person.setFirstName( row.getString("first_name") );
        person.setLastName( row.getString("last_name") );

        if (row.getDate("date_added") != null) {
            person.setDateAdded(row.getDate("date_added").toLocalDate());
        }

        return person;
    }

}
