package ru.artamonov.repository.parser.impl;

import ru.artamonov.model.CreatorEntity;
import ru.artamonov.repository.parser.ResultParser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreatorResultParser implements ResultParser<CreatorEntity> {
    @Override
    public CreatorEntity getEntity(ResultSet resultSet) throws SQLException {
        CreatorEntity creatorEntity = new CreatorEntity();

        while (resultSet.next()) {
            creatorEntity.setCreatorId(resultSet.getLong(1));
            creatorEntity.setCreatorName(resultSet.getString(2));
            creatorEntity.setCreatorSurname(resultSet.getString(3));
            creatorEntity.setCreatorProfession(resultSet.getString(4));
        }

        return creatorEntity;
    }

    @Override
    public List<CreatorEntity> getAllEntities(ResultSet resultSet) throws SQLException {
        List<CreatorEntity> entities = new ArrayList<>();

        while (resultSet.next()) {
            CreatorEntity creatorEntity = new CreatorEntity();
            creatorEntity.setCreatorId(resultSet.getLong(1));
            creatorEntity.setCreatorName(resultSet.getString(2));
            creatorEntity.setCreatorSurname(resultSet.getString(3));
            creatorEntity.setCreatorProfession(resultSet.getString(4));
            entities.add(creatorEntity);
        }

        return entities;
    }
}
