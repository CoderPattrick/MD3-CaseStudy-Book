package dao;

import model.Author;
import model.Cart;
import model.User;
import model.*;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CartDAO implements DAO<Cart> {
    public static final String SELECT_ALL_CART = "select * from giohang;";
    UserDAO userDAO = new UserDAO();

    @Override
    public ArrayList<Cart> getAll() throws SQLException {
        ArrayList<Cart> list = new ArrayList<>();
        PreparedStatement pS = connection.prepareStatement(SELECT_ALL_CART);
        ResultSet rS = pS.executeQuery();
        while (rS.next()) {
            int id = rS.getInt("id");
            String cartCode = rS.getString("cartCode");
            String date =rS.getString("orderDate");
            int idCustomer = rS.getInt("id_khach");
            User user= userDAO.getById(idCustomer);
            Cart cart = new Cart(cartCode,date,user);
            list.add(cart);
        }

        return list;
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
