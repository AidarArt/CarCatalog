package ru.artamonov.repository.impl;

import ru.artamonov.db.ConnectionManager;
import ru.artamonov.model.CarEntity;
import ru.artamonov.repository.mapper.CarRepository;
import ru.artamonov.repository.parser.impl.CarResultParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {

    private final ConnectionManager manager;
    private final CarResultParser resultParser = new CarResultParser();

    public CarRepositoryImpl(ConnectionManager manager) {
        this.manager = manager;
    }

    @Override
    public CarEntity findById(Long id) {
        String query = "SELECT * FROM car JOIN brand b ON b.brand_id = car.car_brand_id JOIN engine e ON car.car_engine_id = e.engine_id JOIN brand b2 ON b2.brand_id = e.engine_brand_id WHERE car_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

//            Add a test if resultParser is empty
            return resultParser.getEntity(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public List<CarEntity> findAll() {
        String query = "SELECT * FROM car JOIN brand b ON b.brand_id = car.car_brand_id JOIN engine e ON car.car_engine_id = e.engine_id JOIN brand b2 ON b2.brand_id = e.engine_brand_id;";

        try (Connection connection = manager.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            List<CarEntity> entities = new ArrayList<>();
            entities.add(resultParser.getEntity(resultSet));

            return entities;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void insert(CarEntity carEntity) {
        String query = "INSERT INTO car (car_model_name, car_brand_id, car_engine_id, car_acceleration_to_100, car_max_speed, car_transmission_type, car_body_type) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, carEntity.getCarModelName());
            statement.setLong(2, carEntity.getCarBrand().getBrandId());
            statement.setLong(3, carEntity.getCarEngine().getEngineId());
            statement.setDouble(4, carEntity.getCarAccelerationTo100());
            statement.setDouble(5, carEntity.getCarMaxSpeed());
            statement.setString(6, carEntity.getCarTransmission().name());
            statement.setString(7, carEntity.getCarBodyType().name());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, CarEntity carEntity) {
        String query = "UPDATE car SET car_model_name = ?, car_brand_id = ?, car_engine_id = ?, car_acceleration_to_100 = ?, car_max_speed = ?, car_transmission_type = ?, car_body_type = ? WHERE car_id = ?;";

        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, carEntity.getCarModelName());
            statement.setLong(2, carEntity.getCarBrand().getBrandId());
            statement.setLong(3, carEntity.getCarEngine().getEngineId());
            statement.setDouble(4, carEntity.getCarAccelerationTo100());
            statement.setDouble(5, carEntity.getCarMaxSpeed());
            statement.setString(6, carEntity.getCarTransmission().name());
            statement.setString(7, carEntity.getCarBodyType().name());
            statement.setLong(8, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Long id) {
        String query = "DELETE FROM car WHERE car_id = ?";

        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
