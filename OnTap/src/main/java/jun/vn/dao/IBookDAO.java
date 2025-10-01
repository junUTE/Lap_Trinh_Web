package jun.vn.dao;

import jun.vn.entities.Book;
import java.util.List;

public interface IBookDAO {
    void save(Book book);
    void update(Book book);
    void delete(int id);
    Book findById(int id);
    List<Book> findAll();
    List<Book> findByTitle(String keyword);
}
