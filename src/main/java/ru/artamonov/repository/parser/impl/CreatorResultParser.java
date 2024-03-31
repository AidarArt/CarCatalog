package ru.artamonov.repository.parser.impl;

import ru.artamonov.model.CreatorEntity;
import ru.artamonov.repository.parser.ResultParser;

import java.sql.ResultSet;
import java.sql.SQLException;

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
}
