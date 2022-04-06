package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/CS?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "1225";

    public static Connection connection;

    public static Connection getConnection(){
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }


}
