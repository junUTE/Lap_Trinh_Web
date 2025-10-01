package jun.vn.services.impl;

import jun.vn.dao.IAuthorDAO;
import jun.vn.dao.impl.AuthorDAO;
import jun.vn.entities.Author;
import jun.vn.services.IAuthorService;

import java.util.List;

public class AuthorService implements IAuthorService {
    private IAuthorDAO authorDAO = new AuthorDAO();

    @Override
    public void save(Author author) {
        authorDAO.save(author);
    }

    @Override
    public void update(Author author) {
        authorDAO.update(author);
    }

    @Override
    public void delete(int id) {
        authorDAO.delete(id);
    }

    @Override
    public Author findById(int id) {
        return authorDAO.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorDAO.findAll();
    }
}
