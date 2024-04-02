package ru.artamonov.repository.impl;

import ru.artamonov.db.ConnectionManager;
import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.CarEntity;
import ru.artamonov.model.EngineEntity;
import ru.artamonov.repository.mapper.BrandRepository;
import ru.artamonov.repository.parser.impl.BrandResultParser;
import ru.artamonov.repository.parser.impl.CarResultParser;
import ru.artamonov.repository.parser.impl.EngineResultParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandRepositoryImpl implements BrandRepository {

    private final ConnectionManager manager;
    private final BrandResultParser brandResultParser = new BrandResultParser();
    private final EngineResultParser engineResultParser = new EngineResultParser();
    private final CarResultParser carResultParser = new CarResultParser();

    public BrandRepositoryImpl(ConnectionManager manager) {
        this.manager = manager;
    }

    @Override
    public BrandEntity findById(Long id) {
        String query = "SELECT * FROM brand WHERE brand_id = ?;";
        try (Connection connection = manager.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            BrandEntity entity = brandResultParser.getEntity(resultSet);
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

            return brandResultParser.getAllEntities(resultSet);
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
            statement.setString(2, brandEntity.getBrandCountry().name());
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

    @Override
    public List<EngineEntity> getBrandEngines(Long brandId) {
        String query = "SELECT * FROM engine WHERE engine_brand_id = ?";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, brandId);
            ResultSet resultSet = statement.executeQuery();
            List<EngineEntity> engines = new ArrayList<>();

            engines.add(engineResultParser.getEntity(resultSet));
            return engines;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public List<CarEntity> getBrandCars(Long brandId) {
        String query = "SELECT * FROM car WHERE car_brand_id = ?";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, brandId);
            ResultSet resultSet = statement.executeQuery();
            List<CarEntity> cars = new ArrayList<>();

            cars.add(carResultParser.getEntity(resultSet));
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Long findByName(String name) {
        Long id = -1L;
        String query = "SELECT * FROM brand WHERE brand_name = ?";
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();
            Long resId = brandResultParser.getEntity(resultSet).getBrandId();
            if(resId != null)
                id = resId;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
