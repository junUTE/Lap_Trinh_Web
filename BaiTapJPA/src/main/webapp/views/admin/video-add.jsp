<%@ page import="java.util.List"%>
<%@ page import="jun.vn.entity.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    List<Category> categories = (List<Category>) request.getAttribute("categories");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Video</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">
  <h2 class="text-center mb-4">Thêm Video</h2>

  <form action="${pageContext.request.contextPath}/admin/video/add" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label>Mã Video:</label>
      <input type="text" name="id" class="form-control" required>
    </div>

    <div class="form-group">
      <label>Tiêu đề:</label>
      <input type="text" name="title" class="form-control" required>
    </div>

    <div class="form-group">
      <label>Mô tả:</label>
      <textarea name="decription" class="form-control" rows="4"></textarea>
    </div>

    <div class="form-group">
      <label>Lượt xem:</label>
      <input type="text" name="views" class="form-control">
    </div>

    <div class="form-group">
      <label>Trạng thái:</label>
      <div class="form-check">
        <input class="form-check-input" type="checkbox" name="active" id="active">
        <label class="form-check-label" for="active">Hoạt động</label>
      </div>
    </div>

    <div class="form-group">
      <label>Danh mục:</label>
      <select name="categoryId" class="form-control" required>
        <option value="">-- Chọn danh mục --</option>
        <%
          if (categories != null) {
            for (Category c : categories) {
        %>
          <option value="<%= c.getId() %>"><%= c.getCategoryname() %></option>
        <%
            }
          }
        %>
      </select>
    </div>

    <div class="form-group">
      <label>Poster:</label>
      <input type="file" name="poster" class="form-control-file" accept="image/*">
    </div>

    <button type="submit" class="btn btn-success w-100">Thêm mới</button>
    <a href="${pageContext.request.contextPath}/admin/videos" class="btn btn-secondary w-100 mt-2">Quay lại</a>
  </form>
</body>
</html>
