package jun.vn.dao.impl;

import jun.vn.dao.IBookAuthorDAO;
import jun.vn.entities.BookAuthor;
import jun.vn.entities.BookAuthorId;
import jun.vn.utils.JPAUtil;

import jakarta.persistence.EntityManager;
import java.util.List;

public class BookAuthorDAO implements IBookAuthorDAO {

    @Override
    public void save(BookAuthor bookAuthor) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(bookAuthor);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(int bookId, int authorId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            BookAuthor ba = em.find(BookAuthor.class, new BookAuthorId(bookId, authorId));
            if (ba != null) {
                em.getTransaction().begin();
                em.remove(ba);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public List<BookAuthor> findByBookId(int bookId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT ba FROM BookAuthor ba WHERE ba.bookId = :bid", BookAuthor.class)
                     .setParameter("bid", bookId).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<BookAuthor> findByAuthorId(int authorId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT ba FROM BookAuthor ba WHERE ba.authorId = :aid", BookAuthor.class)
                     .setParameter("aid", authorId).getResultList();
        } finally {
            em.close();
        }
    }
}
