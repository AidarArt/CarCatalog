package ru.artamonov.repository.parser.impl;

import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.EngineEntity;
import ru.artamonov.model.enums.Country;
import ru.artamonov.model.enums.EngineType;
import ru.artamonov.repository.parser.ResultParser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EngineResultParser implements ResultParser<EngineEntity> {
    @Override
    public EngineEntity getEntity(ResultSet resultSet) throws SQLException {
        EngineEntity engineEntity = new EngineEntity();

        while (resultSet.next()) {
            engineEntity.setEngineId(resultSet.getLong(1));

            BrandEntity engineBrand = new BrandEntity();
            engineBrand.setBrandId(resultSet.getLong(2));
            engineBrand.setBrandName(resultSet.getString(9));
            engineBrand.setBrandCountry(Country.valueOf(resultSet.getString(10)));

            engineEntity.setBrand(engineBrand);
            engineEntity.setEngineCapacity(resultSet.getDouble(3));
            engineEntity.setEngineHorsePower(resultSet.getDouble(4));
            engineEntity.setEngineCylindersNumber(resultSet.getInt(5));
            engineEntity.setEngineConsumption(resultSet.getDouble(6));
            engineEntity.setEngineType(EngineType.valueOf(resultSet.getString(7)));
        }

        return engineEntity;
    }

    @Override
    public List<EngineEntity> getAllEntities(ResultSet resultSet) throws SQLException {
        List<EngineEntity> entities = new ArrayList<>();

        while (resultSet.next()) {
            EngineEntity engineEntity = new EngineEntity();

            engineEntity.setEngineId(resultSet.getLong(1));

            BrandEntity engineBrand = new BrandEntity();
            engineBrand.setBrandId(resultSet.getLong(2));
            engineBrand.setBrandName(resultSet.getString(9));
            engineBrand.setBrandCountry(Country.valueOf(resultSet.getString(10)));

            engineEntity.setBrand(engineBrand);
            engineEntity.setEngineCapacity(resultSet.getDouble(3));
            engineEntity.setEngineHorsePower(resultSet.getDouble(4));
            engineEntity.setEngineCylindersNumber(resultSet.getInt(5));
            engineEntity.setEngineConsumption(resultSet.getDouble(6));
            engineEntity.setEngineType(EngineType.valueOf(resultSet.getString(7)));
            entities.add(engineEntity);
        }

        return entities;
    }
}
