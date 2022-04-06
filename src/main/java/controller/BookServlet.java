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
                default:
                    break;
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");
//        try{
            if(action == null){
                action ="";
            }
            switch (action){

            }
//        }
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



}
