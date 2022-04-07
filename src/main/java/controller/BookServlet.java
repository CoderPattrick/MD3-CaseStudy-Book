package controller;

import dao.AuthorDAO;
import dao.BookDAO;
import dao.CategoryDAO;
import model.Author;
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

@WebServlet(name = "BookServlet" , value = "/author")
public class BookServlet extends HttpServlet {
    BookDAO bookDAO = new BookDAO();
    AuthorDAO authorDAO = new AuthorDAO();
    CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");
        try {
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "getAllAuthor":
                    showListAuthorForm(req, resp);
                    break;
                case "updateAuthorInfo":
                    showUpdateAuthorInfoForm(req, resp);
                    break;
                case "insertAuthor":
                    showInsertAuthorForm(req,resp);
                    break;
                case "deleteAuthor":
                    deleteAuthor(req,resp);
                    break;
                case "getAuthorByName":
                    getAuthorByName(req,resp);
                default:
                    showListAuthorForm(req,resp);
                    break;
            }
        } catch (ServletException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");
        try {
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "updateAuthorInfo":
                    updateAuthorInfo(req, resp);
                    break;
                case "insertUser":
                    insertUser(req,resp);
                    break;


            }
        } catch (ServletException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showListAuthorForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        RequestDispatcher rD = req.getRequestDispatcher("author/listAuthor.jsp");
        ArrayList<Author> list = authorDAO.getAll();
        req.setAttribute("authorList", list);
        rD.forward(req, resp);
    }

    private void showUpdateAuthorInfoForm (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Author author = authorDAO.getById(id);
        request.setAttribute("author",author);
        requestDispatcher.forward(request,response);
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
    private void showInsertAuthorForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/create.jsp");
        requestDispatcher.forward(request,response);
    }
    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
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
        request.setAttribute("listAuthor", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/list.jsp");
        requestDispatcher.forward(request,response);
    }
    private void getAuthorByName(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException,SQLException{
        String search = request.getParameter("search");
        Author author = authorDAO.getAuthorByName(search);
        ArrayList<Author> searchList = new ArrayList<>();
        searchList.add(author);
        request.setAttribute("listAuthor", searchList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/list.jsp");
        requestDispatcher.forward(request,response);
    }

}

