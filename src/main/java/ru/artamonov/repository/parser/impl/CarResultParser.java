package ru.artamonov.repository.parser.impl;

import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.CarEntity;
import ru.artamonov.model.CreatorEntity;
import ru.artamonov.repository.parser.ResultParser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarResultParser implements ResultParser<CarEntity> {
    @Override
    public CarEntity getEntity(ResultSet resultSet) throws SQLException {
        CarEntity entity = new CarEntity();
        while (resultSet.next()) {
            entity.setCarId(resultSet.getLong(1));
            entity.setCarModelName(resultSet.getString(2));
            BrandEntity brand = new BrandEntity();
            brand.setBrandId(resultSet.getLong(4));
            brand.setBrandName(resultSet.getString(5));
            brand.setBrandCountry(resultSet.getString(6));
            entity.setCarBrand(brand);
        }
        return entity;
    }

    @Override
    public List<CarEntity> getAllEntities(ResultSet resultSet) throws SQLException {
        List<CarEntity> entities = new ArrayList<>();
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
        return entities;
    }

    public List<CreatorEntity> getCarCreators(ResultSet resultSet) throws SQLException {
        List<CreatorEntity> entities = new ArrayList<>();
        while (resultSet.next()) {
            CreatorEntity entity = new CreatorEntity();
            entity.setCreatorId(resultSet.getLong(1));
            entity.setCreatorName(resultSet.getString(2));
            entity.setCreatorSurname(resultSet.getString(3));
            entity.setCreatorProfession(resultSet.getString(4));
            entities.add(entity);
        }
        return entities;
    }
}
