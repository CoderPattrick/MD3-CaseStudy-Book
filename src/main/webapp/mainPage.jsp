<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/7/2022
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Group 3's Case Study</title>
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
</body>
</html>
