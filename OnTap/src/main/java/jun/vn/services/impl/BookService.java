package jun.vn.services.impl;

import jun.vn.dao.IBookDAO;
import jun.vn.dao.impl.BookDAO;
import jun.vn.entities.Book;
import jun.vn.services.IBookService;

import java.util.List;

public class BookService implements IBookService {
    private IBookDAO bookDAO = new BookDAO();

    @Override
    public void save(Book book) {
        bookDAO.save(book);
    }

    @Override
    public void update(Book book) {
        bookDAO.update(book);
    }

    @Override
    public void delete(int id) {
        bookDAO.delete(id);
    }

    @Override
    public Book findById(int id) {
        return bookDAO.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public List<Book> findByTitle(String keyword) {
        return bookDAO.findByTitle(keyword);
    }
}
