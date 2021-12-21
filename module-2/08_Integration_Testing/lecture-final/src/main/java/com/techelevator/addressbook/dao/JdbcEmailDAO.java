package com.techelevator.addressbook.dao;

import com.techelevator.addressbook.model.Email;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcEmailDAO implements EmailDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcEmailDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Email get(long emailId) {
        Email email = null;
        String sql = "SELECT email_id, person_id, email, type FROM email WHERE email_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, emailId);
        if (rows.next()) {
            email = mapRowToEmail(rows);
        }
        return email;
    }

    @Override
    public Email getByPersonId(long contactId) {
        Email email = null;
        String sql = "SELECT email_id, person_id, email, type FROM email WHERE person_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, contactId);
        if (rows.next()) {
            email = mapRowToEmail(rows);
        }
        return email;
    }

    @Override
    public void add(Email email) {
        String sql = "INSERT INTO email (email_id, person_id, email, type) " +
                "VALUES (DEFAULT, ?, ?, ?) RETURNING email_id";
        Long emailId = jdbcTemplate.queryForObject(sql, Long.class, email.getPersonId(),
                email.getEmailAddress(), email.getType());
        email.setEmailId(emailId);
    }

    @Override
    public void update(Email email) {
        String sql = "UPDATE email SET email = '', type = '' WHERE email_id = ?";
        jdbcTemplate.update(sql, email.getEmailAddress(), email.getType(),
                email.getTypeDescription(), email.getEmailId());
    }

    @Override
    public void delete(long emailId) {
        String sql = "DELETE FROM email WHERE email_id = ?";
        jdbcTemplate.update(sql, emailId);
    }

    private Email mapRowToEmail(SqlRowSet row) {
        Email email = new Email();

        email.setEmailId( row.getLong("email_id") );
        email.setPersonId( row.getLong("person_id") );
        email.setEmailAddress( row.getString("email") );
        email.setType( row.getString("type") );

        return email;
    }
}
