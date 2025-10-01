package jun.vn.controllers.auth;

import jun.vn.entities.User;
import jun.vn.services.IUserService;
import jun.vn.services.impl.UserService;


import java.io.IOException;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({"/login"})
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/auth/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String passwd = req.getParameter("passwd");

        User user = userService.login(email, passwd);

        if (user != null) {
        	 	user.setLast_login(new Date());
        	    userService.update(user);
            // lưu user vào session
            req.getSession().setAttribute("user", user);

            // điều hướng theo role
            if (Boolean.TRUE.equals(user.getIs_admin())) {
                resp.sendRedirect(req.getContextPath() + "/admin/books");
            } else {
                resp.sendRedirect(req.getContextPath() + "/user/books");
            }
        } else {
            req.setAttribute("error", "Sai email hoặc mật khẩu!");
            req.getRequestDispatcher("/views/auth/login.jsp").forward(req, resp);
        }
    }
}