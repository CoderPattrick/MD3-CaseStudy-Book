<%--
  Created by IntelliJ IDEA.
  User: trand
  Date: 4/5/2022
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Author</title>
    <style>
        img{
            width: 60px; height: 60px
        }
    </style>
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
<h2>List Author</h2>
<th>
    <a href="/BookServlet?action=getAuthorById&id=${id}">Search author by ID</a>

</th>
<table border="1">
    <tr>
        <th></th>
        <th>Name</th>
        <th>Year of birth</th>
        <th>Year of death</th>
        <th>Number of book written</th>
        <th>Nationality</th>
        <th>Wiki URL</th>
    </tr>
<c:forEach items="${authorList}" var="author">
    <tr>
        <td><img src='${author.getAvatarURL()}' alt="Author.img"></td>
        <td>${author.getName()}</td>
        <td>${author.getYearOfBirth()}</td>
        <td>${author.getYearOfDeath()}</td>
        <td>${author.getNumberOfBook()}</td>
        <td>${author.getCountry()}</td>
        <td>${author.getWikiURL()}</td>
        <td>
            <a href="/BookServlet?action=updateAuthorInfo&id=${author.getId()}">Edit</a>
            <a href="/BookServlet?action=deleteAuthorById2&id=${author.getId()}">Delete</a>
        </td>
    </tr>
</c:forEach>
</table>
<a href="/BookServlet?action=insertAuthor">Add new Author</a>
</body>
</html>
