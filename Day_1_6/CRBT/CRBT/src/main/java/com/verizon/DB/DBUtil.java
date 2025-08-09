package com.verizon.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static DBUtil instance;
    private Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/telecom";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    private DBUtil() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static DBUtil getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DBUtil();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}