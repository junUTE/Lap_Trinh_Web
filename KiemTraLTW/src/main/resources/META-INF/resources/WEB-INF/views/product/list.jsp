<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Danh sách sản phẩm</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container py-4">
		<h3 class="fw-bold text-primary mb-4">
			<i class="fas fa-box me-2"></i>Danh sách sản phẩm
		</h3>

		<div class="row">
			<c:forEach var="p" items="${products}">
				<div class="col-md-4 mb-4">
					<div class="card shadow-sm h-100">
						<div class="card-body">
							<p>
								<strong>Mã cửa hàng:</strong> ${p.seller.sellerId}
							</p>
							<div class="row">
								<!-- Ảnh sản phẩm -->
								<div class="col-5 d-flex align-items-center">
									<c:choose>
										<c:when test="${not empty p.images}">
											<img
												src="${pageContext.request.contextPath}/upload/${p.images}"
												class="img-fluid border"
												style="max-height: 120px; object-fit: cover;">
										</c:when>
										<c:otherwise>
											<span class="text-muted fst-italic">[imageLink]</span>
										</c:otherwise>
									</c:choose>
								</div>

								<!-- Thông tin sản phẩm -->
								<div class="col-7">
									<p class="mb-1">
										<strong>Tên sản phẩm:</strong> <a href="#"
											class="text-primary" data-bs-toggle="modal"
											data-bs-target="#productModal" data-id="${p.productId}">
											${p.productName} </a>
									</p>
									<p class="mb-1">
										<strong>Mã sản phẩm:</strong> ${p.productId}
									</p>
									<p class="mb-1">
										<strong>Danh mục:</strong> ${p.category.categoryName}
									</p>
									<p class="mb-1">
										<strong>Giá:</strong> ${p.price}₫
									</p>
									<p class="mb-1">
										<strong>Amount:</strong> ${p.amount}
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

			<c:if test="${empty products}">
				<div class="col-12 text-center text-muted">Không có sản phẩm
					nào</div>
			</c:if>
		</div>
	</div>

	<!-- Modal chi tiết sản phẩm -->
	<div class="modal fade" id="productModal" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Chi tiết sản phẩm</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body" id="productDetailContent">
					<!-- Nội dung sẽ load qua AJAX -->
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<script>
document.addEventListener("DOMContentLoaded", function() {
    var modal = document.getElementById('productModal');
    modal.addEventListener('show.bs.modal', function (event) {
        var link = event.relatedTarget;
        var productId = link.getAttribute('data-id');

        fetch('${pageContext.request.contextPath}/home/detail/' + productId)
            .then(response => response.text())
            .then(html => {
                document.getElementById("productDetailContent").innerHTML = html;
            })
            .catch(err => {
                document.getElementById("productDetailContent").innerHTML = "<p class='text-danger'>Lỗi tải dữ liệu</p>";
            });
    });
});
</script>
</body>
</html>