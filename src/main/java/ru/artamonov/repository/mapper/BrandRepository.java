package ru.artamonov.repository.mapper;

import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.CarEntity;
import ru.artamonov.model.EngineEntity;

import java.util.List;

public interface BrandRepository extends Repository<BrandEntity, Long> {
    List<EngineEntity> getBrandEngines(Long brandId);
    List<CarEntity> getBrandCars(Long brandId);
    Long findByName(String name);
}
