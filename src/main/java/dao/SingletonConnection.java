package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    public static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/cs";
    private static String user = "root";
    private static String pass = "123456";

    public static void main(String[] args) {
        getConnection();
    }
    public static Connection getConnection()  {
        if(connection==null){

            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url,user,pass);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("success!");
        }
        return connection;
    }
}