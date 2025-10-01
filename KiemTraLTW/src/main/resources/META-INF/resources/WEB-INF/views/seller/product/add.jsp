<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Thêm sản phẩm</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container py-4">
		<div class="card shadow">
			<div class="card-header bg-success text-white">
				<h4 class="mb-0">
					<i class="fas fa-plus-circle me-2"></i>Thêm sản phẩm
				</h4>
			</div>
			<div class="card-body">
				<form
					action="${pageContext.request.contextPath}/seller/products/add"
					method="post" enctype="multipart/form-data">

					<!-- Tên sản phẩm -->
					<div class="mb-3">
						<label class="form-label">Tên sản phẩm</label> <input type="text"
							name="productName" class="form-control" required>
					</div>

					<!-- Mô tả -->
					<div class="mb-3">
						<label class="form-label">Mô tả</label>
						<textarea name="description" class="form-control" rows="3"></textarea>
					</div>

					<!-- Giá -->
					<div class="mb-3">
						<label class="form-label">Giá (₫)</label> <input type="number"
							step="0.01" name="price" class="form-control" required>
					</div>

					<!-- Số lượng nhập -->
					<div class="mb-3">
						<label class="form-label">Số lượng nhập</label> <input
							type="number" name="amount" class="form-control" required>
					</div>

					<!-- Tồn kho -->
					<div class="mb-3">
						<label class="form-label">Tồn kho</label> <input type="number"
							name="stock" class="form-control" required>
					</div>

					<!-- Hình ảnh -->
					<div class="mb-3">
						<label class="form-label">Ảnh sản phẩm</label> <input type="file"
							name="imagesFile" class="form-control" accept="image/*">
					</div>

					<!-- Danh mục -->
					<div class="mb-3">
						<label class="form-label">Danh mục</label> <select
							name="category.categoryId" class="form-select" required>
							<c:forEach var="cat" items="${categories}">
								<option value="${cat.categoryId}">${cat.categoryName}</option>
							</c:forEach>
						</select>
					</div>

					<!-- Nút -->
					<div class="text-end">
						<a href="${pageContext.request.contextPath}/seller/products/list"
							class="btn btn-secondary">Hủy</a>
						<button type="submit" class="btn btn-success">
							<i class="fas fa-save me-1"></i>Lưu
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
