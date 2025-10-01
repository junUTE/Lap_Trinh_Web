<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Quản lý User</title>
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
				<i class="fas fa-users me-2"></i>Danh sách User
			</h3>
			<a href="${pageContext.request.contextPath}/seller/users/add"
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
							<th>Username</th>
							<th>Fullname</th>
							<th>Email</th>
							<th>Phone</th>
							<th>Role</th>
							<th>Trạng thái</th>
							<th>Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="u" items="${users}">
							<tr class="text-center">
								<td>${u.userId}</td>
								<td><c:choose>
										<c:when test="${not empty u.images}">
											<img
												src="${pageContext.request.contextPath}/upload/${u.images}"
												class="img-thumbnail" style="width: 50px;">
										</c:when>
										<c:otherwise>
											<span class="text-muted fst-italic">No image</span>
										</c:otherwise>
									</c:choose></td>
								<td>${u.username}</td>
								<td>${u.fullname}</td>
								<td>${u.email}</td>
								<td>${u.phone}</td>
								<td>${u.role.roleName}</td>
								<td><c:if test="${u.status == 1}">Active</c:if> <c:if
										test="${u.status != 1}">Inactive</c:if></td>
								<td><a
									href="${pageContext.request.contextPath}/seller/users/edit/${u.userId}"
									class="btn btn-sm btn-warning me-1"><i class="fa fa-edit"></i></a>

									<a
									href="${pageContext.request.contextPath}/seller/users/delete/${u.userId}"
									class="btn btn-sm btn-danger"
									onclick="return confirm('Bạn có chắc muốn xóa?')"> <i
										class="fa fa-trash"></i>
								</a></td>
							</tr>
						</c:forEach>
						<c:if test="${empty users}">
							<tr>
								<td colspan="9" class="text-center text-muted">Không có
									user nào</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
