<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách sách</title>
</head>
<body>
<h2>Danh sách sách</h2>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Mô tả</th>
        <th>Chi tiết</th>
    </tr>
    <c:forEach items="${books}" var="b">
        <tr>
            <td>${b.bookId}</td>
            <td>${b.title}</td>
            <td>${b.description}</td>
            <td><a href="${pageContext.request.contextPath}/book/detail?id=${b.bookId}">Xem</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
