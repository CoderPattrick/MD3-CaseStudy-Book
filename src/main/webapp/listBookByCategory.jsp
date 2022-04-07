<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/7/2022
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Book</title>
</head>
<body>
<h2>List Book</h2>
<form method="post">
    Category ID: <input type="number" id="id" name="id" size="50"/>
    <input type="submit" value="Search"/>
</form>
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
        </tr>
    </c:forEach>
</table>
</body>
</html>
