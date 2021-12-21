-- INSERT

SELECT * FROM countrylanguage;

-- 1. Add Klingon as a spoken language in the USA
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
VALUES ('USA', 'Klingon', false, 1);

-- 2. Add Klingon as a spoken language in Great Britain
INSERT INTO countrylanguage (language, percentage, isofficial, countrycode)
VALUES ('Klingon', 2, false, 'GBR');



-- UPDATE

SELECT * FROM country WHERE code = 'USA';  -- 3813
SELECT * FROM city WHERE name = 'Houston';  -- 3796

-- 1. Update the capital of the USA to Houston
UPDATE country
SET capital = 3796
WHERE code = 'USA';

-- 2. Update the capital of the USA to Washington DC and the head of state
UPDATE country
SET capital = 3813, headofstate = 'Rachelle Rauh'
WHERE code = 'USA';

-- DELETE

-- 1. Delete English as a spoken language in the USA
DELETE FROM countrylanguage WHERE countrycode = 'USA' AND language = 'English';

-- 2. Delete all occurrences of the Klingon language 
DELETE FROM countrylanguage WHERE language = 'Klingon';

SELECT * FROM country WHERE code = 'USA';
DELETE FROM country WHERE code = 'USA';

UPDATE country
SET capital = 3796
WHERE code = 'USA';
SELECT * FROM country WHERE code = 'USA';

SELECT * FROM city WHERE id = 3796;
DELETE FROM city WHERE id = 3796;

-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.
INSERT INTO countrylanguage (language) VALUES ('Elvish');

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
VALUES ('ZZZ', 'English', false, 2);

-- 3. Try deleting the country USA. What happens?
DELETE FROM country WHERE code = 'USA';

-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
VALUES ('USA', 'English', false, 0);


-- 2. Try again. What happens?

-- 3. Let's relocate the USA to the continent - 'Outer Space'
UPDATE country
SET continent = 'Outer Space'
WHERE code = 'USA';

-- How to view all of the constraints
SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;

-- A Query that shows all in a particular schema, which for us is "public"
SELECT conrelid::regclass AS table_from
     , conname
     , pg_get_constraintdef(c.oid)
FROM   pg_constraint c
JOIN   pg_namespace n ON n.oid = c.connamespace
WHERE  contype IN ('f', 'p', 'c', 'u')  -- f=foreign key, p=primary key, c=check, u=unique
AND    n.nspname = 'public'
ORDER  BY conrelid::regclass::text, contype DESC;



-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.
START TRANSACTION; 
        DELETE FROM countrylanguage;
ROLLBACK;

COMMIT;

SELECT * FROM countrylanguage;

-- 2. Try updating all of the cities to be in the USA and roll it back
START TRANSACTION;
        UPDATE city SET countrycode = 'USA';
ROLLBACK;

SELECT * FROM city;
-- 3. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.
