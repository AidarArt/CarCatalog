package ru.artamonov.repository.impl;

import ru.artamonov.db.ConnectionManager;
import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.CarEntity;
import ru.artamonov.model.CreatorEntity;
import ru.artamonov.repository.mapper.CarRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {

    private final ConnectionManager manager;

    public CarRepositoryImpl(ConnectionManager manager) {
        this.manager = manager;
    }

    @Override
    public List<CreatorEntity> getCarCreators(Long carId) {
        List<CreatorEntity> entities = new ArrayList<>();
        String query = "SELECT * FROM creator JOIN car_creator cc on creator.creator_id = cc.creator_id WHERE car_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, carId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CreatorEntity entity = new CreatorEntity();
                entity.setCreatorId(resultSet.getLong(1));
                entity.setCreatorName(resultSet.getString(2));
                entity.setCreatorSurname(resultSet.getString(3));
                entity.setCreatorProfession(resultSet.getString(4));
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public CarEntity findById(Long id) {
        CarEntity entity = new CarEntity();
        String query = "SELECT * FROM car JOIN brand b on b.brand_id = car.car_brand_id WHERE car_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                entity.setCarId(resultSet.getLong(1));
                entity.setCarModelName(resultSet.getString(2));
                BrandEntity brand = new BrandEntity();
                brand.setBrandId(resultSet.getLong(4));
                brand.setBrandName(resultSet.getString(5));
                brand.setBrandCountry(resultSet.getString(6));
                entity.setCarBrand(brand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public List<CarEntity> findAll() {
        List<CarEntity> entities = new ArrayList<>();
        String query = "SELECT * FROM car JOIN brand b on b.brand_id = car.car_brand_id;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CarEntity entity = new CarEntity();
                entity.setCarId(resultSet.getLong(1));
                entity.setCarModelName(resultSet.getString(2));
                BrandEntity brand = new BrandEntity();
                brand.setBrandId(resultSet.getLong(4));
                brand.setBrandName(resultSet.getString(5));
                brand.setBrandCountry(resultSet.getString(6));
                entity.setCarBrand(brand);
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
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
