<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Thêm danh mục</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet" crossorigin="anonymous">
</head>
<body class="bg-light">
	<div class="container py-4">
		<div class="card shadow">
			<div class="card-header">
				<h4 class="mb-0">Thêm danh mục</h4>
			</div>
			<div class="card-body">
				<form
					action="${pageContext.request.contextPath}/seller/categories/add"
					method="post" enctype="multipart/form-data">
					<div class="mb-3">
						<label for="categoryName" class="form-label">Tên danh mục</label>
						<input type="text" class="form-control" id="categoryName"
							name="categoryName" required>
					</div>
					<div class="mb-3">
						<label for="images" class="form-label">Icon</label> <input
							type="file" class="form-control" name="file">

					</div>
					<div class="mb-3">
						<label for="status" class="form-label">Trạng thái</label> <select
							class="form-select" id="status" name="status">
							<option value="1">Hoạt động</option>
							<option value="0">Ngừng hoạt động</option>
						</select>
					</div>
					<button type="submit" class="btn btn-success">Lưu</button>
					<a href="${pageContext.request.contextPath}/seller/categories"
						class="btn btn-secondary">Hủy</a>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
</body>
</html>
