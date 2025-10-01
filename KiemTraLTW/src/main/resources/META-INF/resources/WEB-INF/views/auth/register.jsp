<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div
		class="container d-flex justify-content-center align-items-center vh-100">
		<div class="card shadow-lg p-4" style="max-width: 500px; width: 100%;">
			<h3 class="text-center mb-4">Đăng ký tài khoản</h3>

			<!-- Form đăng ký -->
			<form action="${pageContext.request.contextPath}/auth/register"
				method="post" enctype="multipart/form-data">

				<!-- Username -->
				<div class="mb-3">
					<label class="form-label">Tên đăng nhập</label> <input type="text"
						class="form-control" name="username" placeholder="Nhập username"
						required>
				</div>

				<!-- Email -->
				<div class="mb-3">
					<label class="form-label">Email</label> <input type="email"
						class="form-control" name="email" placeholder="Nhập email"
						required>
				</div>

				<!-- Fullname -->
				<div class="mb-3">
					<label class="form-label">Họ tên</label> <input type="text"
						class="form-control" name="fullname" placeholder="Nhập họ tên"
						required>
				</div>

				<!-- Password -->
				<div class="mb-3">
					<label class="form-label">Mật khẩu</label> <input type="password"
						class="form-control" name="password" placeholder="Nhập mật khẩu"
						required>
				</div>

				<!-- Phone -->
				<div class="mb-3">
					<label class="form-label">Số điện thoại</label> <input type="text"
						class="form-control" name="phone" placeholder="Nhập số điện thoại">
				</div>

				<!-- Images -->
				<div class="mb-3">
					<label class="form-label">Ảnh đại diện</label> <input type="file"
						class="form-control" name="imageFile" accept="image/*">
				</div>

				<!-- Role -->
				<div class="mb-3">
					<label class="form-label">Đăng ký với vai trò:</label>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="roleName"
							id="roleUser" value="ROLE_USER" checked> <label
							class="form-check-label" for="roleUser">Người dùng</label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="roleName"
							id="roleSeller" value="ROLE_SELLER"> <label
							class="form-check-label" for="roleSeller">Người bán
							(Seller)</label>
					</div>
				</div>

				<!-- Submit -->
				<button type="submit" class="btn btn-success w-100">Đăng ký</button>
			</form>

			<div class="text-center mt-3">
				<p class="mt-3 text-center">
					Nếu bạn chưa có tài khoản? <a
						href="${pageContext.request.contextPath}/auth/login"> Đăng
						nhập</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
