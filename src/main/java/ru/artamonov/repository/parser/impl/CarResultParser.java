package ru.artamonov.repository.parser.impl;

import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.CarEntity;
import ru.artamonov.model.EngineEntity;
import ru.artamonov.model.enums.BodyType;
import ru.artamonov.model.enums.Country;
import ru.artamonov.model.enums.EngineType;
import ru.artamonov.model.enums.Transmission;
import ru.artamonov.repository.parser.ResultParser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarResultParser implements ResultParser<CarEntity> {
    @Override
    public CarEntity getEntity(ResultSet resultSet) throws SQLException {
        CarEntity carEntity = new CarEntity();

        while (resultSet.next()) {
            carEntity.setCarId(resultSet.getLong(1));
            carEntity.setCarModelName(resultSet.getString(2));

            BrandEntity brand = new BrandEntity();
            brand.setBrandId(resultSet.getLong(3));
            brand.setBrandName(resultSet.getString(10));
            brand.setBrandCountry(Country.valueOf(resultSet.getString(11)));
            carEntity.setCarBrand(brand);

            EngineEntity engine = new EngineEntity();
            engine.setEngineId(resultSet.getLong(4));

            BrandEntity engineBrand = new BrandEntity();
            engineBrand.setBrandId(resultSet.getLong(13));
            engineBrand.setBrandName(resultSet.getString(20));
            engineBrand.setBrandCountry(Country.valueOf(resultSet.getString(21)));

            engine.setBrand(engineBrand);
            engine.setEngineCapacity(resultSet.getDouble(14));
            engine.setEngineHorsePower(resultSet.getDouble(15));
            engine.setEngineCylindersNumber(resultSet.getInt(16));
            engine.setEngineConsumption(resultSet.getDouble(17));
            engine.setEngineType(EngineType.valueOf(resultSet.getString(18)));
            carEntity.setCarEngine(engine);

            carEntity.setCarAccelerationTo100(resultSet.getDouble(5));
            carEntity.setCarMaxSpeed(resultSet.getDouble(6));
            carEntity.setCarTransmission(Transmission.valueOf(resultSet.getString(7)));
            carEntity.setCarBodyType(BodyType.valueOf(resultSet.getString(8)));
        }

        return carEntity;
    }
}
