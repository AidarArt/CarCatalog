package ru.artamonov.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnectionManager implements ConnectionManager{
    @Override
    public Connection getConnection() throws SQLException {
        try {
            String jdbcUrl = DBConfig.getUrl();
            String username = DBConfig.getUsername();
            String password = DBConfig.getPassword();

            return DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
