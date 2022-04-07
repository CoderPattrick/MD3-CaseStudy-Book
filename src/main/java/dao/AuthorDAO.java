package dao;

import model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AuthorDAO implements DAO<Author> {
    public static Connection connection = SingletonConnection.getConnection();
    public static final String insertAuthor = "INSERT INTO tacgia (ten, namSinh, namMat, soTacPham, quocTich, linkWiki, avatar) VALUE (?,?,?,?,?,?,?) ";
    public static final String deleteAuthor = "DELETE FROM tacgia WHERE id = ?";
    public static final String getAllAuthor = "SELECT * FROM tacgia;";
    public static final String getAuthorByName = "SELECT * FROM tacgia WHERE ten = ?";
    public static final String getAuthorById = "SELECT * FROM tacgia WHERE id = ?";
    public static final String updateAuthorInfoById = "UPDATE tacgia SET ten = ?, namSinh = ?, namMat = ?, soTacPham = ?, quocTich = ?, linkWiki = ?, avatar = ? WHERE id = ?";
    public static final String FIND_ALL_AUTHOR_BY_BOOKID = "SELECT id, ten, namSinh, namMat, soTacPham, quocTich, linkWiki, avatar FROM tacgia join sach_tacgia st on tacgia.id = st.idTacGia where st.idSach=?;";


    @Override
    public ArrayList<Author> getAll() throws SQLException {
        ArrayList<Author> list = new ArrayList<>();
        PreparedStatement pS = connection.prepareStatement(getAllAuthor);
        ResultSet rS = pS.executeQuery();
        while (rS.next()) {
            String name = rS.getString("ten");
            int yearOfBirth = rS.getInt("namSinh");
            int yearOfDeath = rS.getInt("namMat");
            int numberOfBook = rS.getInt("soTacPham");
            String country = rS.getString("quocTich");
            String wikiURL = rS.getString("linkWiki");
            String avatarURL = rS.getString("avatar");
            list.add(new Author(name, yearOfBirth, yearOfDeath, numberOfBook, country, wikiURL, avatarURL));
        }
        return list;
    }


    @Override
    public boolean insertIntoDB(Author author) throws SQLException {
        boolean rowUpdated;
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(insertAuthor);
        preparedStatement.setString(1, author.getName());
        preparedStatement.setInt(2, author.getYearOfBirth());
        preparedStatement.setInt(3, author.getYearOfDeath());
        preparedStatement.setInt(4, author.getNumberOfBook());
        preparedStatement.setString(5, author.getCountry());
        preparedStatement.setString(6, author.getWikiURL());
        preparedStatement.setString(7, author.getAvatarURL());
        rowUpdated = preparedStatement.execute();
        return rowUpdated;
    }



    @Override
    public boolean deleteRecord(int id) throws SQLException {
        boolean rowDeleted;
        PreparedStatement preparedStatement = connection.prepareStatement(deleteAuthor);
        preparedStatement.setInt(1,id);
        rowDeleted = preparedStatement.execute();
        return rowDeleted;
    }

    // Tìm kiếm tác giả theo tên
    public Author getAuthorByName(String searchName) {
        Author author = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(getAuthorByName);
            preparedStatement.setString(1, searchName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("ten");
                int yearOfBirth = resultSet.getInt("namSinh");
                int yearOfDeath = resultSet.getInt("namMat");
                int numberOfBook = resultSet.getInt("soTacPham");
                String nationality = resultSet.getString("quocTich");
                String linkWiki = resultSet.getString("linkWiki");
                String avatar = resultSet.getString("avatar");
                author = new Author(name, yearOfBirth, yearOfDeath, numberOfBook, nationality, linkWiki, avatar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }


    public Author getById(int id) {
        Author author = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(getAuthorById)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("ten");
                int yearOfBirth = Integer.parseInt(String.valueOf(resultSet.getInt("namSinh")));
                int yearOfDeath = Integer.parseInt(String.valueOf(resultSet.getInt("namMat")));
                int numberOfBook = Integer.parseInt(String.valueOf(resultSet.getInt("soTacPham")));
                String nationality = resultSet.getString("quocTich");
                String wikiURL = resultSet.getString("linkWiki");
                String avatarURL = resultSet.getString("avatar");
                author = new Author(id, name, yearOfBirth, yearOfDeath, numberOfBook, nationality, wikiURL, avatarURL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }

    public boolean editRecord(Author author) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateAuthorInfoById)) {
            preparedStatement.setString(1, author.getName());
            preparedStatement.setInt(2, author.getYearOfBirth());
            preparedStatement.setInt(3, author.getYearOfDeath());
            preparedStatement.setInt(4, author.getNumberOfBook());
            preparedStatement.setString(5, author.getCountry());
            preparedStatement.setString(6, author.getWikiURL());
            preparedStatement.setString(7, author.getAvatarURL());
            preparedStatement.setInt(8, author.getId());
            rowUpdated = preparedStatement.execute();
        }
        return rowUpdated;
    }


    public static ArrayList<Author> findAllByBookId(int id){
        ArrayList<Author> authors =new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement(FIND_ALL_AUTHOR_BY_BOOKID);
                ){
            statement.setInt(1,id);
            ResultSet resultSet =statement.executeQuery();
            while (resultSet.next()){
                int idA = resultSet.getInt("id");
                String name = resultSet.getString("ten");
                int yearOfBirth = resultSet.getInt("namSinh");
                int yearOfDeath= resultSet.getInt("namMat");
                int numberOfBook = resultSet.getInt("soTacPham");
                String country = resultSet.getString("quocTich");
                String wikiURL = resultSet.getString("linkWiki");
                String avatarURL = resultSet.getString("avatar");
                authors.add(new Author(idA,name,yearOfBirth,yearOfDeath,numberOfBook,country,wikiURL,avatarURL));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }
}
