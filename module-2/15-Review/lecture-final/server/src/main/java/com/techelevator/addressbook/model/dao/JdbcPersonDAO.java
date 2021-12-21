package com.techelevator.addressbook.model.dao;

import com.techelevator.addressbook.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPersonDAO implements PersonDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcPersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> list() {
        List<Person> persons = new ArrayList<Person>();
        String sql = "SELECT person_id, first_name, last_name, date_added FROM person";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while (rows.next()) {
            persons.add(mapRowToPerson(rows));
        }
        return persons;
    }

    private Person mapRowToPerson(SqlRowSet row) {
        Person person = new Person();
        person.setPersonId( row.getLong("person_id"));
        person.setFirstName( row.getString("first_name"));
        person.setLastName( row.getString("last_name"));

        if (row.getDate("date_added") != null) {
            person.setDateAdded(row.getDate("date_added").toLocalDate());
        }

        return person;
    }
}
