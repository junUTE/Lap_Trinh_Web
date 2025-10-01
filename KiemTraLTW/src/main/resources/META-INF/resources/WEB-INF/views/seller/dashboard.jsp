<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Seller Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="card shadow p-4">
            <h3 class="text-center mb-4">Bảng điều khiển Seller</h3>

            <div class="d-flex justify-content-around">
                <a href="${pageContext.request.contextPath}/seller/users" class="btn btn-primary btn-lg">
                    Quản lý User
                </a>
                <a href="${pageContext.request.contextPath}/seller/categories" class="btn btn-success btn-lg">
                    Quản lý Danh mục
                </a>
                <a href="${pageContext.request.contextPath}/seller/products" class="btn btn-warning btn-lg">
                    Quản lý Sản phẩm
                </a>
            </div>
        </div>
    </div>
</body>
</html>
