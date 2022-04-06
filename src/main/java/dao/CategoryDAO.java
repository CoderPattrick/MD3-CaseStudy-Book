package dao;

import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.SingletonConnection.getConnection;

public class CategoryDAO implements DAO<Category> {
    public static final String getAllCategorySQL = "select * from theloai;";
    public static final String INSERT_CATEGORY = "insert into theloai(ten) value(?);";
    public static final String DELETE_CATEGORY = "delete from theloai where id = ?;";
    public static final String EDIT_CATEGORY= "update theloai set ten = ? where id = ?";

    @Override
    public ArrayList<Category> getAll() throws SQLException {
        ArrayList<Category> list = new ArrayList<>();
        PreparedStatement pS = connection.prepareStatement(getAllCategorySQL);
        ResultSet rS = pS.executeQuery();
        while (rS.next()) {
            String name = rS.getString("ten");
            list.add(new Category(name));
        }
        return list;
    }

    @Override
    public Category getById(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean insertIntoDB(Category object) throws SQLException {

            System.out.println(INSERT_CATEGORY);
            // try-with-resource statement will auto close the connection.
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY)) {
                preparedStatement.setString(1, object.getName());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            }
        return false;
    }

    @Override
    public boolean editRecord(Category object) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(EDIT_CATEGORY);) {
            statement.setString(1, object.getName());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }


    @Override
    public boolean deleteRecord(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;

    }
}



