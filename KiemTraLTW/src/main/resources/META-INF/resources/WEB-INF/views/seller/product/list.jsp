<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Quản lý sản phẩm</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container py-4">
		<div class="d-flex justify-content-between align-items-center mb-3">
			<h3 class="fw-bold text-primary">
				<i class="fas fa-box me-2"></i>Danh sách sản phẩm
			</h3>
			<a href="${pageContext.request.contextPath}/seller/products/add"
				class="btn btn-success"> <i class="fas fa-plus me-1"></i> Thêm
				mới
			</a>
		</div>

		<div class="card shadow-sm">
			<div class="card-body p-0">
				<table class="table table-hover align-middle mb-0">
					<thead class="table-dark text-center">
						<tr>
							<th>ID</th>
							<th>Ảnh</th>
							<th>Tên sản phẩm</th>
							<th>Số lượng nhập</th>
							<th>Tồn kho</th>
							<th>Giá</th>
							<th>Danh mục</th>
							<th>Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${products}">
							<tr class="text-center">
								<td>${p.productId}</td>
								<td><c:choose>
										<c:when test="${not empty p.images}">
											<img
												src="${pageContext.request.contextPath}/upload/${p.images}"
												class="img-thumbnail" style="width: 70px;">
										</c:when>
										<c:otherwise>
											<span class="text-muted fst-italic">No image</span>
										</c:otherwise>
									</c:choose></td>
								<td class="text-start">${p.productName}</td>
								<td>${p.amount}</td>
								<td>${p.stock}</td>
								<td>${p.price}₫</td>
								<td>${p.category.categoryName}</td>
								<td><a
									href="${pageContext.request.contextPath}/seller/products/update?id=${p.productId}"
									class="btn btn-sm btn-warning me-1"><i class="fa fa-edit"></i></a>
									<a
									href="${pageContext.request.contextPath}/seller/products/delete?id=${p.productId}"
									class="btn btn-sm btn-danger"
									onclick="return confirm('Bạn có chắc muốn xóa?')"><i
										class="fa fa-trash"></i></a></td>
							</tr>
						</c:forEach>
						<c:if test="${empty products}">
							<tr>
								<td colspan="8" class="text-center text-muted">Không có sản
									phẩm</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
