package com.techelevator.addressbook;

import com.techelevator.addressbook.dao.JdbcPersonDAO;
import com.techelevator.addressbook.model.Person;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.SQLException;

public class JdbcPersonDAOIntegrationTest {

    /*
        1. Connect to the database - Before the class is instantiated
        2. Setup data and create the DAO / JdbcTemplate before test
        3. Rollback After each test
        4. Disconnect from the database when the class is destroyed
     */

    private static SingleConnectionDataSource dataSource;
    private JdbcPersonDAO personDao;
    private JdbcTemplate jdbcTemplate;

    @BeforeClass
    //  Has to be static because it has to exist before the class is instantiated
    public static void setupDataSource() {
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dataSource.setAutoCommit(false); // Keeping this false gives control when to commit
    }

    @AfterClass
    public static void destroyDataSource() { // Static has to be called when there is no instance
        dataSource.destroy();
    }

    //Things we want to run while the object exists can't be static
    @Before
    public void setup() {
        personDao = new JdbcPersonDAO(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource); //Used to setup test and verify
    }

    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback(); //Let junit handle the exception and add to method signature
    }

    @Test
    public void get_person_by_id() {
        /*
            Arrange (Setup): Insert data to select (person row)
            Act (Test): select the person by id using the DAO
            Assert (Verify) Verify the person returned from the SELECT is the one we inserted
         */

    }

    private Person insertTestPerson



    @Test
    public void list_persons_using_count_as_verification() {
        /*
            Arrange: Get Count(*) of the number of records on the person table using the list method.
                Insert multiple persons
            Act: select the list using the DAO
            Assert: Get Count(*) again and verify it has increased by the number we inserted
         */
        //Arrange - get the original count and insert some new records


        @Test
        public void list_persons_using_count_after_truncation_as_verification () {
        /*
            Arrange: Truncate the table (erase ALL data from the table)
                Insert multiple persons
            Act: select the list using the DAO
            Assert: verify the size of the returned list is equal to the number we inserted

            In SQL: TRUNCATE person CASCADE; <--- this wipes out anything in the table and anything connected
         */

        }
    }
}