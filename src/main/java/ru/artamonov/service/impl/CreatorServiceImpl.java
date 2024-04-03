package ru.artamonov.service.impl;

import ru.artamonov.db.PostgreSQLConnectionManager;
import ru.artamonov.model.CarEntity;
import ru.artamonov.model.CreatorEntity;
import ru.artamonov.repository.impl.CreatorRepositoryImpl;
import ru.artamonov.repository.mapper.CreatorRepository;
import ru.artamonov.service.CreatorService;

import java.util.List;

public class CreatorServiceImpl implements CreatorService {

    private final CreatorRepository repository = new CreatorRepositoryImpl(new PostgreSQLConnectionManager());
    private static final String NOT_FOUND_MESSAGE = "Creator with id '%s' not found";
    private static final String NULL_ID_MESSAGE = "Creator id cannot be null";
    private static final String NEGATIVE_ID_MESSAGE = "Creator id cannot be negative";

    @Override
    public CreatorEntity findById(Long id) {
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
    public List<CreatorEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public CreatorEntity save(CreatorEntity creatorEntity) {
        if (creatorEntity.getCreatorName().isEmpty())
            throw new NullPointerException("Creator name cannot be empty");
        if (creatorEntity.getCreatorSurname().isEmpty())
            throw new NullPointerException("Creator surname cannot be empty");
        if (creatorEntity.getCreatorProfession().isEmpty())
            throw new NullPointerException("Creator profession cannot be empty");
        repository.insert(creatorEntity);
        return creatorEntity;
    }

    @Override
    public CreatorEntity update(CreatorEntity creatorEntity) {
        if (existingId(creatorEntity.getCreatorId())) {
            repository.update(creatorEntity.getCreatorId(), creatorEntity);
            return repository.findById(creatorEntity.getCreatorId());
        }
        throw new NullPointerException(String.format(NOT_FOUND_MESSAGE, creatorEntity.getCreatorId()));
    }

    @Override
    public void delete(Long creatorId) {
        if (creatorId == null)
            throw new NullPointerException(NULL_ID_MESSAGE);
        if (creatorId < 0)
            throw new IllegalArgumentException(NEGATIVE_ID_MESSAGE);
        if (existingId(creatorId))
            repository.remove(creatorId);
        else
            throw new NullPointerException(String.format(NOT_FOUND_MESSAGE, creatorId));
    }

    @Override
    public List<CarEntity> getCreatorCars(Long creatorId) {
        if (creatorId == null)
            throw new NullPointerException(NULL_ID_MESSAGE);
        if (creatorId < 0)
            throw new IllegalArgumentException(NEGATIVE_ID_MESSAGE);
        if (existingId(creatorId))
            return  repository.getCreatorCars(creatorId);
        else
            throw new NullPointerException(String.format(NOT_FOUND_MESSAGE, creatorId));
    }

    private boolean existingId(Long id) {
        List<CreatorEntity> entities = repository.findAll();
        for (CreatorEntity entity : entities) {
            if (id.equals(entity.getCreatorId()))
                return true;
        }
        return false;
    }
}
