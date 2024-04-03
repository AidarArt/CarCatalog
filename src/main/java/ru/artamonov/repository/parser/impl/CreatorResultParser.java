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

public class CreatorResultParser implements ResultParser<CreatorEntity> {
    @Override
    public CreatorEntity getEntity(ResultSet resultSet) throws SQLException {
        CreatorEntity entity = new CreatorEntity();
        while (resultSet.next()) {
            entity.setCreatorId(resultSet.getLong(1));
            entity.setCreatorName(resultSet.getString(2));
            entity.setCreatorSurname(resultSet.getString(3));
            entity.setCreatorProfession(resultSet.getString(4));
        }
        return entity;
    }

    @Override
    public List<CreatorEntity> getAllEntities(ResultSet resultSet) throws SQLException {
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

    public List<CarEntity> getCreatorCars(ResultSet resultSet) throws SQLException{
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
}
