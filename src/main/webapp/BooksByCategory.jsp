<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/8/2022
  Time: 8:32 AM
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
        <th>Price</th>
        <th>See Details</th>
    </tr>
    <c:forEach items="${books}" var="books">
        <tr>
            <td><img src='${books.getAvatarURL()}' style="width: 60px; height: 60px" } alt="Author.img"></td>
            <td>${books.getISBNCode()}</td>
            <td>${books.getName()}</td>
            <td><c:forEach items="${books.getCategoryList()}" var="category">
                <c:out value="${category.getName()}"><br></c:out>
            </c:forEach>
            </td>
            <td><c:forEach items="${books.getAuthorList()}" var="author">
                <c:out value="${author.getName()}"><br></c:out>
            </c:forEach>
            </td>
            <td>${books.getPublishYear()}</td>
            <td>${books.getReprint()}</td>
            <td>${books.getSummary()}</td>
            <td>${books.getPrice()}</td>
            <td>
                <a href="/BookServlet?action=getDetailsBook&id=${books.getId()}">Chi tiết</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>