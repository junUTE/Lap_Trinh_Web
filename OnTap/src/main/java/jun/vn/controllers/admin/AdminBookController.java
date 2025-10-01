package jun.vn.controllers.admin;

import jun.vn.entities.Book;
import jun.vn.services.IBookService;
import jun.vn.services.impl.BookService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/books"})
public class AdminBookController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IBookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
        int size = 5;

        List<Book> books = bookService.findAll(); // TODO: sửa thành phân trang bằng DAO
        req.setAttribute("books", books);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/views/admin/book/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // xử lý thêm / sửa / xóa book
    }
}
