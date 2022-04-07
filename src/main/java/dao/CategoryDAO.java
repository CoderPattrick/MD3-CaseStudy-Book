package dao;

import model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO implements DAO<Category> {
    public static final String getAllCategorySQL = "select * from theloai;";

    @Override
    public ArrayList<Category> getAll() throws SQLException {
        ArrayList<Category> list = new ArrayList<>();
        PreparedStatement pS = connection.prepareStatement(getAllCategorySQL);
        ResultSet rS = pS.executeQuery();
        while (rS.next()){
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
        return false;
    }

    @Override
    public boolean editRecord(Category object) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteRecord(int id) throws SQLException {
        return false;
    }
}
