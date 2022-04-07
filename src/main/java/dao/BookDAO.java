package dao;

import model.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;



public class BookDAO implements DAO<Book> {

    @Override
    public ArrayList<Book> getAll() throws SQLException {
        return null;
    }

    @Override
    public Book getById(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean insertIntoDB(Book object) throws SQLException {
        return false;
    }

    @Override
    public boolean editRecord(Book object) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteRecord(int id) throws SQLException {
        return false;

    }
}
