package jun.vn.controllers.admin;

import jun.vn.entities.Author;
import jun.vn.services.IAuthorService;
import jun.vn.services.impl.AuthorService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/authors")
public class AuthorController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IAuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> authors = authorService.findAll();
        req.setAttribute("authors", authors);
        req.getRequestDispatcher("/views/admin/author/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("create".equals(action)) {
            String name = req.getParameter("authorName");
            Author a = new Author();
            a.setAuthorName(name);
            authorService.save(a);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            authorService.delete(id);
        }
        resp.sendRedirect(req.getContextPath() + "/admin/authors");
    }
}
