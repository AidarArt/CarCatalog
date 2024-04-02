package ru.artamonov.repository.parser.impl;

import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.enums.Country;
import ru.artamonov.repository.parser.ResultParser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandResultParser implements ResultParser<BrandEntity> {
    @Override
    public BrandEntity getEntity(ResultSet resultSet) throws SQLException {
        BrandEntity brandEntity = new BrandEntity();

        while (resultSet.next()) {
            brandEntity.setBrandId(resultSet.getLong(1));
            brandEntity.setBrandName(resultSet.getString(2));
            brandEntity.setBrandCountry(Country.valueOf(resultSet.getString(3)));
        }

        return brandEntity;
    }

    public List<BrandEntity> getAllEntities(ResultSet resultSet) throws SQLException {
        List<BrandEntity> entities = new ArrayList<>();

        while (resultSet.next()) {
            BrandEntity brand = new BrandEntity();
            brand.setBrandId(resultSet.getLong(1));
            brand.setBrandName(resultSet.getString(2));
            brand.setBrandCountry(Country.valueOf(resultSet.getString(3)));
            entities.add(brand);
        }
        return entities;
    }
}
