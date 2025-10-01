<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Danh sách danh mục</title>
<!-- Bootstrap & FontAwesome -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container py-4">
		<!-- Tiêu đề + nút thêm mới -->
		<div class="d-flex justify-content-between align-items-center mb-3">
			<h3 class="fw-bold text-primary">
				<i class="fas fa-list me-2"></i>Danh sách danh mục
			</h3>
			<a href="${pageContext.request.contextPath}/seller/categories/add"
				class="btn btn-success"> <i class="fas fa-plus me-1"></i> Thêm
				mới
			</a>
		</div>

		<!-- Bảng danh sách -->
		<div class="card shadow-sm">
			<div class="card-body p-0">
				<table class="table table-hover align-middle mb-0">
					<thead class="table-primary">
						<tr class="text-center">
							<th style="width: 60px;">ID</th>
							<th style="width: 120px;">Icon</th>
							<th>Tên danh mục</th>
							<th style="width: 160px;">Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="c" items="${categories}">
							<tr class="text-center">
								<td>${c.categoryId}</td>
								<td><c:choose>
										<c:when test="${not empty c.images}">
											<img
												src="${pageContext.request.contextPath}/upload/${c.images}"
												class="img-thumbnail" style="width: 70px" />
										</c:when>
										<c:otherwise>
											<span class="text-muted fst-italic">No icon</span>
										</c:otherwise>
									</c:choose></td>
								<td class="text-start">${c.categoryName}</td>
								<td><a
									href="${pageContext.request.contextPath}/seller/categories/update?id=${c.categoryId}"
									class="btn btn-sm btn-warning me-1"> <i class="fa fa-edit"></i>
								</a> <a
									href="${pageContext.request.contextPath}/seller/categories/delete?id=${c.categoryId}"
									class="btn btn-sm btn-danger"
									onclick="return confirm('Bạn có chắc muốn xóa?')"> <i
										class="fa fa-trash"></i>
								</a></td>
							</tr>
						</c:forEach>

						<c:if test="${empty categories}">
							<tr>
								<td colspan="4" class="text-center text-muted py-4">Không
									có dữ liệu</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
