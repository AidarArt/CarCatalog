package ru.artamonov.servlet.mapper;

import ru.artamonov.model.CreatorEntity;
import ru.artamonov.servlet.dto.CreatorIncomingDto;
import ru.artamonov.servlet.dto.CreatorOutGoingDto;

public interface CreatorDtoMapper {
    CreatorEntity map(CreatorIncomingDto incomingDto);
    CreatorOutGoingDto map(CreatorEntity entity);
}
