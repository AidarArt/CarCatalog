package ru.artamonov.service;

import ru.artamonov.model.BrandEntity;

import java.util.List;

public interface BrandService {

    BrandEntity save(BrandEntity entity);
    BrandEntity findById(Long id);
    List<BrandEntity> findAll();
    BrandEntity update(BrandEntity entity);
    void delete(Long id);
}
