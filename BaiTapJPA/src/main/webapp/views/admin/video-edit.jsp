<%@ page import="jun.vn.entity.Video"%>
<%@ page import="jun.vn.entity.Category"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  Video v = (Video) request.getAttribute("video");
  List<Category> categories = (List<Category>) request.getAttribute("categories");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa Video</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">
  <h2 class="text-center mb-4">Sửa Video</h2>

  <form action="${pageContext.request.contextPath}/admin/video/edit" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="<%= v.getVideoId() %>">

    <div class="form-group">
      <label>Tiêu đề:</label>
      <input type="text" name="title" value="<%= v.getTitle() %>" class="form-control" required>
    </div>

    <div class="form-group">
      <label>Mô tả:</label>
      <textarea name="decription" class="form-control" rows="4"><%= v.getDecription() %></textarea>
    </div>

    <div class="form-group">
      <label>Lượt xem:</label>
      <input type="text" name="views" value="<%= v.getViews() %>" class="form-control">
    </div>

    <div class="form-group form-check">
      <input class="form-check-input" type="checkbox" name="active" id="active" <%= v.isActive() ? "checked" : "" %>>
      <label class="form-check-label" for="active">Hoạt động</label>
    </div>

    <div class="form-group">
      <label>Danh mục:</label>
      <select name="categoryId" class="form-control" required>
        <option value="">-- Chọn danh mục --</option>
        <%
          Integer curCateId = (v.getCategory()!=null) ? v.getCategory().getId() : null;
          if (categories != null) {
            for (Category c : categories) {
              String sel = (curCateId != null && curCateId.equals(c.getId())) ? "selected" : "";
        %>
          <option value="<%= c.getId() %>" <%= sel %>><%= c.getCategoryname() %></option>
        <%
            }
          }
        %>
      </select>
    </div>

    <div class="form-group">
      <label>Poster hiện tại:</label><br>
      <%
        if (v.getPoster()!=null && !v.getPoster().isEmpty()) {
      %>
        <img src="file:///E:/upload/video/<%= v.getPoster() %>" alt="poster" style="width:120px;height:120px;">
      <%
        } else {
      %>
        <span>Chưa có poster</span>
      <%
        }
      %>
    </div>

    <div class="form-group">
      <label>Chọn poster mới (nếu thay):</label>
      <input type="file" name="poster" class="form-control-file" accept="image/*">
    </div>

    <button type="submit" class="btn btn-primary w-100">Cập nhật</button>
    <a href="${pageContext.request.contextPath}/admin/videos" class="btn btn-secondary w-100 mt-2">Quay lại</a>
  </form>
</body>
</html>
