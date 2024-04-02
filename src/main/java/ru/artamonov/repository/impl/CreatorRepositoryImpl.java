package ru.artamonov.repository.impl;

import ru.artamonov.db.ConnectionManager;
import ru.artamonov.model.CarEntity;
import ru.artamonov.model.CreatorEntity;
import ru.artamonov.repository.mapper.CreatorRepository;
import ru.artamonov.repository.parser.impl.CarResultParser;
import ru.artamonov.repository.parser.impl.CreatorResultParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreatorRepositoryImpl implements CreatorRepository {

    private final ConnectionManager manager;
    private final CreatorResultParser creatorResultParser = new CreatorResultParser();
    private final CarResultParser carResultParser = new CarResultParser();

    public CreatorRepositoryImpl(ConnectionManager manager) {
        this.manager = manager;
    }

    @Override
    public CreatorEntity findById(Long id) {
        String query = "SELECT * FROM creator WHERE creator_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            return creatorResultParser.getEntity(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public List<CreatorEntity> findAll() {
        String query = "SELECT * FROM creator;";
        try (Connection connection = manager.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            List<CreatorEntity> creatorEntities = new ArrayList<>();

            creatorEntities.add(creatorResultParser.getEntity(resultSet));

            return creatorEntities;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
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

    @Override
    public List<CarEntity> getCreatorCars(Long creatorId) {
        String query = "SELECT c.car_id, c.car_model_name, c.car_brand_id, c.car_engine_id, c.car_acceleration_to_100, c.car_max_speed, c.car_transmission_type, c.car_body_type FROM creator_of_car JOIN car c on c.car_id = creator_of_car.car_id WHERE creator_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, creatorId);
            ResultSet resultSet = statement.executeQuery();
            return carResultParser.getAllEntities(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }
}
