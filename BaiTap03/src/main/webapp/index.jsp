<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Web của Jun</a>
            <div class="d-flex">
                <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-light">Đăng xuất</a>
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <div class="text-center">
            <h1 class="mb-4">Xin chào!</h1>
            <p class="lead">Chúc mừng bạn đã đăng nhập thành công.</p>
        </div>
    </div>

</body>
</html>
