package ru.artamonov.repository.mapper;

import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.CarEntity;

import java.util.List;

public interface BrandRepository extends Repository<BrandEntity, Long> {
    List<CarEntity> getBrandCars(Long brandId);
}
