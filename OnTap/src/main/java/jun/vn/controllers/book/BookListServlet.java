package jun.vn.controllers.book;

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


@WebServlet("/books")
public class BookListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IBookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.findAll();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/views/book/list.jsp").forward(req, resp);
    }
}

