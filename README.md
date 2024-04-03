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
  CREATE TABLE brand (
    brand_id SERIAL PRIMARY KEY NOT NULL UNIQUE,
    brand_name varchar(100) NOT NULL UNIQUE,
    brand_country varchar(20) NOT NULL
);

CREATE TABLE engine (
    engine_id SERIAL PRIMARY KEY NOT NULL UNIQUE,
    engine_brand_id INTEGER NOT NULL,
    engine_capacity REAL NOT NULL,
    engine_horse_power REAL NOT NULL,
    engine_cylinders_number SMALLINT NOT NULL,
    engine_consumption REAL NOT NULL,
    FOREIGN KEY (engine_brand_id) REFERENCES brand (brand_id) ON DELETE CASCADE
);

CREATE TABLE creator (
    creator_id SERIAL PRIMARY KEY NOT NULL UNIQUE,
    creator_name varchar(255) NOT NULL,
    creator_surname varchar(255) NOT NULL,
    creator_profession varchar(255) NOT NULL
);
-- Конкретная модель автомобиля
CREATE TABLE car (
    car_id SERIAL PRIMARY KEY NOT NULL UNIQUE,
    car_model_name varchar(100) NOT NULL,
    car_brand_id INTEGER NOT NULL,
    car_engine_id INTEGER NOT NULL,
    car_acceleration_to_100 REAL NOT NULL,
    car_max_speed REAL NOT NULL,
    car_transmission_type varchar(10) NOT NULL,
    car_body_type varchar(20) NOT NULL,
    FOREIGN KEY (car_brand_id) REFERENCES brand (brand_id) ON DELETE CASCADE,
    FOREIGN KEY (car_engine_id) REFERENCES engine (engine_id) ON DELETE CASCADE
);

CREATE TABLE creator_of_car (
    car_id INTEGER NOT NULL,
    creator_id INTEGER NOT NULL,
    FOREIGN KEY (car_id) REFERENCES car (car_id) ON DELETE CASCADE,
    FOREIGN KEY (creator_id) REFERENCES creator (creator_id) ON DELETE CASCADE
);
```
Diagram:
![rest_db diagram](https://github.com/AidarArt/CarCatalog/blob/main/src/main/resources/car_catalog_db.png)
