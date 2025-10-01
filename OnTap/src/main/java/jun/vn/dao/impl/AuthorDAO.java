package jun.vn.dao.impl;

import jun.vn.dao.IAuthorDAO;
import jun.vn.entities.Author;
import jun.vn.utils.JPAUtil;

import jakarta.persistence.EntityManager;
import java.util.List;

public class AuthorDAO implements IAuthorDAO {

    @Override
    public void save(Author author) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(author);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Author author) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(author);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Author a = em.find(Author.class, id);
            if (a != null) {
                em.getTransaction().begin();
                em.remove(a);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public Author findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Author.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Author> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
        } finally {
            em.close();
        }
    }
}
