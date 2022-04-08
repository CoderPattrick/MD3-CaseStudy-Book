<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/7/2022
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit Author infomation</title>
</head>
<body>
<h2>Edit Author</h2>
<div align="center">
    <form method="post">
        <table>
            <c:if test="${author != null}">
                <input type="hidden" name="id" value ="<c:out value='${author.id}'/>"/>
            </c:if>
            <tr>
                <th>Author name:</th>
                <td>
                    <input type="text" name="ten" value="<c:out value ='${author.name}'/>">
                </td>
            </tr>
            <tr>
                <th>Year of birth:</th>
                <td>
                    <input type="number" name="namSinh" value="<c:out value='${author.yearOfBirth}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Year of death:</th>
                <td>
                    <input type="number" name="namMat" value="<c:out value ='${author.yearOfDeath}'/>">
                </td>
            </tr>
            <tr>
                <th>Number of book written:</th>
                <td>
                    <input type="number" name="soTacPham" value="<c:out value ='${author.numberOfBook}'/>">
                </td>
            </tr>
            <tr>
                <th>Nationality:</th>
                <td>
                    <input type="text" name="quocTich" value="<c:out value ='${author.country}'/>">
                </td>
            </tr>
            <tr>
                <th>Wiki URL:</th>
                <td>
                    <input type="text" name="linkWiki" value="<c:out value ='${author.wikiURL}'/>">
                </td>
            </tr>
            <tr>
                <th>Avatar URL:</th>
                <td>
                    <input type="text" name="avatar" value="<c:out value ='${author.avatarURL}'/>">
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
