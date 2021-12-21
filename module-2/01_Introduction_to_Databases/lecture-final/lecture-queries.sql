-- SELECT ... FROM
-- Selecting the names for all countries
SELECT name FROM country;

-- Selecting the name and population of all countries
SELECT name, population FROM country;

-- Selecting all columns from the city table
SELECT * FROM country;

-- Can use DISTINCT to get only unique values for a column
SELECT DISTINCT continent FROM country;

-- Can use AS to ALIAS (or change the name of a column)
SELECT name AS country_name, continent AS country_continent, population FROM country;



-- SELECT ... FROM ... WHERE
-- Selecting the cities in Ohio
SELECT * FROM city WHERE district = 'Ohio';

-- Selecting countries that gained independence in the year 1776
SELECT name, continent FROM country WHERE indepyear = 1776;

-- Selecting countries not in Asia
SELECT * FROM country WHERE continent != 'Asia';

-- Selecting countries that do not have an independence year
SELECT * FROM country WHERE indepyear IS NULL;

-- Selecting countries that do have an independence year
SELECT * FROM country WHERE indepyear IS NOT NULL;

-- Selecting countries that have a population greater than 5 million
SELECT * FROM country WHERE population > 5000000;

-- Select countries IN Asia, Europe, or South America
SELECT * FROM country WHERE continent IN ('Asia', 'Europe', 'South America');

-- Select countries NOT IN Asia, Europe, or South America
SELECT * FROM country WHERE continent NOT IN ('Asia', 'Europe', 'South America');

-- SELECT countries with a population between 1000000 and 5000000
SELECT * FROM country WHERE population BETWEEN 1000000 AND 5000000;

-- SELECT countries that start with the letter A
SELECT * FROM country WHERE name LIKE 'A%';

-- SELECT countries that start with the letter a (case insensitive) [PostgreSQL only]
SELECT * FROM country WHERE name ILIKE 'a%';

-- Select countries that are in Southern regions
SELECT * FROM country WHERE region LIKE 'Southern%';

-- Select Countries that end with the letter n
SELECT * FROM country WHERE name LIKE '%n';

-- SELECT countries that contain the letter z
SELECT * FROM country WHERE name LIKE '%z%';

-- SELECT ... FROM ... WHERE ... AND/OR
-- Selecting cities in Ohio and Population greater than 400,000
SELECT * FROM city WHERE district = 'Ohio' AND population > 400000;

-- Selecting country names on the continent North America or South America
SELECT * FROM country WHERE continent = 'North America' OR continent = 'South America';

-- Use () to set precedence
SELECT name AS country_name 
FROM country 
WHERE continent = 'Asia' 
AND (surfacearea BETWEEN 250000 AND 1000000 OR population > 10000000)
AND name ILIKE '%m%';



-- SELECTING DATA w/arithmetic
-- Selecting the population, life expectancy, and population per area
--	note the use of the 'as' keyword
-- +, -, *, /
SELECT population, lifeexpectancy, (population / surfacearea) AS density FROM country;


