package jun.vn.services;

import jun.vn.entities.Book;
import java.util.List;

public interface IBookService {
    void save(Book book);
    void update(Book book);
    void delete(int id);
    Book findById(int id);
    List<Book> findAll();
    List<Book> findByTitle(String keyword);
}
