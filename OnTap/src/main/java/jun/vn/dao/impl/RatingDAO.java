package jun.vn.dao.impl;

import jun.vn.dao.IRatingDAO;
import jun.vn.entities.Rating;
import jun.vn.entities.RatingId;
import jun.vn.utils.JPAUtil;


import java.util.List;

import jakarta.persistence.EntityManager;

public class RatingDAO implements IRatingDAO {

    @Override
    public void save(Rating rating) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rating);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Rating rating) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(rating);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(int userId, int bookId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Rating r = em.find(Rating.class, new RatingId(userId, bookId));
            if (r != null) {
                em.getTransaction().begin();
                em.remove(r);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public Rating findById(int userId, int bookId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Rating.class, new RatingId(userId, bookId));
        } finally {
            em.close();
        }
    }

    @Override
    public List<Rating> findByBookId(int bookId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT r FROM Rating r WHERE r.bookId = :bid", Rating.class)
                     .setParameter("bid", bookId).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Rating> findByUserId(int userId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT r FROM Rating r WHERE r.userId = :uid", Rating.class)
                     .setParameter("uid", userId).getResultList();
        } finally {
            em.close();
        }
    }
}
