package ru.springcourse.lessons.hb_04_one_to_many_uni;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-04-one-to-many-uni?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String password = "hbstudent";
        try {
            System.out.println("starting connection");
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("connected successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
