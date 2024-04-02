package ru.artamonov.repository.impl;

import ru.artamonov.db.ConnectionManager;
import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.CarEntity;
import ru.artamonov.repository.mapper.BrandRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandRepositoryImpl implements BrandRepository {

    private final ConnectionManager manager;

    public BrandRepositoryImpl(ConnectionManager manager) {
        this.manager = manager;
    }

    @Override
    public List<CarEntity> getBrandCars(Long brandId) {
        List<CarEntity> carEntities = new ArrayList<>();

        String query = "SELECT * FROM brand JOIN car c on brand.brand_id = c.car_brand_id WHERE brand_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, brandId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CarEntity entity = new CarEntity();
                entity.setCarId(resultSet.getLong(4));
                entity.setCarModelName(resultSet.getString(5));
                BrandEntity brand = new BrandEntity();
                brand.setBrandId(resultSet.getLong(1));
                brand.setBrandName(resultSet.getString(2));
                brand.setBrandCountry(resultSet.getString(3));
                entity.setCarBrand(brand);
                carEntities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carEntities;
    }

    @Override
    public BrandEntity findById(Long id) {
        BrandEntity entity = new BrandEntity();
        String query = "SELECT * FROM brand WHERE brand_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                entity.setBrandId(id);
                entity.setBrandName(resultSet.getString(2));
                entity.setBrandCountry(resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public List<BrandEntity> findAll() {
        List<BrandEntity> entities = new ArrayList<>();
        String query = "SELECT * FROM brand;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BrandEntity entity = new BrandEntity();
                entity.setBrandId(resultSet.getLong(1));
                entity.setBrandName(resultSet.getString(2));
                entity.setBrandCountry(resultSet.getString(3));
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public void insert(BrandEntity entity) {
        String query = "INSERT INTO brand (brand_name, brand_country) VALUES (?, ?)";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, entity.getBrandName());
            statement.setString(2, entity.getBrandCountry());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, BrandEntity entity) {
        String query = "UPDATE brand SET brand_name = ?, brand_country = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, entity.getBrandName());
            statement.setString(2, entity.getBrandCountry());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Long id) {
        String query = "DELETE FROM brand WHERE brand_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
