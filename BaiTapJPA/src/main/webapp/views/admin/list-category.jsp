<%@page import="jun.vn.entity.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>

<%
List<Category> categories = (List<Category>) request.getAttribute("categories");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách danh mục</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
body {
    font-family: Arial, sans-serif;
    background: #f5f6fa;
    padding: 30px;
}

h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #2f3640;
}

a.add-btn {
    display: inline-block;
    margin-bottom: 15px;
    padding: 10px 15px;
    background: #00a8ff;
    color: #fff;
    text-decoration: none;
    border-radius: 6px;
}

a.add-btn:hover {
    background: #0097e6;
}

table {
    width: 100%;
    border-collapse: collapse;
    background: #fff;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

th, td {
    padding: 12px;
    border-bottom: 1px solid #dcdde1;
    text-align: center;
}

th {
    background: #273c75;
    color: #fff;
}

tr:hover {
    background: #f1f2f6;
}

img {
    border-radius: 6px;
    border: 1px solid #dcdde1;
}

.action-btn {
    padding: 6px 12px;
    border-radius: 4px;
    text-decoration: none;
    color: white;
    font-size: 14px;
}

.edit-btn {
    background: #44bd32;
}

.edit-btn:hover {
    background: #4cd137;
}

.delete-btn {
    background: #e84118;
}

.delete-btn:hover {
    background: #c23616;
}

.custom-header {
    background: linear-gradient(90deg, #4b6cb7, #182848);
    color: white;
    border-radius: 0.75rem;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
}

.custom-title {
    color: #FFDAB9;
    font-weight: 700;
    letter-spacing: 0.05em;
}

.custom-btn {
    background-color: #ff8c00;
    border: none;
    padding: 0.5rem 1.5rem;
    font-weight: 600;
    transition: background-color 0.3s ease, transform 0.2s ease;
}

.custom-btn:hover {
    background-color: #e07b00;
    transform: translateY(-2px);
}

.custom-btn-logout {
    background-color: #e84118;
    border: none;
    padding: 0.5rem 1.5rem;
    font-weight: 600;
    transition: background-color 0.3s ease, transform 0.2s ease;
}

.custom-btn-logout:hover {
    background-color: #c0392b;
    transform: translateY(-2px);
}
</style>
</head>
<body>
    <!-- Header -->
    <div class="custom-header py-4 px-5 d-flex justify-content-between align-items-center mb-5">
        <div class="d-flex align-items-center">
            <h2 class="custom-title mb-0 fs-3">Web của Jun</h2>
        </div>
        <div class="d-flex align-items-center gap-3">
            <a href="${pageContext.request.contextPath}/admin/videos" class="custom-btn btn text-white">
                Video
            </a>
            <a href="${pageContext.request.contextPath}/logout" class="custom-btn-logout btn text-white">
                Đăng xuất
            </a>
        </div>
    </div>

    <h2>Danh sách danh mục</h2>
    <a class="add-btn" href="${pageContext.request.contextPath}/admin/category/add">
        + Thêm mới
    </a>

    <!-- Table -->
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên danh mục</th>
                <th>Icon</th>
                <th>Trạng thái</th>
                <th>Thao tác</th>
            </tr>
        </thead>
        <tbody>
            <%
            if (categories != null && !categories.isEmpty()) {
                for (Category c : categories) {
            %>
            <tr>
                <td><%=c.getId()%></td>
                <td><%=c.getCategoryname()%></td>
                <td>
                    <%
                    if (c.getImage() != null) {
                    %>
                        <img src="file:///E:/upload/category/<%= c.getImage() %>"
                             alt="icon" style="width: 60px; height: 60px;">
                    <%
                    } else {
                    %>
                        <span>Không có</span>
                    <%
                    }
                    %>
                </td>
                <!-- Trạng thái -->
                <td>
                    <%
                    if (c.getStatus() == 1) {
                    %>
                        <span style="color: green; font-weight: bold;">Hoạt động</span>
                    <%
                    } else {
                    %>
                        <span style="color: red; font-weight: bold;">Ngưng</span>
                    <%
                    }
                    %>
                </td>
                <!-- Thao tác -->
                <td>
                    <a class="action-btn edit-btn"
                       href="${pageContext.request.contextPath}/admin/category/edit?id=<%= c.getId() %>">Sửa</a>
                    <a class="action-btn delete-btn"
                       href="${pageContext.request.contextPath}/admin/category/delete?id=<%= c.getId() %>"
                       onclick="return confirm('Bạn có chắc muốn xóa?');">Xóa</a>
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="5">Không có danh mục nào.</td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>