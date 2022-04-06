package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<T> {
    public static Connection connection = SingletonConnection.getConnection();

    ArrayList<T> getAll() throws SQLException;
    T getById(int id)throws SQLException;
    boolean insertIntoDB(T object)throws SQLException;
    boolean editRecord(T object)throws SQLException;
    boolean deleteRecord(int id)throws SQLException;
}
