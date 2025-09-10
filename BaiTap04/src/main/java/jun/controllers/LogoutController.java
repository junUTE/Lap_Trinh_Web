package jun.controllers;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        HttpSession session = req.getSession(false); // không tạo mới
	        if (session != null) {
	            session.invalidate(); // hủy toàn bộ session
	        }

	        // quay về trang login
	        resp.sendRedirect(req.getContextPath() + "/login");
	    }

}
