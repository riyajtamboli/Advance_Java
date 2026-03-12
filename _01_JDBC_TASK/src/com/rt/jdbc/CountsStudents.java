package com.rt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CountsStudents {

    public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String username = "jdbc";
    public static final String password = "password";

    public static void main(String[] args) {

        String query = """
                SELECT COUNT(*) 
                FROM student_info
                WHERE STD_PERCENTAGE > 80
                """;

        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        ) {

            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Students with > 80% : " + count);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}