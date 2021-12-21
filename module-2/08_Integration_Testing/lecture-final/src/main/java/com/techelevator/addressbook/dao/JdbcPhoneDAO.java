package com.techelevator.addressbook.dao;

import com.techelevator.addressbook.model.Phone;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPhoneDAO implements PhoneDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcPhoneDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Phone> getByPerson(long personId) {

        List<Phone> phones = new ArrayList<Phone>();

        String sql = "SELECT phone_id, person_id, phone, type, type " +
                "FROM phone " +
                "WHERE person_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, personId);
        while (rows.next()) {
            phones.add( mapRowToPhone(rows) );
        }
        return phones;
    }

    @Override
    public void add(Phone phone) {

        String sql = "INSERT INTO phone (phone_id, person_id, phone, type) " +
                "VALUES (DEFAULT, ?, ?, ?, ?) RETURNING phone_id";

        Long phoneId = jdbcTemplate.queryForObject(sql, Long.class, phone.getPersonId(), phone.getPhoneNumber(),
                phone.getType(), phone.getTypeDescription());
        phone.setPhoneId(phoneId);
    }


    @Override
    public void update(Phone phone) {
        String sql = "UPDATE phone SET phone = '', type = '' WHERE phone_id = ?";
        jdbcTemplate.update(sql, phone.getPhoneNumber(), phone.getType(), phone.getTypeDescription(), phone.getPhoneId());
    }

    @Override
    public void delete(long phoneId) {
        String sql = "DELETE FROM phone WHERE phone_id = ?";
        jdbcTemplate.update(sql, phoneId);
    }


    private Phone mapRowToPhone(SqlRowSet row) {
        Phone phone = new Phone();
        phone.setPhoneId( row.getLong("phone_id") );
        phone.setPersonId( row.getLong("person_id") );
        phone.setPhoneNumber( row.getString("phone") );
        phone.setType( row.getString("type") );

        return phone;
    }
}
