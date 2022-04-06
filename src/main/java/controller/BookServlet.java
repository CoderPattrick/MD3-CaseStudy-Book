package controller;

import dao.AuthorDAO;
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

@WebServlet(name = "BookServlet" , value = "/BookServlet")
public class BookServlet extends HttpServlet {
    AuthorDAO authorDAO = new AuthorDAO();
    CategoryDAO categoryDAO = new CategoryDAO();

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
                case "getAllCategory":
                    showListCategoryForm(req,resp);
                    break;
                case "getAuthorById":
                    showAuthorByIdForm(req,resp);
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
            }
        }catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


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




}
