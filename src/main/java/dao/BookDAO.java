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
    public static final String Get_By_ID = "SELECT *FROM sach where id=? ;";
    public static final String Get_All = "SELECT *FROM sach;";
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
        Book newBook = null;
        try (
                PreparedStatement statement = connection.prepareStatement(Get_By_ID)
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
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
            ArrayList<Author> authors = AuthorDAO.findAllByBookId(id);
            ArrayList<Category> categories = CategoryDAO.findAllByBookId(id);
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
        PreparedStatement pS = connection.prepareStatement(deleteBookByIdSQL);
        pS.setInt(1,id);
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