package ru.artamonov.service;

import ru.artamonov.model.CarEntity;

import java.util.List;

public interface CarService {

    CarEntity findById(Long id);
    List<CarEntity> findAll();
    CarEntity save(CarEntity carEntity);
    CarEntity update(CarEntity carEntity);
    void delete(Long carId);
}
