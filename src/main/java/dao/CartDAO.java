package dao;

import model.Author;
import model.Cart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartDAO implements DAO<Cart> {
    public static final String SELECT_ALL_CART = "select * from giohang;";

    @Override
    public ArrayList<Cart> getAll() throws SQLException {
        ArrayList<Author> list = new ArrayList<>();
        PreparedStatement pS = connection.prepareStatement(SELECT_ALL_CART);
        ResultSet rS = pS.executeQuery();
        while (rS.next()) {

            list.add(new Author());
        }

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
