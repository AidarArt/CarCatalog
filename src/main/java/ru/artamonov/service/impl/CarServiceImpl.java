package ru.artamonov.service.impl;

import ru.artamonov.db.PostgreSQLConnectionManager;
import ru.artamonov.model.CarEntity;
import ru.artamonov.model.CreatorEntity;
import ru.artamonov.repository.impl.CarRepositoryImpl;
import ru.artamonov.repository.mapper.CarRepository;
import ru.artamonov.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {

    private final CarRepository repository = new CarRepositoryImpl(new PostgreSQLConnectionManager());
    private static final String NOT_FOUND_MESSAGE = "Car with id '%s' not found";
    private static final String NULL_ID_MESSAGE = "Car id cannot be null";
    private static final String NEGATIVE_ID_MESSAGE = "Car id cannot be negative";

    @Override
    public CarEntity findById(Long id) {
        if (id == null)
            throw new NullPointerException(NULL_ID_MESSAGE);
        if (id < 0)
            throw new IllegalArgumentException(NEGATIVE_ID_MESSAGE);
        if (existingId(id))
            return repository.findById(id);
        else
            throw new NullPointerException(String.format(NOT_FOUND_MESSAGE, id));
    }

    @Override
    public List<CarEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public CarEntity save(CarEntity carEntity) {
        if (carEntity.getCarModelName().isEmpty())
            throw new NullPointerException("Car model name cannot be empty");
        if (carEntity.getCarBrand() == null)
            throw new IllegalArgumentException("Car brand cannot be null");
        repository.insert(carEntity);
        return carEntity;
    }

    @Override
    public CarEntity update(CarEntity carEntity) {
        if (existingId(carEntity.getCarId())) {
            repository.update(carEntity.getCarId(), carEntity);
            return repository.findById(carEntity.getCarId());
        }
        throw new NullPointerException(String.format(NOT_FOUND_MESSAGE, carEntity.getCarId()));
    }

    @Override
    public void delete(Long carId) {
        if (carId == null)
            throw new NullPointerException(NULL_ID_MESSAGE);
        if (carId < 0)
            throw new IllegalArgumentException(NEGATIVE_ID_MESSAGE);
        if (existingId(carId))
            repository.remove(carId);
        else
            throw new NullPointerException(String.format(NOT_FOUND_MESSAGE, carId));
    }

    @Override
    public List<CreatorEntity> getCarCreators(Long carId) {
        if (carId == null)
            throw new NullPointerException(NULL_ID_MESSAGE);
        if (carId < 0)
            throw new IllegalArgumentException(NEGATIVE_ID_MESSAGE);
        if (existingId(carId))
            return repository.getCarCreators(carId);
        else
            throw new NullPointerException(String.format(NOT_FOUND_MESSAGE, carId));
    }

    private boolean existingId(Long id) {
        List<CarEntity> entities = repository.findAll();
        for (CarEntity entity : entities) {
            if (id.equals(entity.getCarId()))
                return true;
        }
        return false;
    }
}
