package jun.vn.dao.impl;

import jun.vn.dao.IBookDAO;
import jun.vn.entities.Book;
import jun.vn.utils.JPAUtil;


import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class BookDAO implements IBookDAO {

    @Override
    public void save(Book book) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Book book) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(book);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Book b = em.find(Book.class, id);
            if (b != null) {
                em.getTransaction().begin();
                em.remove(b);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public Book findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Book.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Book> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Book> findByTitle(String keyword) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Book> q = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :kw", Book.class);
            q.setParameter("kw", "%" + keyword + "%");
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}
