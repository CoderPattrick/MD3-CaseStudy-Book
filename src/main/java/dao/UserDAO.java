package dao;

import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements DAO<User> {

    public static final String SELECT_FROM_USERS_WHERE_ID = "SELECT *FROM users WHERE id=?";

    @Override
    public ArrayList<User> getAll() throws SQLException {
        return null;
    }

    @Override
    public User getById(int id) throws SQLException {
        User user = null;
        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_FROM_USERS_WHERE_ID)
        ) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int idU = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String acc = resultSet.getString("acc");
                String pass = resultSet.getString("pass");
                Boolean role = resultSet.getBoolean("role");
                user=new User(id,name,acc,pass,role);
            }
        }
        return user;
    }

    @Override
    public boolean insertIntoDB(User object) throws SQLException {
        return false;
    }

    @Override
    public boolean editRecord(User object) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteRecord(int id) throws SQLException {
        return false;
    }
}
