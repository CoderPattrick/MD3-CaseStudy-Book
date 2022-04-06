package controller;

import dao.BookDAO;
import model.Author;

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
    BookDAO dao = new BookDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        String action = req.getParameter("action");
        try{
            if(action == null){
                action ="";
            }
            switch (action){
                case "getAllAuthor":
                    showListAuthorForm(req,resp);
                    break;
                case "updateAuthorInfo":
                    showUpdateAuthorInfoForm(req,resp);
                default:
                    break;
            }
        } catch (ServletException | SQLException | IOException e) {
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
                case "updateAuthorInfo":
                    updateAuthorInfo(req,resp);
                    break;


            }
        } catch (ServletException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showListAuthorForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rD = req.getRequestDispatcher("listAuthor.jsp");
        try {
            ArrayList<Author> list = dao.getAllAuthor();
            req.setAttribute("listAuthor",list);
            rD.forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void showUpdateAuthorInfoForm (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Author author = dao.getAuthorById(id);
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
        dao.updateAuthorInfo(author);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/edit.jsp");
        requestDispatcher.forward(request,response);
    }

}
