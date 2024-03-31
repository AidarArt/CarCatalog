package ru.artamonov.repository.impl;

import ru.artamonov.db.ConnectionManager;
import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.enums.Country;
import ru.artamonov.repository.mapper.BrandRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandRepositoryImpl implements BrandRepository {

    private final ConnectionManager manager;

    public BrandRepositoryImpl(ConnectionManager manager) {
        this.manager = manager;
    }

    @Override
    public BrandEntity findById(Long id) {
        String query = "SELECT * FROM brand WHERE brand_id = ?;";
        try (Connection connection = manager.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            BrandEntity entity = new BrandEntity();
            while (resultSet.next()) {
                entity.setBrandId(resultSet.getLong(1));
                entity.setBrandName(resultSet.getString(2));
                entity.setBrandCountry(Country.valueOf(resultSet.getString(3)));
            }
            if (entity.getBrandId() != null)
                return entity;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException(String.format("Brand with id = '%s' not found", id));
    }

    @Override
    public List<BrandEntity> findAll() {
        String query = "SELECT * FROM brand;";
        try  (Connection connection = manager.getConnection();
              Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<BrandEntity> entities = new ArrayList<>();
            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String country = resultSet.getString(3);
                entities.add(new BrandEntity(id, name, Country.valueOf(country)));
            }
            if (!entities.isEmpty())
                return entities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void insert(BrandEntity brandEntity) {
        String query = "INSERT INTO brand (brand_name, brand_country) VALUES (?, ?);";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, brandEntity.getBrandName());
            statement.setString(2, brandEntity.getBrandCountry().name());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, BrandEntity brandEntity) {
        String query = "UPDATE brand SET brand_name = ?, brand_country = ? WHERE brand_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, brandEntity.getBrandName());
            statement.setString(2, brandEntity.getBrandName());
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
