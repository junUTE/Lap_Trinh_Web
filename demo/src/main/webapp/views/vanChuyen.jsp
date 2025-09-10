<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đơn mua - Vận chuyển</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background: #f5f5f5; }
        .sidebar {
            background: #fff;
            padding: 15px;
            border-right: 1px solid #ddd;
            height: 100vh;
        }
        .sidebar h5 { margin-bottom: 20px; }
        .tab-menu .nav-link { color: #333; }
        .tab-menu .nav-link.active {
            color: #d0011b;
            border-bottom: 2px solid #d0011b;
            font-weight: bold;
        }
        .empty-order {
            text-align: center;
            padding: 80px 20px;
            background: #fff;
            border-radius: 6px;
        }
        .empty-order img {
            width: 120px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <!-- Sidebar -->
        <div class="col-md-2 sidebar">
            <h5>Tài khoản của tôi</h5>
            <ul class="nav flex-column">
                <li class="nav-item"><a href="#" class="nav-link">Thông báo</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Tài khoản</a></li>
                <li class="nav-item"><a href="donMua.jsp" class="nav-link fw-bold">Đơn mua</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Kho Voucher</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Xu tích luỹ</a></li>
            </ul>
        </div>

        <!-- Main content -->
        <div class="col-md-10">
            <div class="bg-white p-3 mb-3 tab-menu">
                <ul class="nav nav-tabs border-0">
                    <li class="nav-item"><a class="nav-link" href="donMua.jsp">Tất cả</a></li>
                    <li class="nav-item"><a class="nav-link" href="choXacNhan.jsp">Chờ xác nhận</a></li>
                    <li class="nav-item"><a class="nav-link active" href="vanChuyen.jsp">Vận chuyển</a></li>
                    <li class="nav-item"><a class="nav-link" href="choGiaoHang.jsp">Chờ giao hàng</a></li>
                    <li class="nav-item"><a class="nav-link" href="hoanThanh.jsp">Hoàn thành</a></li>
                    <li class="nav-item"><a class="nav-link" href="daHuy.jsp">Đã hủy</a></li>
                </ul>
            </div>

            <!-- Empty orders -->
            <div class="empty-order">
                <img src="https://cdn-icons-png.flaticon.com/512/4076/4076549.png" alt="empty">
                <p>Chưa có đơn hàng</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
