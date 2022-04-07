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
import java.util.List;

@WebServlet(name = "BookServlet" , value = "/BookServlet")
public class BookServlet extends HttpServlet {

    AuthorDAO authorDAO = new AuthorDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    BookDAO bookDAO = new BookDAO();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        try {
            if (action == null) {
                action = "";
            }
            switch (action) {
                //BOOK
                case "getAllBook":
                    showListBookForm(request, response);
                    break;
                case "deleteBookById":
                    showDeleteBookForm(request, response);
                    break;
                //AUTHOR
                case "getAllAuthor":
                    showAuthorListForm(request, response);
                    break;
                case "updateAuthorInfo":
                    showUpdateAuthorInfoForm(request, response);
                    break;
                case "insertAuthor":
                    showInsertAuthorForm(request, response);
                    break;
                case "deleteAuthor":
                    deleteAuthor(request, response);
                    break;
                case "getAuthorByName":
                    getAuthorByName(request, response);
                    break;
                //CATEGORY
                case "getAllCategory":
                    showListCategoryForm(request, response);
                    break;
                case "deleteCategory":
                    deleteCategory(request, response);
                    break;
                case "showCreateCategoryForm":
                    showCreateCateForm(request, response);
                    break;

            }
        } catch (ServletException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                action = "";
            }
            switch (action) {
                //AUTHOR
                case "updateAuthorInfo":
                    updateAuthorInfo(request, response);
                    break;
                case "insertAuthor":
                    insertAuthor(request, response);
                    break;
                //BOOK
                case "deleteBookById":
                    deleteBookById(request, response);
                    break;
                //CAREGORY
                case "deleteCategoryById":
                    break;
                case "createCategory":
                    insertCategory(request, response);
                    break;
                case "editCategory":
                    editCategory(request, response);
                    break;
            }
        }catch (ServletException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    //AUTHOR
    private void showUpdateAuthorInfoForm (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Author author = authorDAO.getById(id);
        request.setAttribute("author",author);
        requestDispatcher.forward(request,response);
    }
    private void showInsertAuthorForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/create.jsp");
        requestDispatcher.forward(request,response);
    }
    private void showAuthorListForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        ArrayList<Author> list = authorDAO.getAll();
        request.setAttribute("authorList", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void updateAuthorInfo(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("ten");
        int yearOfBirth = Integer.parseInt(request.getParameter("namSinh"));
        int yearOfDeath = Integer.parseInt(request.getParameter("namMat"));
        int numberOfBook = Integer.parseInt(request.getParameter("soTacPham"));
        String nationality = request.getParameter("quocTich");
        String wikiURL = request.getParameter("linkWiki");
        String avatarURL = request.getParameter("avatar");
        Author author = new Author(id,name,yearOfBirth,yearOfDeath,numberOfBook,nationality,wikiURL,avatarURL);
        authorDAO.editRecord(author);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/edit.jsp");
        requestDispatcher.forward(request,response);
    }

    private void insertAuthor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        String name = request.getParameter("ten");
        int yearOfBirth = Integer.parseInt(request.getParameter("namSinh"));
        int yearOfDeath = Integer.parseInt(request.getParameter("namMat"));
        int numberOfBook = Integer.parseInt(request.getParameter("soTacPham"));
        String nationality = request.getParameter("quocTich");
        String wikiURL = request.getParameter("linkWiki");
        String avatarURL = request.getParameter("avatar");
        Author author = new Author(name,yearOfBirth,yearOfDeath,numberOfBook,nationality,wikiURL,avatarURL);
        authorDAO.insertIntoDB(author);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/create.jsp");
        requestDispatcher.forward(request,response);
    }
    private void deleteAuthor (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        authorDAO.deleteRecord(id);
        ArrayList<Author> list = authorDAO.getAll();
        request.setAttribute("authorList", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/list.jsp");
        requestDispatcher.forward(request,response);
    }
    private void getAuthorByName(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException,SQLException {
        String name = request.getParameter("search");
        Author author = authorDAO.getAuthorByName(name);
        ArrayList<Author> searchList = new ArrayList<>();
        searchList.add(author);
        request.setAttribute("authorList", searchList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/list.jsp");
        requestDispatcher.forward(request, response);
    }
    //Author - Book
    private void getBookByAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
        int id = Integer.parseInt(request.getParameter("search"));
//        bookDAO

    }

    //CATEGORY
    private void showListCategoryForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listCategory.jsp");
        ArrayList<Category> list = categoryDAO.getAll();
        request.setAttribute("listCategory",list);
        requestDispatcher.forward(request,response);
    }
    private void showCreateCateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("createCategory.jsp");
        requestDispatcher.forward(request, response);
    }
    private void editCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Category book = new Category(id, name);
        categoryDAO.editRecord(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editCategory.jsp");
        dispatcher.forward(request, response);
    }
    private void deleteCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        categoryDAO.deleteRecord(id);
        List<Category> listCategory = categoryDAO.getAll();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listCategory.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCategory(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, ServletException {
        String name = request.getParameter("name");
        Category category = new Category(name);
        categoryDAO.insertIntoDB(category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("createCategory.jsp");
        dispatcher.forward(request, response);
    }


    //BOOK
    private void showDeleteBookForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        RequestDispatcher rD = req.getRequestDispatcher("deleteBook.jsp");
        rD.forward(req,resp);
    }
    private void deleteBookById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String result =req.getParameter("id");
        int id = Integer.parseInt(result);
        bookDAO.deleteRecord(id);
    }
    private void showListBookForm(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException, SQLException {
        RequestDispatcher rD = req.getRequestDispatcher("listBook.jsp");
        ArrayList<Book> list = bookDAO.getAll();
        req.setAttribute("listBook",list);
        rD.forward(req,resp);
    }



}

