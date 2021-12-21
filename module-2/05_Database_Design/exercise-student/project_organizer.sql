--CREATE DATABASE projectorganizer;


DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS department;

CREATE TABLE department (
        department_id serial PRIMARY KEY,
        name varchar (16) NOT NULL
);

CREATE TABLE employee (
        employee_id serial PRIMARY KEY,
        job_title varchar (32) NOT NULL,
        first_name varchar (16) NOT NULL,
        last_name varchar (16) NOT NULL,
        gender varchar (10) NOT NULL,
        date_of_birth varchar (16) NOT NULL,
        department_id bigint,
        CONSTRAINT chk_gender CHECK (gender IN ('MALE', 'FEMALE', 'OTHER')),
        CONSTRAINT fk_department_id FOREIGN KEY (department_id) REFERENCES department(department_id)
);

CREATE TABLE project (
        project_id serial PRIMARY KEY,
        name varchar (32) NOT NULL,
        start_date varchar (16) NOT NULL,
        employee_id bigint,
        CONSTRAINT fk_employee_id FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

INSERT INTO department (name) VALUES ('Marketing');
INSERT INTO department (name) VALUES ('Sales');
INSERT INTO department (name) VALUES ('Finance');

INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, department_id) VALUES ('Account Executive', 'John', 'Smith', 'MALE', '02-04-1993', 2);
INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, department_id) VALUES ('Marketing Manager', 'Kim', 'Sanchez', 'FEMALE', '05-23-1984', 1);
INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, department_id) VALUES ('Accountant', 'Michael', 'Lee', 'MALE', '10-12-1992', 3);
INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, department_id) VALUES ('Reporting Analyst', 'Paul', 'Gale', 'MALE', '12-01-1972', 3);
INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, department_id) VALUES ('Data Analyst', 'Britney', 'Spears', 'FEMALE', '08-20-1990', 2);
INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, department_id) VALUES ('Sales Rep', 'Sara', 'Beasley', 'FEMALE', '03-05-1986', 2);
INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, department_id) VALUES ('Graphic Designer', 'Joe', 'Pickett', 'MALE', '01-22-1999', 1);
INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, department_id) VALUES ('Video Producer', 'Billy', 'Jean', 'MALE', '11-25-1991', 1);

INSERT INTO project (name, employee_id, start_date) VALUES ('Integrate Salesforce', 4, '10-18-2021');
INSERT INTO project (name, employee_id, start_date) VALUES ('Create Company Holiday Video', 10, '10-17-2021');
INSERT INTO project (name, employee_id, start_date) VALUES ('Adjust Company Lunch Budget', 6, '10-16-2021');
INSERT INTO project (name, employee_id, start_date) VALUES ('Sign up 100 doors', 8, '10-15-2021');