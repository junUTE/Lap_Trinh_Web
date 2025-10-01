<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chi tiết sách</title>
</head>
<body>
<h2>${book.title}</h2>
<p><b>Mô tả:</b> ${book.description}</p>

<h3>Đánh giá & Nhận xét</h3>
<ul>
    <c:forEach items="${reviews}" var="r">
        <li>
            <b>User ${r.userId}:</b> ${r.reviewText}
        </li>
    </c:forEach>
</ul>

<c:if test="${not empty sessionScope.user}">
    <form action="${pageContext.request.contextPath}/book/detail" method="post">
        <input type="hidden" name="bookId" value="${book.bookId}">
        <textarea name="review" rows="3" cols="40" placeholder="Nhập nhận xét..."></textarea><br/>
        <button type="submit">Gửi nhận xét</button>
    </form>
</c:if>
</body>
</html>
