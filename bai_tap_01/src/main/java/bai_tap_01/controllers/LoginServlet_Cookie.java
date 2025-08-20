package bai_tap_01.controllers;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login" })
public class LoginServlet_Cookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet_Cookie() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Login failed. Incorrect username or password.");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
    	//lấy dữ liệu từ tham số của form
    	String user = request.getParameter("username");
    	String pass = request.getParameter("password");
    	if(user.equals("trung") && pass.equals("123"))
    	{
    	Cookie cookie = new Cookie("username", user); //khởi tạo cookie
    	//thiết lập thời gian tồn tại 30s của cookie
    	cookie.setMaxAge(30);
    	//thêm cookie vào response
    	response.addCookie(cookie);
    	//chuyển sang trang HelloServlet
    	response.sendRedirect(request.getContextPath() + "/hello");
    	}
    	else {
    	//chuyển sang trang LoginServlet
    	response.sendRedirect(request.getContextPath() + "/login");
    	}
	}

}
