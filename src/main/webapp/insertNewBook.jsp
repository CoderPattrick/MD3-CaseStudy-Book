<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/7/2022
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H1>Tao moi sach</H1>
<form method="post">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="publishYear" placeholder="publishYear">
    <input type="text" name="reprint" placeholder="reprint">
    <input type="text" name="ISBNCode" placeholder="ISBNCode">
    <input type="text" name="summary" placeholder="summary">
    <input type="text" name="publisher" placeholder="publisher">
    <input type="text" name="publishLicense" placeholder="publishLicense">
    <input type="text" name="avatarURL" placeholder="avatarURL">
    <input type="text" name="viewCount" placeholder="viewCount">
    <input type="text" name="isRecommended" placeholder="isRecommended">
    <input type="text" name="price" placeholder="price">
    <input type="text" name="soldQuantity" placeholder="soldQuantity">
    <input type="text" name="inStock" placeholder="inStock">

    <select name="categories"  id="categories"multiple>
        <c:forEach items="${categories}" var="c">
            <option value="${c.getId()}">${c.getName()}</option>
        </c:forEach>
    </select>
    <br/>
    <select name="authors" id="authors" multiple>
        <c:forEach items="${authors}" var="a">
            <option value="${a.getId()}">${a.getName()}</option>
        </c:forEach>
    </select>
    <input value="tao moi" type="submit">
</form>
</body>
</html>