<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 07/04/2022
  Time: 9:11 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DeleteCategory</title>
</head>
<body>
<form method="post">
    <h3>Are you sure you want to delete this category?</h3>
    <input type="hidden" name="id" value ="<c:out value='${category.id}'/>"/>
    <input type="submit" value="Delete">
    <a href="BookServlet?action=getAllCategory">Back to author list</a>
</form>
</body>
</html>
