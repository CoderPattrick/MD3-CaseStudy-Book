package dao;

import model.Author;
import model.Book;
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
    public static final String DELETE_CATEGORY_BOOK = "delete from sach_theloai where idTheLoai = ?;";
    public static final String EDIT_CATEGORY= "update theloai set ten = ? where id = ?";
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
    public boolean insertIntoDB(Category category) throws SQLException {
        boolean rowUpdate;
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(INSERT_CATEGORY);
        preparedStatement.setString(1, category.getName());
        rowUpdate = preparedStatement.execute();
        return rowUpdate;
    }

    @Override
    public boolean editRecord(Category category) throws SQLException {
        boolean rowUpdated;

        try (PreparedStatement statement = connection.prepareStatement(EDIT_CATEGORY)) {
            statement.setString(1, category.getName());
            statement.setInt(2,category.getId());
            rowUpdated = statement.execute();
        }
        return rowUpdated;
    }


    @Override
    public boolean deleteRecord(int id) throws SQLException {
        PreparedStatement pS = connection.prepareStatement(DELETE_CATEGORY_BOOK);
        PreparedStatement pS2 = connection.prepareStatement(DELETE_CATEGORY);

        pS.setInt(1,id);
        pS2.setInt(1,id);
        pS.execute();
        pS2.execute();

        return true;
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


