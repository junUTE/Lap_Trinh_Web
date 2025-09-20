<%@page import="jun.vn.entity.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    Category category = (Category) request.getAttribute("category");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa danh mục</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f6fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form-container {
            width: 420px;
            background: #fff;
            padding: 25px 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.15);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #2f3640;
        }
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 6px;
            color: #353b48;
        }
        input[type="text"],
        input[type="file"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #dcdde1;
            border-radius: 6px;
            font-size: 14px;
        }
        img {
            display: block;
            margin: 10px auto 15px auto;
            border: 1px solid #ccc;
            border-radius: 6px;
        }
        button {
            width: 100%;
            padding: 12px;
            background: #44bd32;
            border: none;
            border-radius: 6px;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background: #4cd137;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 12px;
            color: #718093;
            text-decoration: none;
            font-size: 14px;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Sửa danh mục</h2>
        <form action="${pageContext.request.contextPath}/admin/category/edit" 
              method="post" enctype="multipart/form-data">
            
            <input type="hidden" name="id" value="<%= category.getId() %>">

            <!-- Tên danh mục -->
            <div>
                <label for="name">Tên danh mục:</label>
                <input type="text" id="name" name="name" value="<%= category.getCategoryname() %>" required>
            </div>

            <!-- Icon hiện tại -->
            <div>
                <label>Icon hiện tại:</label>
                <%
                    if (category.getImage() != null) {
                %>
                    <img src="file:///E:/upload/category/<%= category.getImage() %>" 
                         alt="icon" style="width:100px;height:100px;">
                <%
                    } else {
                %>
                    <span>Chưa có icon</span>
                <%
                    }
                %>
            </div>

            <!-- Upload icon mới -->
            <div>
                <label for="icon">Chọn icon mới (nếu muốn thay):</label>
                <input type="file" id="icon" name="icon" accept="image/*">
            </div>

            <!-- Trạng thái -->
            <div>
                <label for="status">Trạng thái:</label>
                <select id="status" name="status">
                    <option value="1" <%= (category.getStatus() != null && category.getStatus() == 1) ? "selected" : "" %>>Hoạt động</option>
                    <option value="0" <%= (category.getStatus() != null && category.getStatus() == 0) ? "selected" : "" %>>Ngưng</option>
                </select>
            </div>

            <button type="submit">Cập nhật</button>
            <a class="back-link" href="${pageContext.request.contextPath}/admin/categories">Quay lại</a>
        </form>
    </div>
</body>
</html>
