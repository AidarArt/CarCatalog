package ru.artamonov.service.impl;

import ru.artamonov.db.PostgreSQLConnectionManager;
import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.CarEntity;
import ru.artamonov.repository.impl.BrandRepositoryImpl;
import ru.artamonov.repository.impl.CarRepositoryImpl;
import ru.artamonov.repository.impl.EngineRepositoryImpl;
import ru.artamonov.repository.mapper.BrandRepository;
import ru.artamonov.repository.mapper.CarRepository;
import ru.artamonov.repository.mapper.EngineRepository;
import ru.artamonov.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {

    private final CarRepository carRepository = new CarRepositoryImpl(new PostgreSQLConnectionManager());
    private final BrandRepository brandRepository = new BrandRepositoryImpl(new PostgreSQLConnectionManager());
    @Override
    public CarEntity findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public List<CarEntity> findAll() {
        return carRepository.findAll();
    }

    @Override
    public CarEntity save(CarEntity carEntity) {
        String engBrandName = carEntity.getCarBrand().getBrandName();
        String carBrandName = carEntity.getCarBrand().getBrandName();
        Long engBrandId = brandRepository.findByName(engBrandName);
        Long carBrandId = brandRepository.findByName(carBrandName);

        if (engBrandId != -1)
            carEntity.getCarEngine().setBrand(brandRepository.findById(engBrandId));
        else
            brandRepository.insert(carEntity.getCarEngine().getBrand());

        if (carBrandId != -1)
            carEntity.setCarBrand(brandRepository.findById(carBrandId));
        else
            brandRepository.insert(carEntity.getCarBrand());

        if (carEntity.getCarModelName().equals(""))
            throw new IllegalArgumentException();


        carRepository.insert(carEntity);
        return carEntity;
    }

    @Override
    public CarEntity update(CarEntity carEntity) {
        carRepository.update(carEntity.getCarId(), carEntity);
        return carRepository.findById(carEntity.getCarId());
    }

    @Override
    public void delete(Long carId) {
        carRepository.remove(carId);
    }
}
