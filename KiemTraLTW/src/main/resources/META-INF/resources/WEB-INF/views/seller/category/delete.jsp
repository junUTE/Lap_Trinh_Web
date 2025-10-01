<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Xóa Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

    <div class="card p-4 shadow-sm">
        <h3 class="mb-3 text-danger">Xác nhận xóa</h3>
        <p>Bạn có chắc chắn muốn xóa category <strong>${category.categoryName}</strong>?</p>

        <form action="${pageContext.request.contextPath}/category/delete" method="post">
            <input type="hidden" name="categoryId" value="${category.categoryId}"/>
            <button type="submit" class="btn btn-danger">Xóa</button>
            <a href="${pageContext.request.contextPath}/category/list" class="btn btn-secondary">Hủy</a>
        </form>
    </div>

</body>
</html>
