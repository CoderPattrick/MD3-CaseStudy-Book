package dao;

import model.Author;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorDAO implements DAO<Author>{
    public static final String getAllAuthorSQL = "select * from tacgia;";

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
        return null;
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
        return false;
    }
}
