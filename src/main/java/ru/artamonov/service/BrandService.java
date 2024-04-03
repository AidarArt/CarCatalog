package ru.artamonov.service;

import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.CarEntity;

import java.util.List;

public interface BrandService {

    BrandEntity save(BrandEntity entity);
    BrandEntity findById(Long id);
    List<BrandEntity> findAll();
    BrandEntity update(BrandEntity entity);
    void delete(Long id);
    List<CarEntity> getBrandCars(Long brandId);
}
