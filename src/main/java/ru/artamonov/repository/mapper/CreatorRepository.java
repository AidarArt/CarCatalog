package ru.artamonov.repository.mapper;

import ru.artamonov.model.CarEntity;
import ru.artamonov.model.CreatorEntity;

import java.util.List;

public interface CreatorRepository extends Repository<CreatorEntity, Long> {
    List<CarEntity> getCreatorCars(Long creatorId);
}
