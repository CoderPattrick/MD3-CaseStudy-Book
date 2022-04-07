package dao;

import model.Author;
import model.Book;
import model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class BookDAO implements DAO<Book> {

    private static final String deleteBookByIdSQL ="delete from sach where id = ?;";
    private static final String deleteBookTypeByIdSQL ="delete from sach_theloai WHERE idSach = ?;";
    private static final String deleteBookAuthorByIdSQL ="delete from sach_tacgia WHERE idSach = ?;";
    public static final String Get_By_ID = "SELECT * FROM sach where id = ? ;";
    public static final String Get_All = "SELECT *FROM sach;";
    public static final String GET_BY_ID_CATEGORY = "SELECT *FROM sach_theloai WHERE idTheLoai=?;";
    public static final String GET_BY_ID_AUTHOR = "SELECT *FROM sach_tacgia WHERE idTacGia=?;";
    AuthorDAO authorDAO = new AuthorDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    static BookDAO bookDAO = new BookDAO();

    @Override
    public ArrayList<Book> getAll() throws SQLException {
        ArrayList<Book> list = new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement(Get_All)
        ) {
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
                ArrayList<Author> authors = authorDAO.getAll();
                ArrayList<Category> categories = categoryDAO.getAll();
                list.add(new Book(IBSNCode, nameBook, categories, authors, publishYear, reprint, summary, publisher, publishLicense, avatarB, viewCount, isRecommended, isBestSeller, price, soldQuantity, inStock));
            }
        }
        return list;
    }

    @Override
    public Book getById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Get_By_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
        Book newBook = new Book();
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
        return newBook;
    }
    @Override
    public boolean insertIntoDB(Book object) throws SQLException {
        return false;
    }

    @Override
    public boolean editRecord(Book object) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteRecord(int id) throws SQLException {
        PreparedStatement pS1 = connection.prepareStatement(deleteBookAuthorByIdSQL);
        PreparedStatement pS2 = connection.prepareStatement(deleteBookTypeByIdSQL);
        PreparedStatement pS3 = connection.prepareStatement(deleteBookByIdSQL);

        pS1.setInt(1,id);
        pS2.setInt(1,id);
        pS3.setInt(1,id);

        pS1.execute();
        pS2.execute();
        pS3.execute();
        return true;
    }

    public ArrayList<Integer> getBookbyIdCategory(int idCategory) {
        ArrayList<Integer> bookListId = new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement(GET_BY_ID_CATEGORY)
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

    public ArrayList<Book> getBookByIdAuthor(int idAuthor) throws SQLException{
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Integer> bookIds = getIdBookByIdAuthor(idAuthor);
        for (int i = 0; i < bookIds.size(); i++) {
            int id = bookIds.get(i);
            books.add(bookDAO.getById(id));
        }
        return books;
    }

    private ArrayList<Integer> getIdBookByIdAuthor(int idAuthor) throws SQLException {
        ArrayList<Integer> bookListId = new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement(GET_BY_ID_AUTHOR)
        ) {
            statement.setInt(1, idAuthor);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idSach");
                bookListId.add(id);
            }
        }
        return bookListId;
    }
}
