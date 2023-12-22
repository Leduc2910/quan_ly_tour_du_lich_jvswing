package service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToMySQL {
    static final String URL = "jdbc:mysql://localhost:3306/tour_du_lich";
    static final String USERNAME = "root";
    static final String PASSWORD = "123456";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            return null;
        }
    }
}
