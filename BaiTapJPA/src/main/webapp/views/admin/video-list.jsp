<%@ page import="java.util.List"%>
<%@ page import="jun.vn.entity.Video"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  List<Video> videos = (List<Video>) request.getAttribute("videos");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Video</title>
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
<body class="container mt-5">
<!-- Header -->
<div class="custom-header py-4 px-5 d-flex justify-content-between align-items-center mb-5">
    <div class="d-flex align-items-center">
        <h2 class="custom-title mb-0 fs-3">Web của Jun</h2>
    </div>
    <div class="d-flex align-items-center gap-3">
        <a href="${pageContext.request.contextPath}/admin/categories" class="custom-btn btn text-white">
            Category
        </a>
        <a href="${pageContext.request.contextPath}/logout" class="custom-btn-logout btn text-white">
            Đăng xuất
        </a>
    </div>
</div>

<h2 class="text-center mb-4">Danh sách Video</h2>

<a href="${pageContext.request.contextPath}/admin/video/add" class="btn btn-success mb-3">+ Thêm Video</a>

<table class="table table-bordered table-hover">
    <thead class="thead-dark">
      <tr>
        <th>Mã</th>
        <th>Tiêu đề</th>
        <th>Danh mục</th>
        <th>Poster</th>
        <th>Lượt xem</th>
        <th>Trạng thái</th>
        <th>Thao tác</th>
      </tr>
    </thead>
    <tbody>
    <%
      if (videos != null && !videos.isEmpty()) {
        for (Video v : videos) {
    %>
      <tr>
        <td><%= v.getVideoId() %></td>
        <td><%= v.getTitle() %></td>
        <td><%= (v.getCategory()!=null) ? v.getCategory().getCategoryname() : "" %></td>
        <td>
          <%
            if (v.getPoster()!=null && !v.getPoster().isEmpty()) {
          %>
            <img src="file:///E:/upload/video/<%= v.getPoster() %>" alt="poster" style="width:60px;height:60px;">
          <%
            } else {
          %>
            <span>Không có</span>
          <%
            }
          %>
        </td>
        <td><%= v.getViews() %></td>
        <td><%= v.isActive() ? "Hoạt động" : "Ẩn" %></td>
        <td>
          <a href="${pageContext.request.contextPath}/admin/video/edit?id=<%= v.getVideoId() %>" class="btn btn-sm btn-primary">Sửa</a>
          <a href="${pageContext.request.contextPath}/admin/video/delete?id=<%= v.getVideoId() %>" onclick="return confirm('Xóa video này?');" class="btn btn-sm btn-danger">Xóa</a>
        </td>
      </tr>
    <%
        }
      } else {
    %>
      <tr><td colspan="7" class="text-center">Chưa có video nào</td></tr>
    <%
      }
    %>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>