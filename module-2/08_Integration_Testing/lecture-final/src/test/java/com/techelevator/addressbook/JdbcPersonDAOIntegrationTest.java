package com.techelevator.addressbook;

import com.techelevator.addressbook.dao.JdbcPersonDAO;
import com.techelevator.addressbook.model.Person;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class JdbcPersonDAOIntegrationTest {

    /*
        1. Setup the datasource/Connect to the database - Before the class is instantiated
        2. Setup data and create the DAO / JdbcTemplate before test
        3. Rollback After each test
        4. Disconnect from the database when the class is destroyed
     */

    private static SingleConnectionDataSource dataSource;
    private JdbcPersonDAO personDao;
    private JdbcTemplate jdbcTemplate;

    @BeforeClass
    public static void setupDataSource() {
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dataSource.setAutoCommit(false);
    }

    @AfterClass
    public static void destroyDataSource() {
        dataSource.destroy();
    }

    @Before
    public void setup() {
        personDao = new JdbcPersonDAO(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }


    @Test
    public void get_person_by_id() {
        /*
            Arrange (Setup): Insert data to select (person row)
            Act (Test):  select the person by id using the DAO
            Assert (Verify): Verify the person returned from the SELECT is the one we inserted
         */
        // Arrange - insert data to select
        Person personWeInserted = insertTestPerson("firstName", "lastName");

        // Act - test, select the person using the DAO method and the id
        Person personReturnedFromDAO = personDao.getById(personWeInserted.getContactId());

        // Assert - verify the personReturned is the same as the person we inserted
        Assert.assertEquals(personWeInserted, personReturnedFromDAO);
    }

    @Test
    public void list_persons_using_count_as_verification() {
        /*
            Arrange: Get Count(*) of the number of records on the person table using the list method.
                     Insert multiple persons
            Act:  select the list using the DAO
            Assert: Get Count(*) again and verify it has increased by the number we inserted
         */
        // Arrange - get the original count and insert some new records
        int originalRowCount = personDao.list().size();
        insertTestPerson("test1", "test1");
        insertTestPerson("test2", "test2");

        // Act
        List<Person> retrievedList = personDao.list();

        Assert.assertEquals(originalRowCount + 2, retrievedList.size());
    }


    @Test
    public void list_persons_using_count_after_truncation_as_verification() {
        /*
            Arrange:  Truncate the table (erase ALL data from the table)
                      Insert multiple persons
            Act: select the list using the DAO
            Assert: verify the size() of the returned list is the equal to the number we inserted
         */
        // Arrange - truncate the table
        truncatePersonTable();
        insertTestPerson("test1", "test1");
        insertTestPerson("test2", "test2");

        // Act
        List<Person> retrievedList = personDao.list();

        Assert.assertEquals(2, retrievedList.size());
    }

    @Test
    public void update_person() {
        /*
            Arrange: Insert a person into the database
                     Change some values about the person
            Act: update the person in the database using the new values
            Assert: Select the person from the database and verify it matches the changes
         */
        // Arrange 1) Insert a person into the database
        Person personFromArrange = insertTestPerson("test1", "test2");
        // Arrange 2) change some values on the person
        personFromArrange.setFirstName("updatedFirst");
        personFromArrange.setLastName("updatedLast");

        // Act
        personDao.save(personFromArrange);

        // Assert
        Person personFromDatabase = selectPersonById(personFromArrange.getContactId());
        Assert.assertEquals(personFromArrange, personFromDatabase);
    }

    private Person selectPersonById(long personId) {
        Person person = null;
        String sql = "SELECT person_id, first_name, last_name, date_added FROM person WHERE person_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, personId);
        if (rows.next()) {
            person = new Person();
            person.setContactId(rows.getLong("person_id"));
            person.setFirstName(rows.getString("first_name"));
            person.setLastName(rows.getString("last_name"));
            person.setDateAdded(rows.getDate("date_added").toLocalDate());
        }
        return person;
    }

    private Person insertTestPerson(String firstName, String lastName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setDateAdded(LocalDate.now());

        String sql = "INSERT INTO person (person_id, first_name, last_name, date_added) " +
                "VALUES (DEFAULT, ?, ?, ?) RETURNING person_id";
        Long personId = jdbcTemplate.queryForObject(sql, Long.class, firstName, lastName, person.getDateAdded());
        person.setContactId(personId);
        return person;
    }

    private void truncatePersonTable() {
        jdbcTemplate.update("TRUNCATE person CASCADE");
    }

}
