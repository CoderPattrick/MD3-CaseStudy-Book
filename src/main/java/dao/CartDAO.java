package dao;

import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CartDAO implements DAO<Cart> {
    public static final String SELECT_ALL_CART = "select * from giohang;";

    @Override
    public ArrayList<Cart> getAll() throws SQLException {
        return null;
    }

    @Override
    public Cart getById(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean insertIntoDB(Cart object) throws SQLException {
        return false;
    }

    @Override
    public boolean editRecord(Cart object) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteRecord(int id) throws SQLException {
        return false;
    }
}
