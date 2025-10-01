package jun.vn.controllers.book;

import jun.vn.entities.Book;
import jun.vn.entities.Rating;
import jun.vn.entities.User;
import jun.vn.services.IBookService;
import jun.vn.services.IRatingService;
import jun.vn.services.impl.BookService;
import jun.vn.services.impl.RatingService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@WebServlet("/book/detail")
public class BookDetailServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
	private IBookService bookService = new BookService();
    private IRatingService ratingService = new RatingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("id"));
        Book book = bookService.findById(bookId);
        List<Rating> reviews = ratingService.findByBookId(bookId);

        req.setAttribute("book", book);
        req.setAttribute("reviews", reviews);
        req.getRequestDispatcher("/views/book/detail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        String reviewText = req.getParameter("review");

        Rating r = new Rating();
        r.setUserId(user.getId());
        r.setBookId(bookId);
        r.setReviewText(reviewText);
        ratingService.save(r);

        resp.sendRedirect(req.getContextPath() + "/book/detail?id=" + bookId);
    }
}
