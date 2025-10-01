package jun.vn.dao;

import jun.vn.entities.Author;
import java.util.List;

public interface IAuthorDAO {
    void save(Author author);
    void update(Author author);
    void delete(int id);
    Author findById(int id);
    List<Author> findAll();
}
