package org.example;

import java.sql.*;

public class DbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/javaproject";
    private static final String userName = "root";
    private static final String password = "Prasanna0606@";

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL,userName,password);
    }
}
