<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div
		class="container d-flex justify-content-center align-items-center vh-100">
		<div class="card shadow-lg p-4" style="max-width: 400px; width: 100%;">
			<h3 class="text-center mb-4">Đăng nhập</h3>

			<!-- form login -->
			<form action="${pageContext.request.contextPath}/auth/login"
				method="post">
				<div class="mb-3">
					<label for="username" class="form-label">Tên đăng nhập</label> <input
						type="text" class="form-control" id="username" name="username"
						required placeholder="Nhập username">
				</div>
				<div class="mb-3">
					<label for="password" class="form-label">Mật khẩu</label> <input
						type="password" class="form-control" id="password" name="password"
						required placeholder="Nhập mật khẩu">
				</div>
				<button type="submit" class="btn btn-primary w-100">Đăng
					nhập</button>
			</form>

			<div class="text-center mt-3">

				<p class="mt-3 text-center">
					Nếu bạn chưa có tài khoản? <a
						href="${pageContext.request.contextPath}/auth/register"> Đăng
						ký</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
