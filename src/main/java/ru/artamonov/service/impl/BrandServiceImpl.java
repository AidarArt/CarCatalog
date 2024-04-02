package ru.artamonov.service.impl;

import ru.artamonov.db.PostgreSQLConnectionManager;
import ru.artamonov.model.BrandEntity;
import ru.artamonov.repository.impl.BrandRepositoryImpl;
import ru.artamonov.repository.mapper.BrandRepository;
import ru.artamonov.service.BrandService;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository = new BrandRepositoryImpl(new PostgreSQLConnectionManager());

    @Override
    public BrandEntity save(BrandEntity brandEntity) {
        if (brandEntity.getBrandName().equals(""))
            throw new NullPointerException("Name does not be empty");
        if (brandEntity.getBrandCountry().name().equals(""))
            throw new NullPointerException("Country does not be empty");

        brandRepository.insert(brandEntity);
        return brandEntity;
    }

    @Override
    public BrandEntity findById(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Id does not be empty");
        return brandRepository.findById(id);
    }

    @Override
    public List<BrandEntity> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public BrandEntity update(BrandEntity entity) {
        brandRepository.update(entity.getBrandId(), entity);
        return brandRepository.findById(entity.getBrandId());
    }

    @Override
    public void delete(Long id) {
        if (id < 0)
            throw new IllegalArgumentException("Not found");
        brandRepository.remove(id);
    }
}
