<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Đăng ký</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card shadow-lg">
					<div class="card-header bg-primary text-white text-center">
						<h4>Đăng ký tài khoản</h4>
					</div>
					<div class="card-body">
						<form action="${pageContext.request.contextPath}/register"
							method="post">
							<div class="mb-3">
								<label for="fullname" class="form-label">Họ tên</label> <input
									type="text" class="form-control" id="fullname" name="fullname"
									required>
							</div>

							<div class="mb-3">
								<label for="email" class="form-label">Email</label> <input
									type="email" class="form-control" id="email" name="email"
									required>
							</div>

							<div class="mb-3">
								<label for="passwd" class="form-label">Mật khẩu</label> <input
									type="password" class="form-control" id="passwd" name="passwd"
									required>
							</div>

							<button type="submit" class="btn btn-primary w-100">Đăng
								ký</button>
						</form>

						<c:if test="${not empty error}">
							<div class="alert alert-danger mt-3" role="alert">${error}
							</div>
						</c:if>

						<p class="mt-3 text-center">
							Đã có tài khoản? <a
								href="${pageContext.request.contextPath}/login"
								class="text-decoration-none">Đăng nhập</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
