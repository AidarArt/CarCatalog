package ru.artamonov.servlet.mapper;

import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.CarEntity;
import ru.artamonov.model.CreatorEntity;
import ru.artamonov.model.EngineEntity;
import ru.artamonov.model.enums.BodyType;
import ru.artamonov.model.enums.Country;
import ru.artamonov.model.enums.EngineType;
import ru.artamonov.model.enums.Transmission;
import ru.artamonov.servlet.dto.CarIncomingDto;
import ru.artamonov.servlet.dto.CarOutGoingDto;

import java.util.ArrayList;
import java.util.List;

public class CarDtoMapperImpl implements CarDtoMapper{
    @Override
    public CarEntity map(CarIncomingDto incomingDto) {
        CarEntity entity = new CarEntity();

        entity.setCarModelName(incomingDto.getCarModelName());
        entity.setCarBodyType(BodyType.valueOf(incomingDto.getCarBodyType().toUpperCase()));
        entity.setCarTransmission(Transmission.valueOf(incomingDto.getCarTransmission().toUpperCase()));
        entity.setCarMaxSpeed(Double.parseDouble(incomingDto.getCarMaxSpeed()));
        entity.setCarAccelerationTo100(Double.parseDouble(incomingDto.getCarAccelerationTo100()));
        BrandEntity carBrand = new BrandEntity();
        carBrand.setBrandName(incomingDto.getBrandName());
        carBrand.setBrandCountry(Country.valueOf(incomingDto.getBrandCountry().toUpperCase()));
        entity.setCarBrand(carBrand);

        BrandEntity engBrand = new BrandEntity();
        engBrand.setBrandName(incomingDto.getEngineBrand());
        engBrand.setBrandCountry(Country.valueOf(incomingDto.getEngineBrandCountry().toUpperCase()));

        EngineEntity engine = new EngineEntity();
        engine.setBrand(engBrand);
        engine.setEngineConsumption(Double.parseDouble(incomingDto.getEngineConsumption()));
        engine.setEngineType(EngineType.valueOf(incomingDto.getEngineType().toUpperCase()));
        engine.setEngineCylindersNumber(Integer.parseInt(incomingDto.getEngineCylindersNumber()));
        engine.setEngineHorsePower(Double.parseDouble(incomingDto.getEngineHorsePower()));
        engine.setEngineCapacity(Double.parseDouble(incomingDto.getEngineCapacity()));

        entity.setCarEngine(engine);

        return entity;
    }

    @Override
    public CarOutGoingDto map(CarEntity carEntity) {
        CarOutGoingDto outGoingDto = new CarOutGoingDto();

        outGoingDto.setCarBrand(carEntity.getCarBrand().toString());
        outGoingDto.setCarModelName(carEntity.getCarModelName());
        outGoingDto.setCarEngine(carEntity.getCarEngine().toString());
        outGoingDto.setCarAccelerationTo100(String.valueOf(carEntity.getCarAccelerationTo100()));
        outGoingDto.setCarMaxSpeed(String.valueOf(carEntity.getCarMaxSpeed()));
        outGoingDto.setCarTransmission(carEntity.getCarTransmission().name());
        outGoingDto.setCarBodyType(carEntity.getCarBodyType().name());

        return outGoingDto;
    }
}
