package jun.vn.services;

import jun.vn.entities.Author;
import java.util.List;

public interface IAuthorService {
    void save(Author author);
    void update(Author author);
    void delete(int id);
    Author findById(int id);
    List<Author> findAll();
}
