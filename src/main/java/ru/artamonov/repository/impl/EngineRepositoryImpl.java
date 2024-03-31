package ru.artamonov.repository.impl;

import ru.artamonov.db.ConnectionManager;
import ru.artamonov.model.EngineEntity;
import ru.artamonov.repository.mapper.EngineRepository;
import ru.artamonov.repository.parser.impl.EngineResultParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EngineRepositoryImpl implements EngineRepository {

    private final ConnectionManager manager;
    private final EngineResultParser resultParser = new EngineResultParser();

    public EngineRepositoryImpl(ConnectionManager manager) {
        this.manager = manager;
    }

    @Override
    public EngineEntity findById(Long id) {
        String query = "SELECT * FROM engine JOIN brand b on b.brand_id = engine.engine_brand_id WHERE engine_id = ?;";

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
    public List<EngineEntity> findAll() {
        String query = "SELECT * FROM engine JOIN brand b on b.brand_id = engine.engine_brand_id;";
        try (Connection connection = manager.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            List<EngineEntity> entities = new ArrayList<>();

            entities.add(resultParser.getEntity(resultSet));

            return entities;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void insert(EngineEntity engineEntity) {
        String query = "INSERT INTO engine (engine_brand_id, engine_capacity, engine_horse_power, engine_cylinders_number, engine_consumption, engine_type) VALUES (?, ?, ?, ?, ?, ?);";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, engineEntity.getBrand().getBrandId());
            statement.setDouble(2, engineEntity.getEngineCapacity());
            statement.setDouble(3, engineEntity.getEngineHorsePower());
            statement.setInt(4, engineEntity.getEngineCylindersNumber());
            statement.setDouble(5, engineEntity.getEngineConsumption());
            statement.setString(6, engineEntity.getEngineType().name());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, EngineEntity engineEntity) {
        String query = "UPDATE engine SET engine_brand_id = ?, engine_capacity = ?, engine_horse_power = ?, engine_cylinders_number = ?, engine_consumption = ?, engine_type = ? WHERE engine_id = ?;";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, engineEntity.getBrand().getBrandId());
            statement.setDouble(2, engineEntity.getEngineCapacity());
            statement.setDouble(3, engineEntity.getEngineHorsePower());
            statement.setInt(4, engineEntity.getEngineCylindersNumber());
            statement.setDouble(5, engineEntity.getEngineConsumption());
            statement.setString(6, engineEntity.getEngineType().name());
            statement.setLong(7, engineEntity.getEngineId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Long id) {
        String query = "DELETE FROM engine WHERE engine_id = ?";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
