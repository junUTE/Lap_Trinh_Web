package jun.controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jun.dao.UserDao;
import jun.dao.UserDaoImpl.UserDaoImpl;
import jun.entities.User;
import jun.utils.constant;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/Register.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String userName = req.getParameter("userName");
        String hoTen = req.getParameter("hoTen");
        String email = req.getParameter("email");
        String sdt = req.getParameter("SDT");
        String passWord = req.getParameter("passWord");

        String alertMsg = "";

        // check email
        if (userDao.checkExistEmail(email)) {
            alertMsg = "Email đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(constant.Path.REGISTER).forward(req, resp);
            return;
        }

        // check username
        if (userDao.checkExistUsername(userName)) {
            alertMsg = "Tài khoản đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(constant.Path.REGISTER).forward(req, resp);
            return;
        }

        // check phone
        if (userDao.checkExistPhone(sdt)) {
            alertMsg = "Số điện thoại đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(constant.Path.REGISTER).forward(req, resp);
            return;
        }

        // tạo user entity
        User user = new User();
        user.setUserName(userName);
        user.setFullName(hoTen);
        user.setEmail(email);
        user.setSdt(sdt);
        user.setPassWord(passWord);

        // lưu DB
        try {
            userDao.insert(user);
            resp.sendRedirect(req.getContextPath() + "/login");
        } catch (Exception e) {
            alertMsg = "Lỗi hệ thống, vui lòng thử lại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(constant.Path.REGISTER).forward(req, resp);
        }
    }
}
