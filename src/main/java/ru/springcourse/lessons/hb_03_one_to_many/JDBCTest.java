package ru.springcourse.lessons.hb_03_one_to_many;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false&serverTimezone=UTC";
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
