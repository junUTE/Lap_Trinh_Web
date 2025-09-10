package jun.controllers;

import java.io.IOException;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jun.dao.UserDao;
import jun.dao.UserDaoImpl.UserDaoImpl;
import jun.entities.User;

@WebServlet(urlPatterns = "/login")

public class LoginController extends HttpServlet  {

	private static final long serialVersionUID = 1L;
	
	private UserDao userDAO = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/Login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("userName");
        String password = req.getParameter("passWord");

        if (username.isEmpty() || password.isEmpty()) {
            req.setAttribute("alert", "Tài khoản hoặc mật khẩu không được rỗng");
            req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
            return;
        }

        User user = userDAO.login(username, password);
        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            req.setAttribute("alert", "Tài khoản hoặc mật khẩu không đúng");
            req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
        }
    }
}
