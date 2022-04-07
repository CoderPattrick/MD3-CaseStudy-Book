let list = '${listBook}';
let display = '<table border="1">'+
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
    </tr></c:forEach>+'</table>';
    let check = false;
    function checkGetBooks(){
        check = !check;
        if(check){
            document.getElementById("displayBooks").innerHTML = display;
        }
        else {
            document.getElementById("displayBooks").innerHTML = "";
        }
    }