--CREATE DATABASE contacts;

DROP TABLE IF EXISTS phone;
DROP TABLE IF EXISTS person_address;
DROP TABLE IF EXISTS email;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS address;



CREATE TABLE person (
        person_id serial primary key,
        first_name varchar(45) not null,
        last_name varchar(45) not null
);

CREATE TABLE address (
        address_id serial primary key,
        address varchar(64) not null,
        address_line_two varchar(64),
        city varchar(64) not null,
        district varchar(64) not null,
        postal_code varchar(16) not null,
        country_code char(3),
        type varchar(12) not null,
        type_description varchar(255),
        
        constraint chk_address_type check (type IN ('Home', 'Work', 'Shipping', 'Billing', 'Other')),
        constraint chk_type_description check ( 
                (type = 'Other' AND type_description is not null) OR
                (type != 'Other' AND type_description is null) )
        
);

CREATE TABLE person_address (
        person_id bigint,
        address_id bigint,
        
        constraint fk_person_id foreign key (person_id) references person(person_id),
        constraint fk_address_id foreign key (address_id) references address(address_id),
        constraint pk_person_address primary key (person_id, address_id)
);

CREATE TABLE phone (
        phone_id serial primary key,
        person_id bigint not null,
        phone varchar(16) not null,
        type varchar(12) not null,
        
        constraint fk_phone_person_id foreign key (person_id) references person(person_id),
        constraint chk_phone_type check (type IN ('Home','Mobile','Other'))
);

CREATE TABLE email (
        email_id serial primary key,
        person_id bigint not null,
        email varchar(255) not null,
        type varchar(12) not null,
        
        constraint fk_email_person_id foreign key (person_id) references person(person_id),
        constraint chk_email_type check (type IN ('Personal', 'Work', 'Other'))
);

INSERT INTO person (person_id, first_name, last_name) VALUES (DEFAULT, 'Rachelle', 'Rauh');
INSERT INTO phone (phone_id, person_id, phone, type) VALUES (DEFAULT, 1, 'email@email.com', 'Home');





