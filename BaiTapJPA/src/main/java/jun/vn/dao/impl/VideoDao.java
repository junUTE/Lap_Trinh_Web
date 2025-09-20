package jun.vn.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jun.vn.configs.JPAConfig;
import jun.vn.dao.IVideoDao;
import jun.vn.entity.Video;

public class VideoDao implements IVideoDao {

    @Override
	public void insert(Video video) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(video);
            trans.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (trans.isActive()) trans.rollback();
            throw new RuntimeException(ex);
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    @Override
	public void update(Video video) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(video);
            trans.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (trans.isActive()) trans.rollback();
            throw new RuntimeException(ex);
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    @Override
	public void delete(String videoId) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            Video video = em.find(Video.class, videoId);
            if (video != null) {
                em.remove(video);
            }
            trans.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (trans.isActive()) trans.rollback();
            throw new RuntimeException(ex);
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    @Override
	public Video findById(String videoId) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            return em.find(Video.class, videoId);
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    @Override
	public List<Video> findAll() {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            TypedQuery<Video> query = em.createNamedQuery("Video.findAll", Video.class);
            return query.getResultList();
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    @Override
	public List<Video> findByTitle(String keyword) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            String jpql = "SELECT v FROM Video v WHERE v.title LIKE :title";
            TypedQuery<Video> query = em.createQuery(jpql, Video.class);
            query.setParameter("title", "%" + keyword + "%");
            return query.getResultList();
        } finally {
            if (em.isOpen()) em.close();
        }
    }
}
