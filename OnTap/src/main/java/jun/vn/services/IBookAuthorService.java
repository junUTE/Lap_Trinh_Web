package jun.vn.services;

import jun.vn.entities.BookAuthor;
import java.util.List;

public interface IBookAuthorService {
    void save(BookAuthor bookAuthor);
    void delete(int bookId, int authorId);
    List<BookAuthor> findByBookId(int bookId);
    List<BookAuthor> findByAuthorId(int authorId);
}
