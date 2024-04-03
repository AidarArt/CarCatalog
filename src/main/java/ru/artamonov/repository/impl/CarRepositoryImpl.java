package ru.artamonov.repository.impl;

import ru.artamonov.db.ConnectionManager;
import ru.artamonov.model.CarEntity;
import ru.artamonov.model.CreatorEntity;
import ru.artamonov.repository.mapper.CarRepository;
import ru.artamonov.repository.parser.impl.CarResultParser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {

    private final ConnectionManager manager;
    private final CarResultParser resultParser = new CarResultParser();

    public CarRepositoryImpl(ConnectionManager manager) {
        this.manager = manager;
    }

    @Override
    public List<CreatorEntity> getCarCreators(Long carId) {
        String query = "SELECT * FROM creator JOIN car_creator cc on creator.creator_id = cc.creator_id WHERE car_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, carId);
            ResultSet resultSet = statement.executeQuery();
            return resultParser.getCarCreators(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public CarEntity findById(Long id) {
        String query = "SELECT * FROM car JOIN brand b on b.brand_id = car.car_brand_id WHERE car_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            return resultParser.getEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public List<CarEntity> findAll() {
        String query = "SELECT * FROM car JOIN brand b on b.brand_id = car.car_brand_id;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            return resultParser.getAllEntities(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void insert(CarEntity carEntity) {
        String query = "INSERT INTO car (car_model, car_brand_id) VALUES (?, ?);";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, carEntity.getCarModelName());
            statement.setLong(2, carEntity.getCarBrand().getBrandId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, CarEntity carEntity) {
        String query = "UPDATE car SET car_model = ?, car_brand_id = ? WHERE car_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, carEntity.getCarModelName());
            statement.setLong(2, carEntity.getCarBrand().getBrandId());
            statement.setLong(3, id);
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
