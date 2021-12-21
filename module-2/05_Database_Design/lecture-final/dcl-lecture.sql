
-- Create a new User with a Password
CREATE USER john WITH PASSWORD '123';

-- Grant SELECT ON a table to a user
GRANT SELECT ON person TO john;


-- Grant INSERT ON a table to a user
GRANT INSERT ON person TO john;

-- Grant SELECT ON a sequence to a user
GRANT USAGE, SELECT ON SEQUENCE person_person_id_seq TO john;

-- Revoke SELECT ON a table from a user
REVOKE SELECT ON person FROM john;

SELECT * FROM person;