package dao;

import model.Author;
import model.Cart;
import model.User;
import model.*;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CartDAO implements DAO<Cart> {
    public static final String SELECT_ALL_CART = "select * from giohang;";
    public static final String ADD_NEW_CART = "INSERT INTO giohang (cartCode, orderDate, id_khach) VALUES (?,?,?);";
    public static final String ADD_NEW_CART_DETAIL = "INSERT INTO chitietgiohang(id_giohang, id_sach, soLuongSach) VALUES (?,?,?);";
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
    public boolean insertIntoDB(Cart object) {
        int idCart=0;
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_NEW_CART, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, object.getCartCode());
            statement.setString(2,object.getOrderDateTime());
            statement.setInt(3,object.getUser().getId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                idCart = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean editRecord(Cart object) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteRecord(int id) throws SQLException {
        return false;
    }
    public void insertBookToCart (int idCart){

    }
}
