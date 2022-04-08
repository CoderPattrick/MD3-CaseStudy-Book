<%--
  Created by IntelliJ IDEA.
  User: trand
  Date: 4/7/2022
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Book</title>
</head>

<body>
<h2>Edit Book</h2>
<form method="post">
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
  <tr>
    <td><img src='${book.getAvatarURL()}' style="width: 60px; height: 60px" } alt="Author.img"></td>
    <td>${book.getISBNCode()}
      <br/><input type="text" name="ISBN" size="50">
    </td>
    <td>${book.getName()}
      <br/><input type="text" name="name" size="50">
    </td>
    <td><c:forEach items="${book.getCategoryList()}" var="category">
      <c:out value="${category.getName()}"><br></c:out>
    </c:forEach>
      <select name="category" id="category" multiple>
        <c:forEach items="${categoryList}" var="category">
          <option value="${category.getId()}">${category.getName()}</option>
        </c:forEach>
      </select>
    </td>
    <td><c:forEach items="${book.getAuthorList()}" var="author">
      <c:out value="${author.getName()}"><br></c:out>
    </c:forEach>
      <select name="author" id="author" multiple>
        <c:forEach items="${authorList}" var="author">
          <option value="${author.getId()}">${author.getName()}</option>
        </c:forEach>
      </select>
    </td>
    <td>${book.getPublishYear()}
      <br/><input type="text" name="publishYear" size="50">
    </td>
    <td>${book.getReprint()}
      <br/><input type="text" name="reprint" size="50">
    </td>
    <td>${book.getSummary()}
      <br/><input type="text" name="summary" size="50">
    </td>
    <td>${book.getPrice()}
      <br/><input type="text" name="price" size="50">
    </td>
  </tr>
</table>
  <input type="submit" value="Save change" height="30"/>
</form>
</body>
</html>
