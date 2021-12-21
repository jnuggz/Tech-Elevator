
DROP TABLE IF EXISTS phone;
DROP TABLE IF EXISTS person_address;
DROP TABLE IF EXISTS email;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS address;



CREATE TABLE person (
        person_id serial primary key,
        first_name varchar(45) not null,
        last_name varchar(45) not null,
        date_added DATE default(current_timestamp)
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

-- These INSERTs use the CURRVAL(sequence) function to get the last value used for the sequence
-- without incrementing it.  This allows for the entries to be added using the sequence so it is current
-- the next time it is used.   WARNING: This only works if the order of the INSERTS is maintained.  If the order is 
-- changed, then it will associate the incorrect ids.  CAUTION: This is 1 ways of using sequences in a schema script, but 
-- should only be used when we are sure there are no other users connected to a database that may be INSERTING other records,
-- which may cause CURRVAL() to return their use of the sequence instead of ours.  In this script is only safe to use, because
-- the earlier portion of the script drops and creates the database when run.  


-- *****************************
-- INSERT Dave Warthog
-- *****************************
INSERT INTO person (person_id, first_name, last_name, date_added) 
        VALUES (DEFAULT, 'Dave', 'Warthog', current_timestamp);
-- INSERT Mr Warthog's Home Address
INSERT INTO address (address_id, address, address_line_two, city, postal_code, district, country_code, type)
        VALUES (DEFAULT, '1245 High Street', 'Apt 51', 'Columbus', '43201', 'OH', 'USA', 'Home');
-- INSERT the person_address join 
INSERT INTO person_address VALUES ( CURRVAL('person_person_id_seq'), CURRVAL('address_address_id_seq') );
-- INSERT Mr. Warthog's Phone
INSERT INTO phone ( phone_id,person_id,phone, type)
        VALUES ( DEFAULT, CURRVAL('person_person_id_seq'),'614-555-1212', 'Mobile');
-- INSERT Mr. Warthog's Email
INSERT INTO email (email_id, person_id, email, type) 
        VALUES ( DEFAULT, CURRVAL('person_person_id_seq'), 'warthog@warthogrules.com', 'Personal');
        

-- *****************************
-- INSERT Ratboy Jones
-- *****************************      
INSERT INTO person (person_id, first_name, last_name, date_added)
        VALUES (DEFAULT, 'Ratboy', 'Jones', current_timestamp);   
-- INSERT The Rat's Home Address
INSERT INTO address (address_id, address, address_line_two, city, postal_code, district, country_code, type)
        VALUES (DEFAULT, 'Under the front street bridge', null, 'Columbus', '43201', 'OH', 'USA', 'Home');   
-- INSERT the person_address join 
INSERT INTO person_address VALUES ( CURRVAL('person_person_id_seq'), CURRVAL('address_address_id_seq') );   
-- INSERT The Rat's Vacation Home Address
INSERT INTO address (address_id, address, address_line_two, city, postal_code, district, country_code, type, type_description)
        VALUES (DEFAULT, 'OSU Tunnels', 'North Oval Entrance', 'Columbus', '43201', 'OH', 'USA', 'Other', 'Under the Bridge');   
-- INSERT the person_address join 
INSERT INTO person_address VALUES ( CURRVAL('person_person_id_seq'), CURRVAL('address_address_id_seq') );     
-- INSERT The Rat's Mobile Phone
INSERT INTO phone ( phone_id,person_id, phone, type)
        VALUES ( DEFAULT, CURRVAL('person_person_id_seq'), '614-555-7892', 'Mobile');       
-- INSERT The Rat's Other Phone
INSERT INTO phone ( phone_id,person_id,phone, type)
        VALUES ( DEFAULT, CURRVAL('person_person_id_seq'),'614-555-7892', 'Other');   
-- INSERT The Rat's Email
INSERT INTO email (email_id, person_id, email, type) 
        VALUES ( DEFAULT, CURRVAL('person_person_id_seq'), 'ratboy@aol.com', 'Personal');
        
-- *****************************
-- INSERT Tall Bobby
-- *****************************
INSERT INTO person (person_id, first_name, last_name)
        VALUES (DEFAULT, 'Tall', 'Bobby');
-- INSERT Tall Bobby's Address
INSERT INTO address (address_id, address, address_line_two, city, postal_code, district, country_code, type)
        VALUES (DEFAULT, '52A 5th Ave', null, 'Columbus', '43220', 'OH', 'USA', 'Work');   
-- INSERT the person_address join 
INSERT INTO person_address VALUES ( CURRVAL('person_person_id_seq'), CURRVAL('address_address_id_seq') );  
-- INSERT Tall Bobby's Home Phone
INSERT INTO phone ( phone_id,person_id,phone, type)
        VALUES ( DEFAULT, CURRVAL('person_person_id_seq'),'614-555-5782', 'Home');  
-- INSERT Tall Bobby's Email
INSERT INTO email (email_id, person_id, email, type) 
        VALUES ( DEFAULT, CURRVAL('person_person_id_seq'), 'tallguy@bobbyrocks.com', 'Work');  
        
-- *****************************
-- INSERT Jenny Jones
-- ***************************** 
INSERT INTO person (person_id, first_name, last_name, date_added)
        VALUES (DEFAULT, 'Jenny', 'Jones', current_timestamp);
-- INSERT Jenny's Address
INSERT INTO address (address_id, address, address_line_two, city, postal_code, district, country_code, type)
        VALUES (DEFAULT, '18 Main St', null, 'Newcomerstown', '43832', 'OH', 'USA', 'Home');   
-- INSERT the person_address join 
INSERT INTO person_address VALUES ( CURRVAL('person_person_id_seq'), CURRVAL('address_address_id_seq') );  
-- INSERT Jenny's Mobile Phone
INSERT INTO phone ( phone_id,person_id,phone, type)
        VALUES ( DEFAULT, CURRVAL('person_person_id_seq'),'212-867-5309', 'Mobile');  
-- INSERT Jenny's Home Phone
INSERT INTO phone ( phone_id,person_id,phone, type)
        VALUES ( DEFAULT, CURRVAL('person_person_id_seq'),'740-867-5309', 'Home');  
-- INSERT Jenny's Other Phone
INSERT INTO phone ( phone_id,person_id,phone, type)
        VALUES ( DEFAULT, CURRVAL('person_person_id_seq'),'614-867-5309', 'Other');  
-- INSERT Jenny's Email
INSERT INTO email (email_id, person_id, email, type) 
        VALUES ( DEFAULT, CURRVAL('person_person_id_seq'), 'jenny@tutone.org', 'Work');  
-- INSERT Jenny's Other Email
INSERT INTO email (email_id, person_id, email, type) 
        VALUES ( DEFAULT, CURRVAL('person_person_id_seq'), 'jenny@stopcalling.io', 'Other'); 


-- *****************************
-- INSERT Jimmy Crooked
-- ***************************** 
INSERT INTO person (person_id, first_name, last_name, date_added)
        VALUES (DEFAULT, 'Jimmy', 'Crooked', current_timestamp);
-- INSERT Crooked's Billing Address
INSERT INTO address (address_id, address, address_line_two, city, postal_code, district, country_code, type)
        VALUES (DEFAULT, '1782 South Ave', null, 'Pittsburgh', '15106', 'PA', 'USA', 'Billing');   
-- INSERT the person_address join 
INSERT INTO person_address VALUES ( CURRVAL('person_person_id_seq'), CURRVAL('address_address_id_seq') );  
-- INSERT Crooked's Shipping Address
INSERT INTO address (address_id, address, address_line_two, city, postal_code, district, country_code, type)
        VALUES (DEFAULT, 'Box 502', null, 'Pittsburgh', '15106', 'PA', 'USA', 'Shipping');    
-- INSERT Crooked's Work Address
INSERT INTO address (address_id, address, address_line_two, city, postal_code, district, country_code, type)
        VALUES (DEFAULT, '7205 1st Avenue', 'Suite 4', 'Pittsburgh', '15106', 'PA', 'USA', 'Work');   
-- INSERT the person_address join 
INSERT INTO person_address VALUES ( CURRVAL('person_person_id_seq'), CURRVAL('address_address_id_seq') );  
-- INSERT Crooked's Email
INSERT INTO email (email_id, person_id, email, type) 
        VALUES ( DEFAULT, CURRVAL('person_person_id_seq'), 'jimmycrooked@cobras.com', 'Personal'); 
        

-- *****************************
-- INSERT Jung Choi
-- ***************************** 
INSERT INTO person (person_id, first_name, last_name, date_added)
        VALUES (DEFAULT, 'Jung', 'Choi', current_timestamp);
-- INSERT Jung Choi's Address
INSERT INTO address (address_id, address, address_line_two, city, postal_code, district, country_code, type)
        VALUES (DEFAULT, '85-1 Chebu-dong', null, 'Seoul', '100-093', 'Jongro-gu', 'KOR', 'Work'); 
-- INSERT the person_address join 
INSERT INTO person_address VALUES ( CURRVAL('person_person_id_seq'), CURRVAL('address_address_id_seq') );  
-- INSERT Jung Choi's Phone
INSERT INTO phone ( phone_id,person_id,phone, type)
        VALUES ( DEFAULT, CURRVAL('person_person_id_seq'),'+82-2-312-3456', 'Mobile');  


-- *****************************
-- INSERT Shelly Sue Samson
-- ***************************** 
INSERT INTO person (person_id, first_name, last_name)
        VALUES (DEFAULT, 'Shelly Sue', 'Samson');