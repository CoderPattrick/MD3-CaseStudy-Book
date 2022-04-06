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
<h2>List Category</h2>
<table border="1">
    <tr>
        <th></th>
        <th>Category</th>

    </tr>
    <c:forEach items="${listCategory}" var="category">
        <tr>
            <td>${category.getName()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

