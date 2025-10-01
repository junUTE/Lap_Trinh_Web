<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Quản lý tác giả</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container mt-5">
		<div class="card shadow">
			<div class="card-header bg-primary text-white">
				<h4 class="mb-0">Quản lý tác giả</h4>
			</div>
			<div class="card-body">
				<!-- Form thêm tác giả -->
				<form action="${pageContext.request.contextPath}/admin/authors"
					method="post" class="row g-3 mb-4">
					<input type="hidden" name="action" value="create">
					<div class="col-md-8">
						<input type="text" name="authorName" class="form-control"
							placeholder="Tên tác giả" required>
					</div>
					<div class="col-md-4">
						<button type="submit" class="btn btn-success w-100">Thêm
							tác giả</button>
					</div>
				</form>

				<!-- Bảng danh sách tác giả -->
				<table class="table table-striped table-hover">
					<thead class="table-dark">
						<tr>
							<th>ID</th>
							<th>Tên tác giả</th>
							<th class="text-center">Hành động</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${authors}" var="a">
							<tr>
								<td>${a.authorId}</td>
								<td>${a.authorName}</td>
								<td class="text-center">
									<form action="${pageContext.request.contextPath}/admin/authors"
										method="post" class="d-inline">
										<input type="hidden" name="action" value="delete"> <input
											type="hidden" name="id" value="${a.authorId}">
										<button type="submit" class="btn btn-danger btn-sm"
											onclick="return confirm('Bạn có chắc muốn xóa tác giả này?');">
											Xóa</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
