<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Tạo tài khoản mới</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
	<form action="${pageContext.request.contextPath}/register" method="post" class="w-50 mx-auto mt-5">
    <h2 class="mb-4 text-center">Tạo tài khoản mới</h2>

    <c:if test="${alert != null}">
        <div class="alert alert-danger text-center">${alert}</div>
    </c:if>

    <div class="input-group mb-3">
        <span class="input-group-text"><i class="fa fa-user"></i></span>
        <input type="text" class="form-control" placeholder="Tài khoản" name="userName" required>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text"><i class="fa fa-user"></i></span>
        <input type="text" class="form-control" placeholder="Họ tên" name="hoTen" required>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text"><i class="fa fa-envelope"></i></span>
        <input type="email" class="form-control" placeholder="Nhập Email" name="email" required>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text"><i class="fa fa-phone"></i></span>
        <input type="text" class="form-control" placeholder="Số điện thoại" name="SDT" required>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text"><i class="fa fa-lock"></i></span>
        <input type="password" class="form-control" placeholder="Mật khẩu" name="passWord" required>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text"><i class="fa fa-lock"></i></span>
        <input type="password" class="form-control" placeholder="Nhập lại mật khẩu" name="repassword" required>
    </div>

    <button type="submit" class="btn btn-primary w-100">Tạo tài khoản</button>

    <p class="mt-3 text-center">Nếu bạn đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>


</form>
</body>
</html>