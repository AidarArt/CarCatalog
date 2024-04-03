package ru.artamonov.service;

import ru.artamonov.model.CarEntity;
import ru.artamonov.model.CreatorEntity;

import java.util.List;

public interface CreatorService {
    CreatorEntity findById(Long id);
    List<CreatorEntity> findAll();
    CreatorEntity save(CreatorEntity creatorEntity);
    CreatorEntity update(CreatorEntity creatorEntity);
    void delete(Long creatorId);
    List<CarEntity> getCreatorCars(Long creatorId);
}
