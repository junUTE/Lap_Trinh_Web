<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Cập nhật danh mục</title>
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
			<div class="card-header bg-primary text-white">
				<h4 class="mb-0">
					<i class="fas fa-edit me-2"></i> Cập nhật danh mục
				</h4>
			</div>
			<div class="card-body">
				<form
					action="${pageContext.request.contextPath}/seller/categories/update"
					method="post" enctype="multipart/form-data">

					<input type="hidden" name="categoryId"
						value="${category.categoryId}" />

					<!-- Tên danh mục -->
					<div class="mb-3">
						<label class="form-label fw-bold">Tên danh mục</label> <input
							type="text" class="form-control" name="categoryName"
							value="${category.categoryName}" required>
					</div>

					<!-- Ảnh hiện tại -->
					<div class="mb-3">
						<label class="form-label fw-bold">Ảnh hiện tại</label><br>
						<c:choose>
							<c:when test="${not empty category.images}">
								<img
									src="${pageContext.request.contextPath}/upload/${category.images}"
									class="img-thumbnail" style="max-width: 150px;">
							</c:when>
							<c:otherwise>
								<span class="text-muted fst-italic">Chưa có ảnh</span>
							</c:otherwise>
						</c:choose>
					</div>

					<!-- Chọn ảnh mới -->
					<div class="mb-3">
						<label class="form-label fw-bold">Chọn ảnh mới (tùy chọn)</label>
						<input type="file" class="form-control" name="file"
							accept="image/*"> <small class="text-muted">Để
							trống nếu muốn giữ nguyên ảnh cũ</small>
					</div>

					<!-- Trạng thái -->
					<div class="mb-3">
						<label for="status" class="form-label fw-bold">Trạng thái</label>
						<select class="form-select" id="status" name="status">
							<option value="1" ${category.status == 1 ? 'selected' : ''}>Hoạt
								động</option>
							<option value="0" ${category.status == 0 ? 'selected' : ''}>Ngừng
								hoạt động</option>
						</select>
					</div>
					<!-- Nút -->
					<div class="d-flex justify-content-between">
						<a
							href="${pageContext.request.contextPath}/seller/categories/list"
							class="btn btn-secondary"> <i class="fas fa-arrow-left me-1"></i>
							Quay lại
						</a>
						<button type="submit" class="btn btn-success">
							<i class="fas fa-save me-1"></i> Lưu thay đổi
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
