<%--
  Created by IntelliJ IDEA.
  User: trand
  Date: 4/6/2022
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Author</title>
</head>

<body>
<script>
    // document.getElementById("btn1").onclick = function () {
    //
    // };
    let check = false;
    function demo(){
        check = !check;
        if(check){
            document.getElementById("displayBooks").style.display = 'block';
        }
        else {
            document.getElementById("displayBooks").style.display = 'none';
        }
    }

</script>
<h2>Author</h2>
<form method="post">
    Author ID: <input type="number" id="id" name="id" size="50"/>
    <input type="submit" value="Search"/>
    <table border="1">
        <tr>
            <th></th>
            <th>Name</th>
            <th>Year of birth</th>
            <th>Year of Death</th>
            <th>Number of book</th>
            <th>Country</th>
            <th>Detail</th>
        </tr>
        <tr>
            <td><img src='${author.getAvatarURL()}' style="width: 60px; height: 60px" } alt="Author.img"></td>
            <td>${author.getName()}</td>
            <td>${author.getYearOfBirth()}</td>
            <td>${author.getYearOfDeath()}</td>
            <td>
                <a style="color: blue;text-underline: blue" id="btn1" onclick="demo()">${author.getNumberOfBook()}
                </a>
            </td>
            <td>${author.getCountry()}</td>
            <td>${author.getWikiURL()}</td>
        </tr>
    </table>
</form>
<div style="display: none" id="displayBooks">
    <table border="1">
        <tr>
            <th></th>
            <th>ISBN</th>
            <th>Name</th>
            <th>Category</th>
            <th>Author</th>
            <th>Published Year</th>
            <th>Reprint</th>
            <th>Summary</th>
            <th>Price</th>
        </tr>+
        <c:forEach items="${listBook}" var="book">
            <tr>
                <td><img src='${book.getAvatarURL()}' style="width: 60px; height: 60px" alt="Author.img"/></td>
                <td>${book.getISBNCode()}</td>
                <td>${book.getName()}</td>
                <td><c:forEach items="${book.getCategoryList()}" var="category">
                    <c:out value="${category.getName()}"><br/></c:out>
                </c:forEach>
                </td>
                <td><c:forEach items="${book.getAuthorList()}" var="author">
                    <c:out value="${author.getName()}"><br/></c:out>
                </c:forEach>
                </td>
                <td>${book.getPublishYear()}</td>
                <td>${book.getReprint()}</td>
                <td>${book.getSummary()}</td>
                <td>${book.getPrice()}</td>
            </tr></c:forEach></table>
</div>
</body>
</html>
