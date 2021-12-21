-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
SELECT title
FROM film
JOIN film_actor ON film.film_id = film_actor.film_id
JOIN actor ON film_actor.actor_id = actor.actor_id
WHERE first_name = 'NICK' AND last_name = 'STALLONE';

-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
SELECT title, (first_name || ' ' || last_name) AS actress
FROM film
JOIN film_actor ON film.film_id = film_actor.film_id
JOIN actor ON film_actor.actor_id = actor.actor_id
WHERE first_name = 'RITA';

-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
SELECT title, (first_name || ' ' || last_name) AS actor
FROM film
JOIN film_actor ON film.film_id = film_actor.film_id
JOIN actor ON film_actor.actor_id = actor.actor_id
WHERE (first_name = 'JUDY' AND last_name = 'DEAN') OR (first_name = 'RIVER' AND last_name = 'DEAN');

-- 4. All of the the ‘Documentary’ films
-- (68 rows)
SELECT title, name AS category
FROM film
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE name = 'Documentary';

-- 5. All of the ‘Comedy’ films
-- (58 rows)
SELECT title, name AS category
FROM film
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE name = 'Comedy';

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)
SELECT title, name, rating
FROM film
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE name = 'Children' AND rating = 'G';

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)
SELECT title, name, length
FROM film
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE name = 'Family' AND rating = 'G' AND length < 120;

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
SELECT title, (first_name|| ' ' ||last_name) AS actor, rating
FROM film
JOIN film_actor ON film.film_id = film_actor.film_id
JOIN actor ON film_actor.actor_id = actor.actor_id
WHERE first_name = 'MATTHEW' AND last_name = 'LEIGH' AND rating = 'G';

-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
SELECT title, name, release_year
FROM film
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE name = 'Sci-Fi' AND release_year = 2006;

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
SELECT title, (first_name|| ' ' ||last_name) AS actor, name
FROM film
JOIN film_actor ON film.film_id = film_actor.film_id
JOIN actor ON film_actor.actor_id = actor.actor_id
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE first_name = 'NICK' AND last_name = 'STALLONE' AND name = 'Action';

-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
SELECT address, city, district, country
FROM store
JOIN address ON store.address_id = address.address_id
JOIN city ON address.city_id = city.city_id
JOIN country ON city.country_id = country.country_id;

-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)
SELECT store.store_id, address, (first_name||' '||last_name) AS manager_name
FROM store
JOIN address ON store.address_id = address.address_id
JOIN staff ON store.store_id = staff.store_id;

-- 13. The first and last name of the top ten customers ranked by number of rentals
-- (#1 should be “ELEANOR HUNT�? with 46 rentals, #10 should have 39 rentals)
SELECT first_name, last_name, COUNT(last_name)
FROM customer
JOIN rental ON customer.customer_id = rental.customer_id
GROUP BY first_name, last_name
ORDER BY count DESC
LIMIT 10;

-- 14. The first and last name of the top ten customers ranked by dollars spent
-- (#1 should be “KARL SEAL�? with 221.55 spent, #10 should be “ANA BRADLEY�? with 174.66 spent)
SELECT first_name, last_name, SUM(amount)
FROM customer
JOIN payment ON customer. customer_id = payment.customer_id
GROUP BY first_name, last_name
ORDER BY sum DESC
LIMIT 10;

-- 15. The store ID, street address, 
--      total number of rentals, 
--      total amount of sales (i.e. payments), 
--      and average sale of each store.
-- (NOTE: Keep in mind that while a customer has only one primary store, they may rent from either store.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)
SELECT store.store_id, address.address, COUNT(*), SUM(payment.amount), AVG(payment.amount)
FROM store
JOIN address ON store.address_id = address.address_id
JOIN customer ON store.store_id = customer.store_id
JOIN rental ON customer.customer_id = rental.customer_id
JOIN payment ON rental.rental_id = payment.rental_id
GROUP BY store.store_id, address.address;


-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD�? with 34 rentals and #10 should have 31 rentals)
SELECT title, COUNT(*)
FROM film
JOIN inventory i ON film.film_id = i.film_id
JOIN rental r ON i.inventory_id = r.inventory_id
GROUP BY title
ORDER BY count DESC
LIMIT 10;

-- 17. The top five film categories by number of rentals
-- (#1 should be “Sports�? with 1179 rentals and #5 should be “Family�? with 1096 rentals)
SELECT category.name, COUNT(*)
FROM category
JOIN film_category fc ON category.category_id = fc.category_id
JOIN film f ON fc.film_id = f.film_id
JOIN inventory i ON f.film_id = i.film_id
JOIN rental r ON i.inventory_id = r.inventory_id
GROUP BY category.category_id
ORDER BY count DESC
LIMIT 5;

-- 18. The top five Action film titles by number of rentals
-- (#1 should have 30 rentals and #5 should have 28 rentals)
SELECT title, COUNT(*)
FROM film
JOIN film_category fc ON film.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
JOIN inventory i ON film.film_id = i.film_id
JOIN rental r ON i.inventory_id = r.inventory_id
WHERE c.name = 'Action'
GROUP BY title
ORDER BY count DESC
LIMIT 5;

-- 19. The top 10 actors ranked by number of rentals of films starring that actor
-- (#1 should be “GINA DEGENERES�? with 753 rentals and #10 should be “SEAN GUINESS�? with 599 rentals)
SELECT first_name, last_name, COUNT(*)
FROM actor
JOIN film_actor fa ON actor.actor_id = fa.actor_id
JOIN film ON fa.film_id = film.film_id
JOIN inventory i ON film.film_id = i.film_id
JOIN rental r ON i.inventory_id = r.inventory_id
GROUP BY actor.actor_id
ORDER BY count DESC
LIMIT 10;

-- 20. The top 5 “Comedy�? actors ranked by number of rentals of films in the “Comedy�? category starring that actor
-- (#1 should have 87 rentals and #5 should have 72 rentals)
SELECT first_name, last_name, COUNT(*)
FROM actor
JOIN film_actor fa ON actor.actor_id = fa.actor_id
JOIN film ON fa.film_id = film.film_id
JOIN inventory i ON film.film_id = i.film_id
JOIN rental r ON i.inventory_id = r.inventory_id
JOIN film_category fc ON film.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
WHERE c.name = 'Comedy'
GROUP BY actor.actor_id
ORDER BY count DESC
LIMIT 5;