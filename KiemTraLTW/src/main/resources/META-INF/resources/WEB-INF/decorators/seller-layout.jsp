<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title><decorator:title default="Seller Page" /></title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
	rel="stylesheet" />

<!-- CSS riêng -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/seller.css" />

<!-- Head riêng của từng trang con -->
<decorator:head />
</head>
<body class="bg-light">

	<!-- Header chung -->
	<jsp:include page="/WEB-INF/views/common/seller/header.jsp" />

	<!-- Nội dung chính -->
	<main class="container my-4">
		<decorator:body />
	</main>

	<!-- Footer chung -->
	<jsp:include page="/WEB-INF/views/common/seller/footer.jsp" />

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
