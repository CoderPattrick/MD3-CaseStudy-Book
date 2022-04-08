<%--
  Created by IntelliJ IDEA.
  User: trand
  Date: 4/6/2022
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Book</title>
</head>
<body>
<table>
    <tr>
        <th>
            <a href="/BookServlet">Home Page</a>
        </th>
        <th>
            <a href="/BookServlet?action=getAllAuthor">Show all author</a>
        </th>
        <th>
            <a href="/BookServlet?action=getAllBook">Show all book</a>
        </th>
        <th>
            <a href="/BookServlet?action=getAllCategory">Show all category</a>
        </th>
    </tr>
</table>
<h2>List Book</h2>
<a href="/BookServlet?action=getBestSeller">Show best sellers</a>
<a href="/BookServlet?action=getRecommend">Recommended for you</a>
<table border="1">
    <tr>
        <th></th>
        <th>ISBN</th>
        <th>Name</th>
        <th>Category</th>
        <th>Author</th>
        <th>Published Year</th>
        <th>Reprint</th>
        <th>Summary</th>
        <th>Price</th>
        <th>See Details</th>
    </tr>
    <c:forEach items="${listBook}" var="book">
        <tr>
            <td><img src='${book.getAvatarURL()}' style="width: 60px; height: 60px" } alt="Author.img"></td>
            <td>${book.getISBNCode()}</td>
            <td>${book.getName()}</td>
            <td><c:forEach items="${book.getCategoryList()}" var="category">
           <c:out value="${category.getName()}"><br></c:out>
                 </c:forEach>
            </td>
            <td><c:forEach items="${book.getAuthorList()}" var="author">
           <c:out value="${author.getName()}"><br></c:out>
                 </c:forEach>
            </td>
            <td>${book.getPublishYear()}</td>
            <td>${book.getReprint()}</td>
            <td>${book.getSummary()}</td>
            <td>${book.getPrice()}</td>
            <td>
                <a href="/BookServlet?action=getDetailsBook&id=${book.getId()}">Chi tiết</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
