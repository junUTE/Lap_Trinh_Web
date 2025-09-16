<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body class="bg-light">

    <div class="container">
        <div class="row justify-content-center mt-5">
            <div class="col-md-6">
                <div class="card shadow-lg">
                    <div class="card-body">
                        <h3 class="text-center mb-4">Quên mật khẩu</h3>

                        <!-- Thông báo -->
                        <c:if test="${not empty alert}">
                            <div class="alert alert-danger text-center">${alert}</div>
                        </c:if>

                        <form action="${pageContext.request.contextPath}/forgotPassword" method="post">
                            <div class="input-group mb-3">
                                <span class="input-group-text"><i class="fa fa-envelope"></i></span>
                                <input type="email" name="email" class="form-control" placeholder="Nhập email của bạn" required>
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text"><i class="fa fa-lock"></i></span>
                                <input type="password" name="newPassword" class="form-control" placeholder="Nhập mật khẩu mới" required>
                            </div>

                            <button type="submit" class="btn btn-primary w-100">Đổi mật khẩu</button>
                        </form>

                        <p class="mt-3 text-center">
                            <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
