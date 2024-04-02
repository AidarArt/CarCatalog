package ru.artamonov.repository.parser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Class for converting rows received from the database into an entity
 * @param <T> entity class
 */
public interface ResultParser <T> {

    T getEntity(ResultSet resultSet) throws SQLException;

    List<T> getAllEntities(ResultSet resultSet) throws SQLException;
}
