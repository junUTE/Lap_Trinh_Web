<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            background-color: #f9fafb;
        }
        main {
            flex: 1;
            display: flex;
            flex-direction: column;
            justify-content: flex-start; /* đẩy header lên trên */
            align-items: center;
            padding-top: 15vh; /* chiếm khoảng 15% chiều cao từ trên xuống */
        }
        footer {
            background-color: #f8fafc;
            border-top: 1px solid #e5e7eb;
            padding: 1rem;
            text-align: center;
        }
    </style>
</head>
<body>

    <!-- Header + Content -->
    <main>
        
        <h2 style="font-size: 1.8rem; font-weight: bold; color: #2563eb; margin-top: 1rem;">
            📂 Category Management
        </h2>

        <p style="color: #4b5563; font-size: 1rem; max-width: 330px; margin-top: 0.5rem;">
            Manage your product categories with ease.
        </p>

        <div style="display: flex; gap: 1rem; margin-top: 1rem;">
            <a href="${pageContext.request.contextPath}/login" 
               class="btn btn-primary px-4 py-2 rounded-pill shadow-sm">
                Đăng nhập
            </a>
            <a href="${pageContext.request.contextPath}/register" 
               class="btn btn-success px-4 py-2 rounded-pill shadow-sm">
                Đăng ký
            </a>
        </div>
    </main>

    <!-- Footer -->
    <footer>
        <p style="color: #4b5563; font-size: 0.9rem; margin: 0;">
            Sinh viên thực hiện: Vũ Quốc Trung - MSSV: 23110353
        </p>
        <p style="color: #6b7280; font-size: 0.8rem; margin-top: 0.5rem;">
            &copy; 2025 Category Management System. All rights reserved.
        </p>
    </footer>

</body>
</html>
