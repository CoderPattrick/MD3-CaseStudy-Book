package dao;

import model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {
    public static Connection connection = SingletonConnection.getConnection();
    public static final String getAllAuthorSQL = "select * from tacgia;";
    public static final String getAllCategorySQL = "select * from theloai;";
    public static final String getAuthorSQLByName = "select * from tacgia where ten = ?";


    public ArrayList<Author> getAllAuthor() throws SQLException {
        ArrayList<Author> list = new ArrayList<>();
        PreparedStatement pS = connection.prepareStatement(getAllAuthorSQL);
        ResultSet rS = pS.executeQuery();
        while (rS.next()){
            String name = rS.getString("ten");
            int yearOfBirth = rS.getInt("namSinh");
            int yearOfDeath = rS.getInt("namMat");
            int numberOfBook = rS.getInt("soTacPham");
            String country = rS.getString("quocTich");
            String wikiURL = rS.getString("linkWiki");
            String avatarURL = rS.getString("avatar");
            list.add(new Author(name,yearOfBirth,yearOfDeath,numberOfBook,country,wikiURL,avatarURL));
        }
    return list;
    }
    public ArrayList<Author> getAllCategory() throws SQLException {
        ArrayList<Author> list = new ArrayList<>();
        PreparedStatement pS = connection.prepareStatement(getAllAuthorSQL);
        ResultSet rS = pS.executeQuery();
        while (rS.next()){
            String name = rS.getString("ten");
            int yearOfBirth = rS.getInt("namSinh");
            int yearOfDeath = rS.getInt("namMat");
            int numberOfBook = rS.getInt("soTacPham");
            String country = rS.getString("quocTich");
            String wikiURL = rS.getString("linkWiki");
            String avatarURL = rS.getString("avatar");
            list.add(new Author(name,yearOfBirth,yearOfDeath,numberOfBook,country,wikiURL,avatarURL));
        }
    return list;
    }

// Tìm kiếm tác giả theo tên
    public Author getAuthorByName(String searchName){
        Author author = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(getAuthorSQLByName);
            preparedStatement.setString(1,searchName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("ten");
                int yearOfBirth = resultSet.getInt("namSinh");
                int yearOfDeath = resultSet.getInt("namMat");
                int numberOfBook = resultSet.getInt("soTacPham");
                String nationality = resultSet.getString("quocTich");
                String linkWiki = resultSet.getString("linkWiki");
                String avatar = resultSet.getString("avatar");
                author = new Author(name,yearOfBirth,yearOfDeath,numberOfBook,nationality,linkWiki,avatar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }

}
