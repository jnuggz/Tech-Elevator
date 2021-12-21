package com.techelevator.city;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import com.techelevator.city.model.City;
import com.techelevator.city.model.JDBCCityDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JDBCCityDAOIntegrationTest {

	private static final String TEST_COUNTRY = "XYZ";

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JDBCCityDAO dao;
	private JdbcTemplate jdbcTemplate;

	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}

	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@Before
	public void setup() {
		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, " +
				"lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) " +
				"VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, " +
				"5976.00, NULL, 'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";
		 jdbcTemplate= new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);
		dao = new JDBCCityDAO(dataSource);
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}


	/***********************************************************
	 TESTING A SELECT
	 ***********************************************************/

	/*
		Testing a method that returns a single Object
	 */
	@Test
	public void get_city_by_id() throws SQLException {
		// Arrange - create a city object and insert it into the database
		City theCity = insertCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535);

		// Act
		City savedCity = dao.findCityById(theCity.getId());

		// Assert - verify that the city that was returned was the one inserted
		assertCitiesAreEqual(theCity, savedCity);
	}


	/*
		Testing a List of Cities
	 */
	@Test
	public void returns_cities_by_country_code() {

		// Arrange - Inserting a City
		City theCity = insertCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535);

		// Act - find the city that was inserted
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);

		// Assert
		// Assert that the list returned was not null
		assertNotNull(results);
		// Assert that the number of cities returned in the list is corect
		assertEquals(1, results.size());
		// get the city from the list and assert it is equal to the city we inserted
		City savedCity = results.get(0);
		assertCitiesAreEqual(theCity, savedCity);
	}


	/*
		Testing a List of ALL Cities
	 */
	@Test
	public void returns_multiple_cities_by_country_code() {

		// Arrange - inserting 2 cities in the test country
		insertCity("test", "test", TEST_COUNTRY, 123);
		insertCity("test2", "test", TEST_COUNTRY, 123);

		// Act - call the method that returns those cities by country code
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);

		// Assert - verify that correct number of cities where returned
		assertNotNull(results);
		assertEquals(2, results.size());
	}



	/***********************************************************
	 TESTING AN INSERT
	 ***********************************************************/
	@Test
	public void test_city_created() {
		// Assert
		City cityToBeCreated = getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535);

		// Act
		dao.create(cityToBeCreated);

		// Assert
		Assert.assertTrue(cityToBeCreated.getId() > 0);
		City cityReturnedFromSelect = selectCity(cityToBeCreated.getId());
		assertCitiesAreEqual(cityToBeCreated, cityReturnedFromSelect);
	}



	/***********************************************************
	 TESTING A CITY UPDATE
	 ***********************************************************/
	@Test
	public void update_city() {
		// Arrange
		City theCity = insertCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535);
		theCity.setName("this_is_test");
		theCity.setDistrict("Updated");
		theCity.setPopulation(100);

		// Act
		dao.update(theCity);

		// Assert
		City cityReturnedFromSelect = selectCity(theCity.getId());
		assertCitiesAreEqual(theCity, cityReturnedFromSelect);

	}


	/***********************************************************
	 TESTING A CITY DELETE
	 ***********************************************************/
	@Test
	public void delete_city() {
		// Arrange
		City theCity = insertCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535);

		// Act
		dao.delete(theCity.getId());

		// Assert
		City cityReturnedFromSelect = selectCity(theCity.getId());
		Assert.assertNull(cityReturnedFromSelect);

	}





	/***********************************************************
	 Private to help with setting up and verifying Cities for tests
	 ***********************************************************/
	private City selectCity(long id) {
		City selectedCity = null;
		String sql = "SELECT id, name, countrycode, district, population FROM city WHERE id = ?";

		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
		if (result.next()) {
			selectedCity = new City();
			selectedCity.setId(result.getLong("id"));
			selectedCity.setName(result.getString("name"));
			selectedCity.setCountryCode(result.getString("countrycode"));
			selectedCity.setDistrict(result.getString("district"));
			selectedCity.setPopulation(result.getInt("population"));
		}


		return selectedCity;
	}


	private City insertCity(String name, String district, String countryCode, int population) {
		City cityToInsert = getCity(name, district, countryCode, population);
		return insertCity(cityToInsert);
	}


	private City insertCity(City cityToInsert) {
		String insertSql = "INSERT INTO city (id, name, countrycode, district, population) " +
				"VALUES (DEFAULT, ?, ?, ?, ?) RETURNING id";

		Long cityId = jdbcTemplate.queryForObject(insertSql, Long.class, cityToInsert.getName(), cityToInsert.getCountryCode(),
				cityToInsert.getDistrict(), cityToInsert.getPopulation());

		cityToInsert.setId(cityId);

		return cityToInsert;
	}


	private City getCity(String name, String district, String countryCode, int population) {
		City theCity = new City();
		theCity.setName(name);
		theCity.setDistrict(district);
		theCity.setCountryCode(countryCode);
		theCity.setPopulation(population);
		return theCity;
	}

	private void assertCitiesAreEqual(City expected, City actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDistrict(), actual.getDistrict());
		assertEquals(expected.getCountryCode(), actual.getCountryCode());
		assertEquals(expected.getPopulation(), actual.getPopulation());
	}
}
