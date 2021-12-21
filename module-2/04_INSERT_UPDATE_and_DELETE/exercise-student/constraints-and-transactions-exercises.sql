START TRANSACTION;
COMMIT;
ROLLBACK;
-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
SELECT * FROM actor;

INSERT INTO actor (actor_id, first_name, last_name)
VALUES (201, 'Hampton', 'Avenue');
INSERT INTO actor (actor_id, first_name, last_name) 
VALUES (202, 'Lisa', 'Byway');


-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
SELECT * FROM film WHERE film_id = 1001;

INSERT INTO film (film_id, title, description, release_year, language_id, length)
VALUES (1001, 'Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 198);


-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
SELECT * FROM film_actor WHERE actor_id = 202;

INSERT INTO film_actor (film_id, actor_id)
VALUES (1001, 201), (1001, 202);

-- 4. Add Mathmagical to the category table.
SELECT * FROM category;
SELECT * FROM film_category WHERE film_id = 1001;

INSERT INTO category (category_id, name)
VALUES (17, 'Mathmagical');

INSERT INTO film_category (film_id, category_id)
VALUES (1001, 17);

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
SELECT * FROM category;
SELECT * FROM film;

SELECT * FROM film 
JOIN film_category ON film.film_id = film_category.film_id 
JOIN category ON film_category.category_id = category.category_id
WHERE title IN ('Euclidean PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE');


UPDATE film_category
SET category_id = 17
WHERE film_id IN (
        SELECT film_id
        FROM film
        WHERE title IN ('Euclidean PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE')
        );

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)
SELECT * FROM film
WHERE title IN ('Euclidean PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE');
SELECT *
FROM film_category
WHERE category_id = 17;

UPDATE film
SET rating = 'G'
WHERE film_id IN (
        SELECT film_id
        FROM film_category
        WHERE category_id = 17);

-- 7. Add a copy of "Euclidean PI" to all the stores.
SELECT * FROM film;
SELECT * FROM inventory
WHERE film_id = 1001;
SELECT * FROM store;

INSERT INTO inventory (film_id, store_id)
VALUES (1001, 1);
INSERT INTO inventory (film_id, store_id)
VALUES (1001, 2);

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)

-- This DELETE statement fails because the "film_id" column of the film_actor
-- table is a foreign key constraint

-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

-- This DELETE statement fails because the "category_id" column of the film_category
-- table is a foreign key constraint

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

-- THis DELETE statement succeeded since there were no comflicting constraints.
-- All 5 rows added earlier were deleted.

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE>

-- This DELETE statement failed once again because the "film_id" column of
-- the film_actor table is a foreign key constraint.

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.

-- The film_actor table has a foreign key constraint on film_id which may
-- prevent the film from being removed.
-- The film_category table has a foreign key constraint on film_id which may
-- prevent the film from being removed.
-- The inventory table has a similar constraint on film_id, and may keep the
-- film fron being deleted.
-- So, "Euclidean PI" cannot be deleted from the film table until all
-- references to its film_id are gone from from both the film_actor and
-- inventory tables.