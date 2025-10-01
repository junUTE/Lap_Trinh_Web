<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Thêm User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container py-4">
		<h3 class="fw-bold text-primary mb-3">Thêm User</h3>
		<form method="post"
			action="${pageContext.request.contextPath}/seller/users/add"
			enctype="multipart/form-data" class="card p-3 shadow-sm">


			<div class="mb-3">
				<label class="form-label">Username</label> <input type="text"
					name="username" class="form-control" required>
			</div>

			<div class="mb-3">
				<label class="form-label">Fullname</label> <input type="text"
					name="fullname" class="form-control" required>
			</div>

			<div class="mb-3">
				<label class="form-label">Email</label> <input type="email"
					name="email" class="form-control" required>
			</div>

			<div class="mb-3">
				<label class="form-label">Phone</label> <input type="text"
					name="phone" class="form-control">
			</div>

			<div class="mb-3">
				<label class="form-label">Password</label> <input type="password"
					name="password" class="form-control" required>
			</div>

			<div class="mb-3">
				<label class="form-label">Ảnh đại diện</label> <input type="file"
					name="file" class="form-control">
			</div>

			<div class="mb-3">
				<label class="form-label">Role</label> <select name="roleId"
					class="form-select">
					<c:forEach var="r" items="${roles}">
						<option value="${r.roleId}">${r.roleName}</option>
					</c:forEach>
				</select>
			</div>

			<div class="mb-3">
				<label class="form-label">Trạng thái</label> <select name="status"
					class="form-select">
					<option value="1">Active</option>
					<option value="0">Inactive</option>
				</select>
			</div>

			<button type="submit" class="btn btn-primary">Lưu</button>
			<a href="${pageContext.request.contextPath}/users"
				class="btn btn-secondary">Hủy</a>
		</form>
	</div>
</body>
</html>