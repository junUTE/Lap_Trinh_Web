package jun.vn.controllers.auth;

import jun.vn.entities.User;
import jun.vn.services.IUserService;
import jun.vn.services.impl.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/auth/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String fullname = req.getParameter("fullname");
        String passwd = req.getParameter("passwd");

        User user = new User();
        user.setEmail(email);
        user.setFullname(fullname);
        user.setPasswd(passwd);
        user.setIs_admin(false);
        user.setSignup_date(new Date());
        user.setLast_login(null);

        if (userService.register(user)) {
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            req.setAttribute("error", "Email đã tồn tại");
            req.getRequestDispatcher("/views/auth/register.jsp").forward(req, resp);
        }
    }
}
