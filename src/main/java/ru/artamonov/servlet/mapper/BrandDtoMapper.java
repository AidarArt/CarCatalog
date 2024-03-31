package ru.artamonov.servlet.mapper;

import ru.artamonov.model.BrandEntity;
import ru.artamonov.servlet.dto.BrandIncomingDto;
import ru.artamonov.servlet.dto.BrandOutGoingDto;

public interface BrandDtoMapper {
    BrandEntity map(BrandIncomingDto incomingDto);
    BrandOutGoingDto map(BrandEntity brandEntity);
}
