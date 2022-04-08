package dao;

import model.Author;
import model.Book;
import model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BookDAO implements DAO<Book> {

    private static final String deleteBookByIdSQL ="delete from sach where id = ?;";
    private static final String deleteBookTypeByIdSQL ="delete from sach_theloai WHERE idSach = ?;";
    private static final String deleteBookAuthorByIdSQL ="delete from sach_tacgia WHERE idSach = ?;";
    private static final String deleteBookInCartSQL ="delete from chitietgiohang WHERE id_sach = ?;";
    public static final String Get_By_ID = "SELECT * FROM sach where id = ? ;";
    public static final String Get_All = "SELECT *FROM sach;";
    public static final String GET_BY_ID_CATEGORY = "SELECT *FROM sach_theloai WHERE idTheLoai=?;";
    public static final String GET_BY_ID_AUTHOR = "SELECT *FROM sach_tacgia WHERE idTacGia=?;";
    public static final String AddNewBook = "INSERT INTO sach(ten, namXuatBan, taiBanLanThu, maISBN, moTa, NXB, GPXB, avatar, view, sachDeCu, sachHot, giaSach) values (?,?,?,?,?,?,?,?,?,?,?,?);";
    public static final String UPDATE_BOOK = "update sach set maISBN = ? , ten= ? , namXuatBan = ? , taiBanLanThu = ? , moTa = ? , giaSach = ? where id = ?;";
    public static final String UPDATE_BOOK_AUTHOR = "insert into sach_tacgia (idSach, idTacGia) VALUES (?,?);";
    public static final String UPDATE_BOOK_CATEGORY = "insert into sach_theloai(idSach, idTheLoai) VALUES (?,?);";
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
        long isbn = object.getISBNCode();
        String name = object.getName();
        ArrayList<Category> categories = object.getCategoryList();
        ArrayList<Author> authors = object.getAuthorList();
        int publishYear = object.getPublishYear();
        int reprint = object.getReprint();
        String summary = object.getSummary();
        double price = object.getPrice();
        int id = object.getId();
        PreparedStatement pS = connection.prepareStatement(UPDATE_BOOK);
        pS.setLong(1,isbn);
        pS.setString(2,name);
        pS.setInt(3,publishYear);
        pS.setInt(4,reprint);
        pS.setString(5,summary);
        pS.setDouble(6,price);
        pS.setInt(7,id);
        pS.execute();
        for (Category c:categories
             ) {
            PreparedStatement pS2 = connection.prepareStatement(UPDATE_BOOK_CATEGORY);
            pS2.setInt(1,id);
            pS2.setInt(2,c.getId());
            pS2.execute();
        }
        for (Author a:authors
             ) {
            PreparedStatement pS2 = connection.prepareStatement(UPDATE_BOOK_AUTHOR);
            pS2.setInt(1,id);
            pS2.setInt(2,a.getId());
            pS2.execute();
        }
        return true;
    }

    @Override
    public boolean deleteRecord(int id) throws SQLException {
        PreparedStatement pS1 = connection.prepareStatement(deleteBookAuthorByIdSQL);
        PreparedStatement pS2 = connection.prepareStatement(deleteBookTypeByIdSQL);
        PreparedStatement pS4 = connection.prepareStatement(deleteBookInCartSQL);
        PreparedStatement pS3 = connection.prepareStatement(deleteBookByIdSQL);

        pS1.setInt(1,id);
        pS2.setInt(1,id);
        pS4.setInt(1,id);
        pS3.setInt(1,id);

        pS1.execute();
        pS2.execute();
        pS4.execute();
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