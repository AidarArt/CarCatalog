package ru.artamonov.db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Интерфейс реализация которого предоставляет Connection
 */
public interface ConnectionManager {
    Connection getConnection() throws SQLException;
}
