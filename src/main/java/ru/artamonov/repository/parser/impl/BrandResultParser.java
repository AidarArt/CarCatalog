package ru.artamonov.repository.parser.impl;

import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.CarEntity;
import ru.artamonov.repository.parser.ResultParser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandResultParser implements ResultParser<BrandEntity> {
    @Override
    public BrandEntity getEntity(ResultSet resultSet) throws SQLException {
        BrandEntity entity = new BrandEntity();
        while (resultSet.next()) {
            entity.setBrandId(resultSet.getLong(1));
            entity.setBrandName(resultSet.getString(2));
            entity.setBrandCountry(resultSet.getString(3));
        }
        return entity;
    }

    @Override
    public List<BrandEntity> getAllEntities(ResultSet resultSet) throws SQLException {
        List<BrandEntity> entities = new ArrayList<>();
        while (resultSet.next()) {
            BrandEntity entity = new BrandEntity();
            entity.setBrandId(resultSet.getLong(1));
            entity.setBrandName(resultSet.getString(2));
            entity.setBrandCountry(resultSet.getString(3));
            entities.add(entity);
        }
        return entities;
    }

    public List<CarEntity> getBrandCars(ResultSet resultSet) throws SQLException {
        List<CarEntity> carEntities = new ArrayList<>();
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
        return carEntities;
    }
}
