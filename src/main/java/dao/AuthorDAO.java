package dao;

import model.Author;
import model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorDAO implements DAO<Author>{
    public static final String getAllAuthorSQL = "select * from tacgia;";
    public static final String getAuthorByIdSQL = "select * from tacgia where id = ?;";
    public static final String deleteAuthorByIdSQL = "delete from tacgia where id = ?;";

    @Override
    public ArrayList<Author> getAll() throws SQLException {
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

    @Override
    public Author getById(int id) throws SQLException {
        Author author = new Author();
        PreparedStatement pS = connection.prepareStatement(getAuthorByIdSQL);
        pS.setInt(1,id);
        ResultSet rS = pS.executeQuery();
        while (rS.next()){
            String name = rS.getString("ten");
            int yearOfBirth = rS.getInt("namSinh");
            int yearOfDeath = rS.getInt("namMat");
            int numberOfBook = rS.getInt("soTacPham");
            String country = rS.getString("quocTich");
            String wikiURL = rS.getString("linkWiki");
            String avatarURL = rS.getString("avatar");
            author=new Author(name,yearOfBirth,yearOfDeath,numberOfBook,country,wikiURL,avatarURL);
        }
        return author;
    }

    @Override
    public boolean insertIntoDB(Author object) throws SQLException {
        return false;
    }

    @Override
    public boolean editRecord(Author object) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteRecord(int id) throws SQLException {
        PreparedStatement pS = connection.prepareStatement(deleteAuthorByIdSQL);
        pS.setInt(1,id);
        return pS.execute();
    }
}
