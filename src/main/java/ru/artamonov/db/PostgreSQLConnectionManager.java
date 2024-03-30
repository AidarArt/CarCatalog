package ru.artamonov.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Конкретная реализация менеджера, единственный метод создает и возвращает Connection
 */
public class PostgreSQLConnectionManager implements ConnectionManager{
    @Override
    public Connection getConnection() throws SQLException {
            String jdbcUrl = DBConfig.getUrl();
            String username = DBConfig.getUsername();
            String password = DBConfig.getPassword();

            return DriverManager.getConnection(jdbcUrl, username, password);
    }
}
