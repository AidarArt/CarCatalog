# Car catalog

This app allows the user to find the car he is interested in and read information about it

## Technologies and dependencies

 - Java SDK 19
 - [Tomcat 10.1.15](https://tomcat.apache.org/download-10.cgi)
 - [Junit 5.10.2](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)
 - [PostgreSQL JDBC Driver 42.7.3](https://mvnrepository.com/artifact/org.postgresql/postgresql)
 - [Jakarta Servlet 6.1.0-M2](https://mvnrepository.com/artifact/jakarta.servlet/jakarta.servlet-api)

## Database
Script:

```bash
  CREATE TABLE body_type (
  body_id SERIAL PRIMARY KEY NOT NULL,
  body_name varchar(30) NOT NULL UNIQUE,
  body_weight real NOT NULL,
  body_length real NOT NULL,
  body_width real NOT NULL,
  body_height real NOT NULL
);

CREATE TABLE creator (
  creator_id SERIAL PRIMARY KEY NOT NULL,
  creator_name varchar(255) NOT NULL,
  creator_surname varchar(255) NOT NULL,
  creator_profession varchar(50) NOT NULL
);

CREATE TABLE brand (
    brand_id SERIAL PRIMARY KEY NOT NULL,
    brand_name varchar(100) NOT NULL UNIQUE,
    brand_country_id integer NOT NULL,
    FOREIGN KEY (brand_country_id) REFERENCES country (country_id) ON DELETE CASCADE
);

CREATE TABLE engine (
  engine_id SERIAL PRIMARY KEY NOT NULL,
  engine_name varchar(50) NOT NULL UNIQUE,
  engine_capacity real NOT NULL,
  engine_horse_power real NOT NULL,
  engine_type varchar(30) NOT NULL,
  engine_cylinders_number smallint NOT NULL,
  engine_consumption numeric(6, 2) NOT NULL
);

CREATE TABLE transmission (
    transmission_id SERIAL PRIMARY KEY NOT NULL,
    transmission_name varchar(50) NOT NULL UNIQUE,
    transmission_gears_number smallint NOT NULL
);

CREATE TABLE country (
  country_id SERIAL PRIMARY KEY NOT NULL,
  country_name varchar(255) NOT NULL UNIQUE
);

CREATE TABLE car (
  car_id SERIAL PRIMARY KEY NOT NULL,
  car_model varchar(100) NOT NULL UNIQUE,
  car_brand_id integer,
  car_acceleration_to_100 real NOT NULL,
  car_max_speed smallint NOT NULL,
  car_engine_id integer,
  car_transmission_id integer,
  car_body_type_id integer,
  FOREIGN KEY (car_brand_id) REFERENCES brand (brand_id) ON DELETE CASCADE,
  FOREIGN KEY (car_engine_id) REFERENCES engine (engine_id) ON DELETE SET DEFAULT,
  FOREIGN KEY (car_transmission_id) REFERENCES transmission (transmission_id) ON DELETE SET DEFAULT,
  FOREIGN KEY (car_body_type_id) REFERENCES body_type (body_id) ON DELETE SET DEFAULT
);

CREATE TABLE car_creator (
  car_id integer NOT NULL,
  creator_id integer NOT NULL,
  FOREIGN KEY (car_id) REFERENCES car (car_id) ON DELETE SET DEFAULT,
  FOREIGN KEY (creator_id) REFERENCES creator (creator_id) ON DELETE SET DEFAULT
);

```
Diagram:
![rest_db diagram](https://github.com/AidarArt/CarCatalog/blob/master/src/main/resources/rest_db.png)
