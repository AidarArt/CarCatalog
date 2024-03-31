package ru.artamonov.repository.impl;

import ru.artamonov.db.ConnectionManager;
import ru.artamonov.model.CreatorEntity;
import ru.artamonov.repository.mapper.CreatorRepository;
import ru.artamonov.repository.parser.impl.CreatorResultParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreatorRepositoryImpl implements CreatorRepository {

    private final ConnectionManager manager;
    private final CreatorResultParser resultParser = new CreatorResultParser();

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

            return resultParser.getEntity(resultSet);

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

            creatorEntities.add(resultParser.getEntity(resultSet));

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
}
