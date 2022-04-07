package dao;

import model.Book;

import java.sql.SQLException;

public class test {
    static BookDAO bookDAO = new BookDAO();
    public static void main(String[] args) {
        try {
            System.out.println(bookDAO.getById(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}