<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/8/2022
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Carts</title>
</head>
<body>
<h2>List Carts</h2>
<table border="1">
    <tr>
        <th>Users</th>
        <th>DateTime</th>
        <th>Users</th>
    </tr>
    <c:forEach items="${listCarts}" var="cart">
        <tr>
            <td>${cart.getCartCode()}</td>
            <td>${cart.getOrderDateTime()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
