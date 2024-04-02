package ru.artamonov.servlet.mapper;

import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.enums.Country;
import ru.artamonov.servlet.dto.BrandIncomingDto;
import ru.artamonov.servlet.dto.BrandOutGoingDto;

public class BrandDtoMapperImpl implements BrandDtoMapper{
    @Override
    public BrandEntity map(BrandIncomingDto incomingDto) {
        Long id = Long.valueOf(incomingDto.getId());
        String name = incomingDto.getName();
        Country country = Country.valueOf(incomingDto.getCountry().toUpperCase());
        return new BrandEntity(id, name, country);
    }

    @Override
    public BrandOutGoingDto map(BrandEntity brandEntity) {
        String id = brandEntity.getBrandId().toString();
        String name = brandEntity.getBrandName();
        String country = brandEntity.getBrandCountry().name();
        return new BrandOutGoingDto(id, name, country);
    }
}
