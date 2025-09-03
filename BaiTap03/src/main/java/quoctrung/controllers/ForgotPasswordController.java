package quoctrung.controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import quoctrung.services.UserService;
import quoctrung.services.UserServiceImpl.UserServiceImpl;

@WebServlet("/forgotPassword")
public class ForgotPasswordController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // hiển thị form quên mật khẩu
        RequestDispatcher rd = req.getRequestDispatcher("/views/forgotPassword.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String email = req.getParameter("email");
        String newPassword = req.getParameter("newPassword");
        UserService service = new UserServiceImpl();
        String alertMsg = "";

        if (email == null || email.isEmpty()) {
            alertMsg = "Vui lòng nhập email";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
            return;
        }

        // kiểm tra email có tồn tại không
        if (!service.checkExistEmail(email)) {
            alertMsg = "Email không tồn tại trong hệ thống";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
            return;
        }

        // nếu email tồn tại và người dùng nhập mật khẩu mới
        if (newPassword != null && !newPassword.isEmpty()) {
            boolean isUpdated = service.updatePasswordByEmail(email, newPassword);
            if (isUpdated) {
                // đổi mật khẩu thành công
                resp.sendRedirect(req.getContextPath() + "/login");
                return;
            } else {
                alertMsg = "Lỗi hệ thống, không thể cập nhật mật khẩu.";
                req.setAttribute("alert", alertMsg);
            }
        } else {
            alertMsg = "Vui lòng nhập mật khẩu mới.";
            req.setAttribute("alert", alertMsg);
        }

        req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
    }
}
