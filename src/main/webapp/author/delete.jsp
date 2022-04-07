<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/7/2022
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Author</title>
</head>
<body>
<form method="post">
    <h3>Are you sure you want to delete this author?</h3>
    <input type="hidden" name="id" value ="<c:out value='${author.id}'/>"/>
    <input type="submit" value="Delete">
    <a href="BookServlet?action=getAllAuthor">Back to author list</a>
</form>
</body>
</html>
