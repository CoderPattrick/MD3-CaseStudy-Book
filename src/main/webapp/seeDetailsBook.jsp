<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/7/2022
  Time: 10:32 PM
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
        <th>publisher</th>
        <th>publishLicense</th>
        <th>viewCount</th>
        <th>soldQuantity</th>
        <th>inStock</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${book1}" var="book2">
        <tr>
            <td><img src='${book2.getAvatarURL()}' style="width: 60px; height: 60px" } alt="Author.img"></td>
            <td>${book2.getISBNCode()}</td>
            <td>${book2.getName()}</td>
            <td><c:forEach items="${book2.getCategoryList()}" var="category">
                <c:out value="${category.getName()}"><br></c:out>
            </c:forEach>
            </td>
            <td><c:forEach items="${book2.getAuthorList()}" var="author">
                <c:out value="${author.getName()}"><br></c:out>
            </c:forEach>
            </td>
            <td>${book2.getPublishYear()}</td>
            <td>${book2.getReprint()}</td>
            <td>${book2.getSummary()}</td>
            <td>${book2.getPublisher()}</td>
            <td>${book2.getPublishLicense()}</td>
            <td>${book2.getViewCount()}</td>
            <td>${book2.getSoldQuantity()}</td>
            <td>${book2.getInStock()}</td>
            <td>${book2.getPrice()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
