package ru.artamonov.db;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Implementation for obtaining a postgreSQL database connection
 */
public class PostgreSQLConnectionManager implements ConnectionManager{
    @Override
    public Connection getConnection() throws SQLException {
            String jdbcUrl = DBConfig.getUrl();
            String username = DBConfig.getUsername();
            String password = DBConfig.getPassword();
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(jdbcUrl, username, password);
    }
}
