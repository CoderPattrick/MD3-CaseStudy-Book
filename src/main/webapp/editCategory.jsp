<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 06/04/2022
  Time: 3:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Category
                </h2>
            </caption>
            <tr>
                <th>Category Name:</th>
                <td>
                    <input type="text" name="name" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
