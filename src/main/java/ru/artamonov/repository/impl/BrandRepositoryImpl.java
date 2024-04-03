package ru.artamonov.repository.impl;

import ru.artamonov.db.ConnectionManager;
import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.CarEntity;
import ru.artamonov.repository.mapper.BrandRepository;
import ru.artamonov.repository.parser.impl.BrandResultParser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandRepositoryImpl implements BrandRepository {

    private final ConnectionManager manager;
    private final BrandResultParser resultParser = new BrandResultParser();

    public BrandRepositoryImpl(ConnectionManager manager) {
        this.manager = manager;
    }

    @Override
    public List<CarEntity> getBrandCars(Long brandId) {
        String query = "SELECT * FROM brand JOIN car c on brand.brand_id = c.car_brand_id WHERE brand_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, brandId);
            ResultSet resultSet = statement.executeQuery();
            return resultParser.getBrandCars(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public BrandEntity findById(Long id) {
        String query = "SELECT * FROM brand WHERE brand_id = ?;";
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
    public List<BrandEntity> findAll() {
        String query = "SELECT * FROM brand;";
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
        String query = "UPDATE brand SET brand_name = ?, brand_country = ? WHERE brand_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, entity.getBrandName());
            statement.setString(2, entity.getBrandCountry());
            statement.setLong(3, id);
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
