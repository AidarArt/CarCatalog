package ru.artamonov.repository.mapper;

import ru.artamonov.model.CarEntity;
import ru.artamonov.model.CreatorEntity;

import java.util.List;

public interface CarRepository extends Repository<CarEntity, Long> {
    List<CreatorEntity> getCarCreators(Long carId);
}
