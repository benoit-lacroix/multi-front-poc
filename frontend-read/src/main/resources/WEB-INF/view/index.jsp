<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Read-Front</title>
</head>

<body>
<h1>Read-Front</h1>

<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Salary</th>
        <th>Designation</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="item" items="${stockList}">
        <tr>
            <td>${item.id}</td>
            <td>${item.label}</td>
            <td>${item.color}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>