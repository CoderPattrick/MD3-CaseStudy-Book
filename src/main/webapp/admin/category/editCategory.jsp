<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 06/04/2022
  Time: 3:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
<h2>Edit Category</h2>

    <form method="post">
        <table>

            <tr>
                <th>Category name:</th>
                <td>
                    <input type="text" name="ten" value="<c:out value ='${category.name}'/>">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
            <tr>
                <a href="BookServlet?action=getAllCategory">Back to category list</a>
            </tr>

        </table>
    </form>

</body>
</html>