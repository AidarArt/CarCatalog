package ru.artamonov.servlet.mapper;


import ru.artamonov.model.CarEntity;
import ru.artamonov.servlet.dto.CarIncomingDto;
import ru.artamonov.servlet.dto.CarOutGoingDto;

public interface CarDtoMapper {
    CarEntity map(CarIncomingDto incomingDto);
    CarOutGoingDto map(CarEntity brandEntity);
}
