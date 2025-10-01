<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Title động từ Sitemesh -->
    <title><page:title default="OnTap LTW - Admin" /></title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS (nếu có) -->
    <link href="${pageContext.request.contextPath}/static/css/admin-style.css" rel="stylesheet">
</head>
<body class="d-flex flex-column min-vh-100 bg-light">

    <!-- ========== Header ========== -->
    <header>
        <%@ include file="/common/admin/header.jsp"%>
    </header>
    <!-- ========== End Header ========== -->

    <!-- ========== Main Content ========== -->
    <main class="container my-4 flex-grow-1">
        <page:body />
    </main>
    <!-- ========== End Main Content ========== -->

    <!-- ========== Footer ========== -->
    <footer class="mt-auto bg-dark text-white">
        <%@ include file="/common/admin/footer.jsp"%>
    </footer>
    <!-- ========== End Footer ========== -->

    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Custom JS (nếu có) -->
    <script src="${pageContext.request.contextPath}/static/js/admin-script.js"></script>
</body>
</html>
