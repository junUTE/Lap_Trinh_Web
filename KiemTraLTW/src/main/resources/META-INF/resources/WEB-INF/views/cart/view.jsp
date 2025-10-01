<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="container mt-4">

	<h2 class="mb-4">🛒 Giỏ hàng của bạn</h2>

	<c:if test="${not empty msg}">
		<div class="alert alert-success">${msg}</div>
	</c:if>
	<c:if test="${not empty error}">
		<div class="alert alert-danger">${error}</div>
	</c:if>

	<!-- Nếu giỏ hàng rỗng -->
	<c:if test="${empty cart || empty cart.cartItems}">
		<div class="alert alert-info">Giỏ hàng hiện đang trống.</div>
		<a href="${pageContext.request.contextPath}/product/list"
			class="btn btn-primary">Tiếp tục mua sắm</a>
	</c:if>

	<!-- Nếu có sản phẩm -->
	<c:if test="${not empty cart && not empty cart.cartItems}">
		<table class="table table-bordered align-middle">
			<thead class="table-dark">
				<tr>
					<th>Ảnh</th>
					<th>Tên sản phẩm</th>
					<th>Đơn giá</th>
					<th>Số lượng</th>
					<th>Thành tiền</th>
					<th>Hành động</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="total" value="0" />
				<c:forEach var="item" items="${cart.cartItems}">
					<tr>
						<td style="width: 120px;"><img
							src="${pageContext.request.contextPath}/uploads/${item.product.images}"
							class="img-fluid rounded" style="max-height: 80px;"></td>
						<td>${item.product.productName}</td>
						<td>${item.unitPrice}₫</td>
						<td>
							<!-- Form cập nhật số lượng -->
							<form action="${pageContext.request.contextPath}/cart/update"
								method="post" class="d-flex">
								<input type="hidden" name="itemId" value="${item.cartItemId}">
								<input type="hidden" name="userId" value="${cart.user.userId}">
								<input type="number" name="qty" value="${item.quantity}" min="1"
									class="form-control me-2" style="width: 80px;">
								<button type="submit" class="btn btn-sm btn-success">Cập
									nhật</button>
							</form>
						</td>
						<td><c:set var="subtotal"
								value="${item.unitPrice * item.quantity}" /> ${subtotal} ₫ <c:set
								var="total" value="${total + subtotal}" /></td>
						<td><a
							href="${pageContext.request.contextPath}/cart/remove?userId=${cart.user.userId}&itemId=${item.cartItemId}"
							class="btn btn-sm btn-danger"
							onclick="return confirm('Xóa sản phẩm này khỏi giỏ hàng?')">
								Xóa </a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr class="table-secondary">
					<td colspan="4" class="text-end fw-bold">Tổng tiền:</td>
					<td colspan="2" class="fw-bold">${total}₫</td>
				</tr>
			</tfoot>
		</table>

		<!-- Hành động -->
		<div class="d-flex justify-content-between mt-3">
			<a href="${pageContext.request.contextPath}/product/list"
				class="btn btn-outline-primary">← Tiếp tục mua sắm</a> <a
				href="${pageContext.request.contextPath}/checkout?userId=${cart.user.userId}"
				class="btn btn-success">Thanh toán</a>
		</div>
	</c:if>

</body>
</html>
