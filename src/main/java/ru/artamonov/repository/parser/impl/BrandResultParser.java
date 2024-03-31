package ru.artamonov.repository.parser.impl;

import ru.artamonov.model.BrandEntity;
import ru.artamonov.repository.parser.ResultParser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandResultParser implements ResultParser<BrandEntity> {
    @Override
    public BrandEntity getEntity(ResultSet resultSet) throws SQLException {
        BrandEntity brandEntity = new BrandEntity();



        return brandEntity;
    }
}
