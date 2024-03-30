package ru.artamonov.repository.parser;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for converting rows received from the database into an entity
 * @param <T> entity class
 */
public interface ResultParser <T> {

    T getEntity(ResultSet resultSet) throws SQLException;
}
