package dao;

import model.Author;
import model.Book;
import model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BookDAO implements DAO<Book> {
    private static final String deleteBookByIdSQL = "delete from sach where id = ?;";
    public static final String Get_By_ID = "SELECT *FROM sach where id=? ;";
    public static final String Get_All = "SELECT *FROM sach;";
    public static final String AddNewBook = "INSERT INTO sach(ten, namXuatBan, taiBanLanThu, maISBN, moTa, NXB, GPXB, avatar, view, sachDeCu, sachHot, giaSach) values (?,?,?,?,?,?,?,?,?,?,?,?);";
    AuthorDAO authorDAO = new AuthorDAO();
    CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    public ArrayList<Book> getAll() throws SQLException {
        ArrayList<Book> list = new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement(Get_All)
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameBook = resultSet.getString("ten");
                int publishYear = resultSet.getInt("namXuatBan");
                int reprint = resultSet.getInt("taiBanLanThu");
                Long IBSNCode = resultSet.getLong("maISBN");
                String summary = resultSet.getString("moTa");
                String publisher = resultSet.getString("NXB");
                String publishLicense = resultSet.getString("GPXB");
                String avatarB = resultSet.getString("avatar");
                int viewCount = resultSet.getInt("view");
                boolean isRecommended = resultSet.getBoolean("sachDeCu");
                boolean isBestSeller = resultSet.getBoolean("sachHot");
                double price = resultSet.getDouble("giaSach");
                int soldQuantity = resultSet.getInt("soLuongDaBan");
                int inStock = resultSet.getInt("sachTonKho");
                ArrayList<Author> authors = authorDAO.findAllByBookId(id);
                ArrayList<Category> categories = categoryDAO.findAllByBookId(id);
                list.add(new Book(IBSNCode, nameBook, categories, authors, publishYear, reprint, summary, publisher, publishLicense, avatarB, viewCount, isRecommended, isBestSeller, price, soldQuantity, inStock));
            }
        }
        return list;
    }

    @Override
    public Book getById(int id) throws SQLException {
        Book newBook = null;
        try (
                PreparedStatement statement = connection.prepareStatement(Get_By_ID)
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nameBook = resultSet.getString("ten");
                int publishYear = resultSet.getInt("namXuatBan");
                int reprint = resultSet.getInt("taiBanLanThu");
                Long IBSNCode = resultSet.getLong("maISBN");
                String summary = resultSet.getString("moTa");
                String publisher = resultSet.getString("NXB");
                String publishLicense = resultSet.getString("GPXB");
                String avatarB = resultSet.getString("avatar");
                int viewCount = resultSet.getInt("view");
                boolean isRecommended = resultSet.getBoolean("sachDeCu");
                boolean isBestSeller = resultSet.getBoolean("sachHot");
                double price = resultSet.getDouble("giaSach");
                int soldQuantity = resultSet.getInt("soLuongDaBan");
                int inStock = resultSet.getInt("sachTonKho");
                ArrayList<Author> authors = authorDAO.findAllByBookId(id);
                ArrayList<Category> categories = categoryDAO.findAllByBookId(id);
                newBook = new Book(id, IBSNCode, nameBook, categories, authors, publishYear, reprint, summary, publisher, publishLicense, avatarB, viewCount, isRecommended, isBestSeller, price, soldQuantity, inStock);
            }
        }
        return newBook;

    }

    @Override
    public boolean insertIntoDB(Book object) {
        int idB = 0;
        ArrayList<Category> categories = object.getCategoryList();
        ArrayList<Author> authors = object.getAuthorList();
        ArrayList<Integer> id_catogories = new ArrayList<>();
        ArrayList<Integer> id_authors = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            int idC = categories.get(i).getId();
            id_catogories.add(idC);
        }
        for (int i = 0; i < authors.size(); i++) {
            int idA = authors.get(i).getId();
            id_authors.add(idA);
        }
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(AddNewBook, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, object.getName());
            statement.setInt(2, object.getPublishYear());
            statement.setInt(3, object.getReprint());
            statement.setLong(4, object.getISBNCode());
            statement.setString(5, object.getSummary());
            statement.setString(6, object.getPublisher());
            statement.setString(7, object.getPublishLicense());
            statement.setString(8, object.getAvatarURL());
            statement.setInt(9, object.getViewCount());
            statement.setBoolean(10, object.isRecommended());
            statement.setBoolean(11, object.isBestSeller());
            statement.setDouble(12, object.getPrice());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()) {
                idB = resultSet.getInt(1);
            }
            PreparedStatement statement1 = connection.prepareStatement("INSERT INTO sach_theloai(idSach, idTheLoai) values (?,?);");
            for (int idCatogory : id_catogories
            ) {
                statement1.setInt(1, idB);
                statement1.setInt(2, idCatogory);
                statement1.executeUpdate();
            }
            PreparedStatement statement2 = connection.prepareStatement("INSERT INTO sach_tacgia(idSach, idTacGia) values (?,?);");
            for (int idAuthor : id_authors
            ) {
                statement2.setInt(1, idB);
                statement2.setInt(2, idAuthor);
                statement2.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            try{
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return true;
    }


    @Override
    public boolean editRecord(Book object) throws SQLException {

        return false;
    }

    @Override
    public boolean deleteRecord(int id) throws SQLException {
        PreparedStatement pS = connection.prepareStatement(deleteBookByIdSQL);
        pS.setInt(1, id);
        return pS.execute();
    }

    public static ArrayList<Integer> getBookbyIdCategory(int idCategory) {
        ArrayList<Integer> bookListId = new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement("SELECT *FROM sach_theloai WHERE idTheLoai=?;")
        ) {
            statement.setInt(1, idCategory);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idSach");
                bookListId.add(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookListId;
    }

    public ArrayList<Book> getBookByIdCategory(int idCategory) throws SQLException {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Integer> bookIds = getBookbyIdCategory(idCategory);
        for (int i = 0; i < bookIds.size(); i++) {
            int id = bookIds.get(i);
            Book newBook = getById(id);
            books.add(newBook);
        }
        return books;
    }
}
