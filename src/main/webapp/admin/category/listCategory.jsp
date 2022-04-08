<%--
  Created by IntelliJ IDEA.
  User: trand
  Date: 4/6/2022
  Time: 8:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Category</title>
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
<h2>List Category</h2>
<h2>
    <a href="/BookServlet?action=createCategory">Add new Category</a>
</h2>
<table border="1">
    <tr>
        <th>Category</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${listCategory}" var="category">
        <tr>
            <td>
                <a href="/BookServlet?action=getBooksByCategory&id=${category.getId()}"> ${category.getName()}</a>

            </td>
            <td>
                <a href="/BookServlet?action=editCategory&id=${category.id}">Edit</a>
                <a href="/BookServlet?action=deleteCategoryById&id=${category.id}">Delete</a>
            </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>

