package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/*
	IMPORTANT:  While this is valid SpringJDBC Code to see all of the
	 parts together, it is not an example of the correct way to structure
	 code using SpringJDBC and here only as an example.

	 USE THE DAO EXAMPLE IN THE com.techelevator.city PACKAGE!
 */


/* Working with JDBC entails a lot of boilerplate code which can become 
 * tedious and error prone. The Spring JBDC framework can help eliminate 
 * much of the boilerplate code, and limit the tedium and mistakes. */
public class SpringJDBCExample {

	public static void main(String[] args) {


		/* ************************************************************
			CREATING A DATASOURCE
		   ************************************************************ */
		/* This datasource will be used for creating connections to the database.
		 * Below, we provide the information required to make database connections */
		BasicDataSource dvdstoreDataSource = new BasicDataSource();
		dvdstoreDataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dvdstoreDataSource.setUsername("postgres");
		dvdstoreDataSource.setPassword("postgres1");




		/* ************************************************************
			INSTANTIATING THE JdbcTemplate
		   ************************************************************ */
		/* The JdbcTemplate is the main interface we use to interact with databases using
		 * Spring JDBC. */
		JdbcTemplate dvdstoreJdbcTemplate = new JdbcTemplate(dvdstoreDataSource);
		




		/* ************************************************************
			EXECUTING A QUERY THAT RETURNS RESULTS AND RETRIEVING THE RESULTS
			Example: SELECT
		   ************************************************************ */

		/*
			1) CREATE YOUR QUERY AS A STRING USING ? FOR PARAMETERS
		 */
		/* The JdbcTemplate can be used to execute parameterized SQL statements */
		String sqlFilmsByCategory =  "SELECT film.title, film.release_year "+
									 "FROM film JOIN film_category ON film.film_id = film_category.film_id "+
									 "JOIN category ON category.category_id = film_category.category_id "+
									 "WHERE category.name = ?";


		/*
			2) use the queryForRowSet method passing it the values for the parameters
		 */
		/* The first parameter to the "queryForRowSet" method is a String containing a parameterized SQL statement
		 * Any following parameters are used to replace query placeholders (i.e. '?') in the order in which they appear */
		String category = "Comedy";
		SqlRowSet results = dvdstoreJdbcTemplate.queryForRowSet(sqlFilmsByCategory, category);

		/*
			3) Get the Results by looping through the returned SqlRowSet
		 */
		/*
		   queryForRowSet() returns a SqlRowSet that can be looped over using while (result.next()) to retrieve
		      the values from the results.  Each time through is a new row of data.  Data can be accessed using the
		      getter for the matching data type and passing it the column name.
		 */
		System.out.println(category+" Films:");
		while(results.next()) {  // The "next" method advances the cursor to the next row.  If a row exists, it returns true, otherwise false
			String filmTitle = results.getString("title");  // this is the title column from teh SELECT statment above
			int releaseYear = results.getInt("release_year");
			System.out.println(filmTitle + " (" + releaseYear + ")");
		}





		/* ************************************************************
			EXECUTING A QUERY THAT DOES NOT RETURN A RESULT
			Example: UPDATE, DELETE
		   ************************************************************ */

		/*
		  1) Use the update() method passing it the values for the parameters
		 */
		/* use the "update" method to run INSERT, UPDATE, and DELETE statements */
		String sqlCreateActor = "INSERT INTO actor(actor_id, first_name, last_name) "+
								"VALUES (DEFAULT, ?, ?)";
		
		dvdstoreJdbcTemplate.update(sqlCreateActor,  "Matt", "Eland");





		/* ************************************************************
			WORKING WITH GENERATED IDs (SEQUENCES)
			Example: UPDATE, DELETE
		   ************************************************************ */

		// Insert the Actor with RETURNING actor_id
		String sqlInsertActorWithReturning = "INSERT INTO actor(actor_id, first_name, last_name) "+
				"VALUES (DEFAULT, ?, ?) RETURNING actor_id";

		// Use queryForObject() to get the returned actor_id
		Long actorId = dvdstoreJdbcTemplate.queryForObject(sqlInsertActorWithReturning, Long.class,
				"Rachelle", "Rauh");

		// Insert the Film with RETURNING film_id
		String sqlInsertFileWithReturning = "INSERT INTO film (film_id, title, description, release_year, language_id, " +
				"		original_language_id, rental_duration, rental_rate, length, replacement_cost, rating)" +
				" VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING film_id";

		// Use queryForObject() to get the returned film_id
		Long filmId = dvdstoreJdbcTemplate.queryForObject(sqlInsertFileWithReturning, Long.class,
				"Always out of Gas", "The thrilling tale of never fueling your car.", 2021,
				1, null, 6, 2.50, 86, 18.99, "PG");

		// Use the actorId and filmId to insert the film_actor join table row.
		// This insert uses update() because it does not have a RETURNING
		String sqlInsertFilmActor = "INSERT INTO film_actor (actor_id, film_id) VALUES (?, ?)";
		dvdstoreJdbcTemplate.update(sqlInsertFilmActor, actorId, filmId);


	}
}
