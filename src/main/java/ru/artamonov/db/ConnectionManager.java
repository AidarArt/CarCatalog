package ru.artamonov.db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classes that implement this interface can be used to obtain a connection to the database
 */
public interface ConnectionManager {
    Connection getConnection() throws SQLException;
}
