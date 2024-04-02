package ru.artamonov.repository.impl;

import ru.artamonov.db.ConnectionManager;
import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.CarEntity;
import ru.artamonov.model.CreatorEntity;
import ru.artamonov.repository.mapper.CreatorRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreatorRepositoryImpl implements CreatorRepository {

    private final ConnectionManager manager;

    public CreatorRepositoryImpl(ConnectionManager manager) {
        this.manager = manager;
    }

    @Override
    public List<CarEntity> getCreatorCars(Long creatorId) {
        List<CarEntity> entities = new ArrayList<>();
        String query = "SELECT * FROM car JOIN brand b on car.car_brand_id = b.brand_id JOIN car_creator cc on car.car_id = cc.car_id WHERE creator_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, creatorId);
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
    public CreatorEntity findById(Long id) {
        CreatorEntity entity = new CreatorEntity();
        String query = "SELECT * FROM creator WHERE creator_id = ?";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                entity.setCreatorId(resultSet.getLong(1));
                entity.setCreatorName(resultSet.getString(2));
                entity.setCreatorSurname(resultSet.getString(3));
                entity.setCreatorProfession(resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public List<CreatorEntity> findAll() {
        List<CreatorEntity> entities = new ArrayList<>();
        String query = "SELECT * FROM creator;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
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
    public void insert(CreatorEntity creatorEntity) {
        String query = "INSERT INTO creator (creator_name, creator_surname, creator_profession) VALUES (?, ?, ?);";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, creatorEntity.getCreatorName());
            statement.setString(2, creatorEntity.getCreatorSurname());
            statement.setString(3, creatorEntity.getCreatorProfession());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, CreatorEntity creatorEntity) {
        String query = "UPDATE creator SET creator_name = ?, creator_surname = ?, creator_profession = ? WHERE creator_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, creatorEntity.getCreatorName());
            statement.setString(2, creatorEntity.getCreatorSurname());
            statement.setString(3, creatorEntity.getCreatorProfession());
            statement.setLong(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Long id) {
        String query = "DELETE FROM creator WHERE creator_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
