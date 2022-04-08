<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/8/2022
  Time: 8:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Author</title>
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
<h2>Add new Author</h2>
<div align="center">
    <form method="post">

        <table>
            <c:if test="${author != null}">
                <input type="hidden" name="id" />
            </c:if>
            <tr>
                <th>Author name:</th>
                <td>
                    <input type="text" name="ten" />
                </td>
            </tr>
            <tr>
                <th>Year of birth:</th>
                <td>
                    <input type="number" name="namSinh" />
                </td>
            </tr>
            <tr>
                <th>Year of death:</th>
                <td>
                    <input type="number" name="namMat" />
                </td>
            </tr>
            <tr>
                <th>Number of book written:</th>
                <td>
                    <input type="number" name="soTacPham" />
                </td>
            </tr>
            <tr>
                <th>Nationality:</th>
                <td>
                    <input type="text" name="quocTich" />
                </td>
            </tr>
            <tr>
                <th>Wiki URL:</th>
                <td>
                    <input type="text" name="linkWiki" />
                </td>
            </tr>
            <tr>
                <th>Avatar URL:</th>
                <td>
                    <input type="text" name="avatar" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
            <tr>
                <a href="BookServlet?action=getAllAuthor">Back to author list</a>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
