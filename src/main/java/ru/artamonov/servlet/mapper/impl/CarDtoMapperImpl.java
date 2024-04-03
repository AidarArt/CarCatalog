package ru.artamonov.servlet.mapper.impl;

import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.CarEntity;
import ru.artamonov.model.CreatorEntity;
import ru.artamonov.servlet.dto.BrandOutGoingDto;
import ru.artamonov.servlet.dto.CarIncomingDto;
import ru.artamonov.servlet.dto.CarOutGoingDto;
import ru.artamonov.servlet.dto.CreatorOutGoingDto;
import ru.artamonov.servlet.mapper.CarDtoMapper;

import java.util.ArrayList;
import java.util.List;

public class CarDtoMapperImpl implements CarDtoMapper {
    @Override
    public CarEntity map(CarIncomingDto incomingDto) {
        CarEntity entity = new CarEntity();
        entity.setCarId(incomingDto.getId());
        entity.setCarModelName(incomingDto.getModel());
        entity.setCarBrand(new BrandEntity());
        entity.getCarBrand().setBrandId(incomingDto.getBrandId());
        return entity;
    }

    @Override
    public CarOutGoingDto map(CarEntity entity) {
        CarOutGoingDto dto = new CarOutGoingDto();
        dto.setModel(entity.getCarModelName());
        dto.setBrand(new BrandOutGoingDto());
        dto.getBrand().setName(entity.getCarBrand().getBrandName());
        dto.getBrand().setCountry(entity.getCarBrand().getBrandCountry());
        List<CreatorOutGoingDto> creators = new ArrayList<>();
        for (CreatorEntity creatorEntity : entity.getCarCreators()) {
            CreatorOutGoingDto creatorDto = new CreatorOutGoingDto();
            creatorDto.setName(creatorEntity.getCreatorName());
            creatorDto.setSurname(creatorEntity.getCreatorSurname());
            creatorDto.setProfession(creatorEntity.getCreatorProfession());
            creators.add(creatorDto);
        }
        dto.setCreators(creators);
        return dto;
    }
}
