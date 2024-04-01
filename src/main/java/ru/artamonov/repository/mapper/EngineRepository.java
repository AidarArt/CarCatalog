package ru.artamonov.repository.mapper;

import ru.artamonov.model.CarEntity;
import ru.artamonov.model.EngineEntity;

import java.util.List;

public interface EngineRepository extends Repository<EngineEntity, Long> {
    List<CarEntity> getEngineCars(Long engineId);
}
