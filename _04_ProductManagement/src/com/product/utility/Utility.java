package com.product.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utility {

    public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String username = "jdbc";
    public static final String password = "password";

    public static Connection getConnection() throws SQLException {

        Connection conn = DriverManager.getConnection(url, username, password);

        conn.setAutoCommit(true);   // important for insert/update/delete

        return conn;
    }
}