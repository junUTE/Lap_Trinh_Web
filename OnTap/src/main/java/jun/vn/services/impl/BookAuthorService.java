package jun.vn.services.impl;

import jun.vn.dao.IBookAuthorDAO;
import jun.vn.dao.impl.BookAuthorDAO;
import jun.vn.entities.BookAuthor;
import jun.vn.services.IBookAuthorService;

import java.util.List;

public class BookAuthorService implements IBookAuthorService {
    private IBookAuthorDAO bookAuthorDAO = new BookAuthorDAO();

    @Override
    public void save(BookAuthor bookAuthor) {
        bookAuthorDAO.save(bookAuthor);
    }

    @Override
    public void delete(int bookId, int authorId) {
        bookAuthorDAO.delete(bookId, authorId);
    }

    @Override
    public List<BookAuthor> findByBookId(int bookId) {
        return bookAuthorDAO.findByBookId(bookId);
    }

    @Override
    public List<BookAuthor> findByAuthorId(int authorId) {
        return bookAuthorDAO.findByAuthorId(authorId);
    }
}
