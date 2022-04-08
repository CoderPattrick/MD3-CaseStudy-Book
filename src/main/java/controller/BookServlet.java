package controller;

import dao.*;
import model.*;

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
    UserDAO userDAO = new UserDAO();
    CartDAO cartDAO =new CartDAO();

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
                case "getNewBook":
                    getNewBookForm(request ,response);
                    break;
                case "getDetailsBook":
                    seeDetailsBook(request,response);
                    break;
                case "getBookById":
                    showBookByIdForm(request, response);
                    break;
                case "deleteBookById2":
                    deleteBookById(request, response);
                    break;
                case "getBooksByCategory":
                    getBookByIdCategory(request,response);
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
                case "deleteAuthorById":
                    showDeleteAuthorForm(request, response);
                    break;
                case "deleteAuthorById2":
                    showDeleteAuthorForm2(request, response);
                    break;
                case "getAuthorById":
                    showAuthorByIdForm(request, response);
                    break;

                //CATEGORY
                case "getAllCategory":
                    showListCategoryForm(request, response);
                    break;
                case "deleteCategoryById":
                    showDeleteCategoryForm(request, response);
                    break;
                case "createCategoryById":
                    showCreateCateForm(request, response);
                    break;
                case "editCategory":
                    showEditCateForm(request, response);
                    break;
//                    Cart
                case "getAllCarts":
                    showListCartsForm(request,response);
                    break;
                default:
                    showMainPage(request,response);
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
                case "getAuthorById":
                    getAuthorById(request, response);
                    break;
                case "getAuthorByName":
                    getAuthorByName(request, response);
                    break;
                case "updateAuthorInfo":
                    updateAuthorInfo(request, response);
                    break;
                case "insertAuthor":
                    insertAuthor(request, response);
                    break;
                case "deleteAuthorById":
                    deleteAuthorById(request,response);
                    break;
                case "deleteAuthorById2":
                    deleteAuthorById2(request,response);
                    break;
                //BOOK
                case "deleteBookById":
                    deleteBookById(request, response);
                    break;
                case "getNewBook":
                    getNewBook(request, response);
                    break;
                case "getBookById":
                    getBookById(request, response);
                    break;
                //CAREGORY
                case "deleteCategoryById":
                    deleteCategoryById(request, response);
                    break;
                case "createCategory":
                    createCategory(request, response);
                    break;
                case "editCategory":
                    editCategory(request, response);
                    break;

            }
        }catch (ServletException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    //Homepage
    private void showMainPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("mainPage.jsp");
        requestDispatcher.forward(request,response);
    }

    //AUTHOR
    private void showUpdateAuthorInfoForm (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Author author = authorDAO.getById(id);
        request.setAttribute("author", author);
        requestDispatcher.forward(request, response);
    }

    private void showAuthorByIdForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException  {
        RequestDispatcher rD = req.getRequestDispatcher("authorById.jsp");
        rD.forward(req,resp);
    }
    private void showInsertAuthorForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/create.jsp");
        requestDispatcher.forward(request,response);
    }
    private void showAuthorListForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/list.jsp");
        ArrayList<Author> list = authorDAO.getAll();
        request.setAttribute("authorList", list);
        requestDispatcher.forward(request, response);
    }
    private void getAuthorById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
            RequestDispatcher rD = req.getRequestDispatcher("authorById.jsp");
            String result =req.getParameter("id");
            int id = Integer.parseInt(result);
            ArrayList<Book> listBook = bookDAO.getBookByIdAuthor(id);
            Author author = authorDAO.getById(id);
            req.setAttribute("author",author);
            req.setAttribute("listBook",listBook);
            rD.forward(req,resp);
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

    private void getAuthorByName(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException,SQLException {
        String name = request.getParameter("search");
        Author author = authorDAO.getAuthorByName(name);
        ArrayList<Author> searchList = new ArrayList<>();
        searchList.add(author);
        request.setAttribute("authorList", searchList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deleteAuthorById2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        authorDAO.deleteRecord(id);
        ArrayList<Author> list = authorDAO.getAll();
        request.setAttribute("authorList", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/list.jsp");
        requestDispatcher.forward(request,response);
    }
    private void showDeleteAuthorForm2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("author/delete.jsp");
        requestDispatcher.forward(request,response);
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

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        categoryDAO.deleteRecord(id);
        List<Category> listCategory = categoryDAO.getAll();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listCategory.jsp");
        dispatcher.forward(request, response);
    }


    private void showEditCateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        RequestDispatcher rD = req.getRequestDispatcher("editCategory.jsp");
        rD.forward(req,resp);
    }


    private void createCategory(HttpServletRequest request, HttpServletResponse response)

            throws IOException, SQLException, ServletException {
        String name = request.getParameter("ten");
        Category category = new Category(name);
        categoryDAO.insertIntoDB(category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("createCategory.jsp");
        dispatcher.forward(request, response);
    }


    //BOOK

    private void editCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("ten");
        Category book = new Category(id, name);
        categoryDAO.editRecord(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editCategory.jsp");
        dispatcher.forward(request, response);
    }


    private void showDeleteBookForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        RequestDispatcher rD = req.getRequestDispatcher("deleteBook.jsp");
        rD.forward(req,resp);
    }
    private void showDeleteCategoryForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        RequestDispatcher rD = req.getRequestDispatcher("deleteCategory.jsp");
        rD.forward(req,resp);
    }

    private void deleteBookById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String result =req.getParameter("id");
        int id = Integer.parseInt(result);
        bookDAO.deleteRecord(id);
    }
    private void deleteCategoryById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String result =req.getParameter("id");
        int id = Integer.parseInt(result);
        categoryDAO.deleteRecord(id);
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
    private void getNewBookForm (HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("js/insertNewBook.jsp");
        ArrayList<Category> newCatogories = categoryDAO.getAll();
        ArrayList<Author> newAuthors = authorDAO.getAll();
        request.setAttribute("categories",newCatogories);
        request.setAttribute("authors",newAuthors);
        dispatcher.forward(request,response);
    }

    private void getNewBook (HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("js/insertNewBook.jsp");
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
    private void seeDetailsBook (HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("seeDetailsBook.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Book newBook = bookDAO.getById(id);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(newBook);
        request.setAttribute("book1", books);
        dispatcher.forward(request, response);
    }
    public void showBookByIdForm(HttpServletRequest req ,HttpServletResponse resp) throws ServletException, IOException, SQLException
    {
        RequestDispatcher rD = req.getRequestDispatcher("bookById.jsp");
        rD.forward(req,resp);
    }
    public void getBookById(HttpServletRequest req ,HttpServletResponse resp) throws ServletException, IOException, SQLException
    {
        RequestDispatcher rD = req.getRequestDispatcher("bookById.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookDAO.getById(id);
        req.setAttribute("book",book);
        rD.forward(req,resp);
    }
    public void getBookByIdCategory (HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("BooksByCategory.jsp");
        int id  =Integer.parseInt(request.getParameter("id"));
        ArrayList<Book> books = bookDAO.getBookByIdCategory(id);
        request.setAttribute("books",books);
        dispatcher.forward(request,response);
    }

//    USER
    public void showListCartsForm (HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher= request.getRequestDispatcher("listCart.jsp");
        ArrayList<Cart> carts = cartDAO.getAll();
        request.setAttribute("listCarts",carts);
        dispatcher.forward(request,response);
    }
}


