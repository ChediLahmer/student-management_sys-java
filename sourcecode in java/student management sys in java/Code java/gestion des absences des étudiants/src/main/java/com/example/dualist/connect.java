package com.example.dualist;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 class connect {
    public static Connection bdConnection() throws SQLException {
        String DB_URL = "jdbc:sqlserver://LAPTOP-J1MNDHDK;databaseName=studentmanagementsys;integratedSecurity=true;trustServerCertificate=true";
        Connection connection = DriverManager.getConnection(DB_URL);
        if (connection != null) {
            System.out.println("Connected to SQL Server successfully.");
        }
        return connection;
    }
}
