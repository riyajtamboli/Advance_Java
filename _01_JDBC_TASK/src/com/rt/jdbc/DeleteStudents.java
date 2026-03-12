package com.rt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStudents {

    public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String username = "jdbc";
    public static final String password = "password";

    public static void main(String[] args) {

        String deleteQuery = """
                DELETE FROM student_info
                WHERE STD_PERCENTAGE BETWEEN 30 AND 60
                """;

        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = conn.prepareStatement(deleteQuery);
        ) {

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(rows + " Students Deleted");
            } else {
                System.out.println("No Student Found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}