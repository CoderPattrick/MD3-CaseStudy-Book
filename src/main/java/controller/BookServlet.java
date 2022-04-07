package controller;

import dao.AuthorDAO;
import dao.BookDAO;
import dao.CategoryDAO;
import model.Author;
import model.Book;
import model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "BookServlet" , value = "/BookServlet")
public class BookServlet extends HttpServlet {
    AuthorDAO authorDAO = new AuthorDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    BookDAO bookDAO = new BookDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        String action = req.getParameter("action");
        try{
            if(action == null){
                action ="";
            }
            switch (action){
                case "getAllBook":
                    showListBookForm(req,resp);
                    break;
                case "getAllAuthor":
                    showListAuthorForm(req,resp);
                    break;
                case "getAllCategory":
                    showListCategoryForm(req,resp);
                    break;
                case "getAuthorById":
                    showAuthorByIdForm(req,resp);
                    break;
                case "deleteBookById":
                    showDeleteBookForm(req,resp);
                    break;
                case "deleteAuthorById":
                    showDeleteAuthorForm(req,resp);
                    break;
                case "getBooksByCategory":
                    showBooksByCategoryForm(req,resp);
                    break;
                case "getNewBook":
                    getNewBookForm(req,resp);
                    break;
                default:
                    break;
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");
        try{
            if(action == null){
                action ="";
            }
            switch (action){
                case "getAuthorById":
                    getAuthorById(req,resp);
                    break;
                case "deleteBookById":
                    deleteBookById(req,resp);
                    break;
                case "deleteAuthorById":
                    deleteAuthorById(req,resp);
                    break;
                case  "getBooksByCategory":
                    showListBookByCategory(req, resp);
                    break;
                case "getNewBook":
                    getNewBook(req,resp);
                    break;
            }
        }catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//Là người d    ùng tôi muốn
// khi xem chi tiết một tác giả
// có thể xem được
// danh sách các tác phẩm của tác giả đó
    private void showListAuthorForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        RequestDispatcher rD = req.getRequestDispatcher("listAuthor.jsp");
            ArrayList<Author> list = authorDAO.getAll();
            req.setAttribute("listAuthor",list);
            rD.forward(req,resp);

    }
    private void showListCategoryForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        RequestDispatcher rD = req.getRequestDispatcher("listCategory.jsp");
            ArrayList<Category> list = categoryDAO.getAll();
            req.setAttribute("listCategory",list);
            rD.forward(req,resp);
    }
    private void showAuthorByIdForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException  {
        RequestDispatcher rD = req.getRequestDispatcher("authorById.jsp");
        rD.forward(req,resp);
    }
    private void getAuthorById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        RequestDispatcher rD = req.getRequestDispatcher("authorById.jsp");
        String result =req.getParameter("id");
        int id = Integer.parseInt(result);
        Author author = authorDAO.getById(id);
        req.setAttribute("author",author);
        rD.forward(req,resp);
    }
    private void showDeleteBookForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        RequestDispatcher rD = req.getRequestDispatcher("deleteBook.jsp");
        rD.forward(req,resp);
    }
    private void deleteBookById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String result =req.getParameter("id");
        int id = Integer.parseInt(result);
        bookDAO.deleteRecord(id);
    }
    private void deleteAuthorById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String result =req.getParameter("id");
        int id = Integer.parseInt(result);
        authorDAO.deleteRecord(id);
    }
    private void showDeleteAuthorForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        RequestDispatcher rD = req.getRequestDispatcher("deleteAuthor.jsp");
        rD.forward(req,resp);
    }
    private void showListBookForm(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException, SQLException {
        RequestDispatcher rD = req.getRequestDispatcher("listBook.jsp");
        ArrayList<Book> list = bookDAO.getAll();
        req.setAttribute("listBook",list);
        rD.forward(req,resp);
    }

    private void showBooksByCategoryForm (HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher= req.getRequestDispatcher("listBookByCategory.jsp");
        dispatcher.forward(req,resp);
    }

    private void showListBookByCategory (HttpServletRequest req , HttpServletResponse resp) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("listBookByCategory.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        ArrayList<Book> books = bookDAO.getBookByIdCategory(id);
        req.setAttribute("listBook",books);
        dispatcher.forward(req,resp);
    }

    private void getNewBookForm (HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("insertNewBook.jsp");
        ArrayList<Category> newCatogories = categoryDAO.getAll();
        ArrayList<Author> newAuthors = authorDAO.getAll();
        request.setAttribute("categories",newCatogories);
        request.setAttribute("authors",newAuthors);
        dispatcher.forward(request,response);
    }

    private void getNewBook (HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("insertNewBook.jsp");
        String name = request.getParameter("name");
        int publishYear =Integer.parseInt(request.getParameter("publishYear"));
        int reprint = Integer.parseInt(request.getParameter("reprint"));
        long IBSNCode = Long.parseLong(request.getParameter("ISBNCode"));
        String summary = request.getParameter("summary");
        String publisher = request.getParameter("publisher");
        String publishLicense = request.getParameter("publishLicense");
        String avatarURL = request.getParameter("avatarURL");
        int view = Integer.parseInt(request.getParameter("viewCount"));
        boolean isRecommended = Boolean.parseBoolean(request.getParameter("isRecommended"));
        boolean isBestSeller = Boolean.parseBoolean(request.getParameter("isBestSeller"));
        double price = Double.parseDouble(request.getParameter("price"));
        int soldQuantity = Integer.parseInt(request.getParameter("soldQuantity"));
        int inStock = Integer.parseInt(request.getParameter("inStock"));
        String[] categoriesStr = request.getParameterValues("categories");
        String[] authorsStr = request.getParameterValues("authors");
        int [] categories = new int[categoriesStr.length];
        ArrayList<Category> categoryArrayList = new ArrayList<>();
        for (int i = 0; i < categories.length; i++) {
            categories[i] = Integer.parseInt(categoriesStr[i]);
            categoryArrayList.add(categoryDAO.getById(categories[i]));
        }
        int[] authors = new int[authorsStr.length];
        ArrayList<Author>authorArrayList =new ArrayList<>();
        for (int i = 0; i < authors.length; i++) {
            authors[i]= Integer.parseInt(authorsStr[i]);
            authorArrayList.add(authorDAO.getById(authors[i]));
        }
        Book newBook = new Book(IBSNCode,name,categoryArrayList,authorArrayList,publishYear,reprint,summary,publisher,publishLicense,avatarURL,view,isRecommended,isBestSeller,price,soldQuantity,inStock);
        bookDAO.insertIntoDB(newBook);
        ArrayList<Category> newCatogories = categoryDAO.getAll();
        ArrayList<Author> newAuthors = authorDAO.getAll();
        request.setAttribute("categories",newCatogories);
        request.setAttribute("authors",newAuthors);
        dispatcher.forward(request,response);
    }
}
