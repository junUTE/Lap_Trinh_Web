<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title><decorator:title default="User Page" /></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user.css"/>
    <decorator:head/>
</head>
<body>
    <!-- Header -->
    <jsp:include page="/WEB-INF/views/common/user/header.jsp" />

    <!-- Nội dung chính -->
    <main class="container my-4">
        <decorator:body />
    </main>

    <!-- Footer -->
    <jsp:include page="/WEB-INF/views/common/user/footer.jsp" />
</body>
</html>
