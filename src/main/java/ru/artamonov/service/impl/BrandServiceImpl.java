package ru.artamonov.service.impl;

import ru.artamonov.db.PostgreSQLConnectionManager;
import ru.artamonov.model.BrandEntity;
import ru.artamonov.model.CarEntity;
import ru.artamonov.repository.impl.BrandRepositoryImpl;
import ru.artamonov.repository.mapper.BrandRepository;
import ru.artamonov.service.BrandService;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    private final BrandRepository repository = new BrandRepositoryImpl(new PostgreSQLConnectionManager());
    private static final String NOT_FOUND_MESSAGE = "Brand with id '%s' not found";

    @Override
    public BrandEntity save(BrandEntity entity) {
        if (entity.getBrandName().isEmpty())
            throw new NullPointerException("Brand name cannot be empty");
        if (entity.getBrandCountry().isEmpty())
            throw new IllegalArgumentException("Brand country cannot be null");
        repository.insert(entity);
        return entity;
    }

    @Override
    public BrandEntity findById(Long id) {
        if (id == null)
            throw new NullPointerException("Brand id cannot be null");
        if (id < 0)
            throw new IllegalArgumentException("Brand id cannot be negative");
        if (existingId(id))
            return repository.findById(id);
        else
            throw new IllegalArgumentException(String.format(NOT_FOUND_MESSAGE, id));
    }

    @Override
    public List<BrandEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public BrandEntity update(BrandEntity entity) {
        if (existingId(entity.getBrandId())) {
            repository.update(entity.getBrandId(), entity);
            return repository.findById(entity.getBrandId());
        }
        throw new NullPointerException(String.format(NOT_FOUND_MESSAGE, entity.getBrandId()));
    }

    @Override
    public void delete(Long id) {
        if (existingId(id))
            repository.remove(id);
        else
            throw new NullPointerException(String.format(NOT_FOUND_MESSAGE, id));
    }

    @Override
    public List<CarEntity> getBrandCars(Long brandId) {
        if (existingId(brandId))
            return repository.getBrandCars(brandId);
        else
            throw new NullPointerException(String.format(NOT_FOUND_MESSAGE, brandId));
    }

    private boolean existingId(Long id) {
        List<BrandEntity> entities = repository.findAll();
        for (BrandEntity brand : entities) {
            if (id.equals(brand.getBrandId()))
                return true;
        }
        return false;
    }
}
