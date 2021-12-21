package com.techelevator.addressbook.dao;

import com.techelevator.addressbook.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDAO implements PersonDAO {

    // Create an instance variable for the JdbcTemplate
    private JdbcTemplate jdbcTemplate;

    public JdbcPersonDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Person> list() {
        String sql = "SELECT person_id, first_name, last_name, date_added FROM person";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        List<Person> people = new ArrayList<Person>();
        while (rows.next()) {
            Person person = mapRowToContact( rows );
            people.add(person);
        }
        return people;
    }

    @Override
    public Person getById(long id) {
        String sql = "SELECT person_id, first_name, last_name, date_added " +
                "FROM person WHERE person_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, id);

        Person person = null;
        if (rows.next()) {
            person = mapRowToContact(rows);
        }

        return person;
    }

    @Override
    public void create(Person person) {
        String sql = "INSERT INTO person (person_id, first_name, last_name, date_added) " +
                "VALUES (DEFAULT, ?, ?, ?) RETURNING person_id";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, person.getFirstName(), person.getLastName(), person.getDateAdded());
        rows.next();
        person.setContactId( rows.getLong("contact_id") );
    }

    @Override
    public void save(Person person) {
        String sql = "UPDATE person SET first_name = ?, last_name = ? WHERE person_id = ?";
        jdbcTemplate.update(sql, person.getFirstName(),
                person.getLastName(), person.getContactId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM person WHERE person_id = ?";
        jdbcTemplate.update(sql, id);
    }

    private Person mapRowToContact(SqlRowSet row) {
        Person person = new Person();

        person.setContactId( row.getLong("person_id") );
        person.setFirstName( row.getString("first_name") );
        person.setLastName( row.getString("last_name") );

        if (row.getDate("date_added") != null) {
            person.setDateAdded(row.getDate("date_added").toLocalDate());
        }

        return person;
    }
}
