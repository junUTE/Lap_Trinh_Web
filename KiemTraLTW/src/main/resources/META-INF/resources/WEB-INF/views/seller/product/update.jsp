<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Cập nhật sản phẩm</title>
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
			<div class="card-header bg-warning text-dark">
				<h4 class="mb-0">
					<i class="fas fa-edit me-2"></i>Cập nhật sản phẩm
				</h4>
			</div>
			<div class="card-body">
				<form
					action="${pageContext.request.contextPath}/seller/products/update"
					method="post" enctype="multipart/form-data">

					<!-- Hidden ID -->
					<input type="hidden" name="productId" value="${product.productId}">

					<!-- Tên sản phẩm -->
					<div class="mb-3">
						<label class="form-label">Tên sản phẩm</label> <input type="text"
							name="productName" class="form-control"
							value="${product.productName}" required>
					</div>

					<!-- Mô tả -->
					<div class="mb-3">
						<label class="form-label">Mô tả</label>
						<textarea name="description" class="form-control" rows="3">${product.description}</textarea>
					</div>

					<!-- Giá -->
					<div class="mb-3">
						<label class="form-label">Giá (₫)</label> <input type="number"
							step="0.01" name="price" class="form-control"
							value="${product.price}" required>
					</div>

					<!-- Số lượng nhập -->
					<div class="mb-3">
						<label class="form-label">Số lượng nhập</label> <input
							type="number" name="amount" class="form-control"
							value="${product.amount}" required>
					</div>

					<!-- Tồn kho -->
					<div class="mb-3">
						<label class="form-label">Tồn kho</label> <input type="number"
							name="stock" class="form-control" value="${product.stock}"
							required>
					</div>

					<!-- Ảnh hiện tại -->
					<div class="mb-3">
						<label class="form-label">Ảnh hiện tại</label><br>
						<c:if test="${not empty product.images}">
							<img
								src="${pageContext.request.contextPath}/upload/${product.images}"
								class="img-thumbnail mb-2" style="width: 100px;">
						</c:if>
					</div>

					<!-- Upload ảnh mới -->
					<div class="mb-3">
						<label class="form-label">Ảnh mới (tùy chọn)</label> <input
							type="file" name="imagesFile" class="form-control"
							accept="image/*">
					</div>

					<!-- Danh mục -->
					<div class="mb-3">
						<label class="form-label">Danh mục</label> <select
							name="category.categoryId" class="form-select" required>
							<c:forEach var="cat" items="${categories}">
								<option value="${cat.categoryId}"
									<c:if test="${product.category.categoryId == cat.categoryId}">selected</c:if>>
									${cat.categoryName}</option>
							</c:forEach>
						</select>
					</div>

					<div class="mb-3">
						<label class="form-label">Trạng thái</label> <select name="status"
							class="form-select">
							<option value="1" ${category.status == 1 ? "selected" : ""}>Hoạt
								động</option>
							<option value="0" ${category.status == 0 ? "selected" : ""}>Ngưng
								hoạt động</option>
						</select>
					</div>

					<!-- Nút -->
					<div class="text-end">
						<a href="${pageContext.request.contextPath}/seller/products/list"
							class="btn btn-secondary">Hủy</a>
						<button type="submit" class="btn btn-warning">
							<i class="fas fa-save me-1"></i>Cập nhật
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
