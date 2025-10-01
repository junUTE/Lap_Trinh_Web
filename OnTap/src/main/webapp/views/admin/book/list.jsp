<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Quản lý sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-4">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2 class="mb-0">📚 Quản lý sách</h2>
        <a href="${pageContext.request.contextPath}/admin/books?action=create" 
           class="btn btn-success">➕ Thêm sách</a>
    </div>

    <table class="table table-bordered table-striped table-hover align-middle">
        <thead class="table-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Tiêu đề</th>
                <th scope="col">Mô tả</th>
                <th scope="col" class="text-center">Hành động</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="b">
            <tr>
                <td>${b.bookId}</td>
                <td>${b.title}</td>
                <td>${b.description}</td>
                <td class="text-center">
                    <a href="${pageContext.request.contextPath}/admin/books?action=edit&id=${b.bookId}" 
                       class="btn btn-sm btn-warning">✏️ Sửa</a>
                    <a href="${pageContext.request.contextPath}/admin/books?action=delete&id=${b.bookId}" 
                       class="btn btn-sm btn-danger"
                       onclick="return confirm('Bạn có chắc muốn xóa sách này không?');">🗑️ Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
