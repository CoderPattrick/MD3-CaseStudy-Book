package dao;

import model.Author;
import model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO implements DAO<Category> {
    public static final String getAllCategorySQL = "select * from theloai;";
    public static final String Get_By_ID = "SELECT *FROM tacgia WHERE id =?";

    @Override
    public ArrayList<Category> getAll() throws SQLException {
        ArrayList<Category> list = new ArrayList<>();
        PreparedStatement pS = connection.prepareStatement(getAllCategorySQL);
        ResultSet rS = pS.executeQuery();
        while (rS.next()) {
            int id = rS.getInt("id");
            String name = rS.getString("ten");
            list.add(new Category(id,name));
        }
        return list;
    }

    @Override
    public Category getById(int id) throws SQLException {
        Category newCatogory = null;
        try (
                PreparedStatement statement = connection.prepareStatement(Get_By_ID)
        ) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("ten");
                newCatogory = new Category(id, name);
            }
        }
        return newCatogory;
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
    public static ArrayList<Category> findAllByBookId(int id){
        ArrayList<Category> categories =new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement("SELECT id, ten FROM theloai join sach_theloai st on theloai.id = st.idTheLoai where idSach =?;");
        ){
            statement.setInt(1,id);
            ResultSet resultSet =statement.executeQuery();
            while (resultSet.next()){
                int idC = resultSet.getInt("id");
                String name = resultSet.getString("ten");
                categories.add(new Category(idC,name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}


