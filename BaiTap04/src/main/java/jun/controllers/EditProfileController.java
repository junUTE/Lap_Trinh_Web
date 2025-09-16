package jun.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import jun.entities.User;
import jun.services.UserService;
import jun.services.UserServiceImpl.UserServiceImpl;

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,   // 1MB
    maxFileSize = 1024 * 1024 * 10,   // 10MB
    maxRequestSize = 1024 * 1024 * 50 // 50MB
)
@WebServlet(urlPatterns = {"/profile"})
public class EditProfileController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        User account = (session != null) ? (User) session.getAttribute("account") : null;

        if (account == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Lấy lại user mới nhất từ DB
        User currentUser = userService.getIdUser(account.getId());
        req.setAttribute("user", currentUser);

        // Forward sang JSP
        RequestDispatcher rd = req.getRequestDispatcher("/views/profile.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        HttpSession session = req.getSession(false);
        User account = (session != null) ? (User) session.getAttribute("account") : null;

        if (account == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        try {
            String fullName = req.getParameter("fullName");
            String sdt = req.getParameter("sdt");

            User currentUser = userService.getIdUser(account.getId());
            currentUser.setFullName(fullName);
            currentUser.setSdt(sdt);

            // Upload avatar
            Part avatarPart = req.getPart("avatar");
            if (avatarPart != null && avatarPart.getSize() > 0) {
                String realPath = req.getServletContext().getRealPath("/uploads");
                File dir = new File(realPath);
                if (!dir.exists()) dir.mkdirs();

                String fileName = UUID.randomUUID().toString() + "_" +
                        Paths.get(avatarPart.getSubmittedFileName()).getFileName().toString();

                avatarPart.write(realPath + File.separator + fileName);
                currentUser.setAvatar("uploads/" + fileName);
            }

            userService.edit(currentUser);

            // cập nhật session
            session.setAttribute("account", currentUser);
            session.setAttribute("successMessage", "Cập nhật thành công!");

            resp.sendRedirect(req.getContextPath() + "/user/profile");

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Có lỗi xảy ra: " + e.getMessage());
            doGet(req, resp);
        }
    }
}
