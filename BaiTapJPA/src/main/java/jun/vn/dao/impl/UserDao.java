package jun.vn.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jun.vn.configs.JPAConfig;
import jun.vn.dao.IUserDao;
import jun.vn.entity.User;

public class UserDao implements IUserDao {

	
	@Override
	public boolean register(User user) {
	    EntityManager em = JPAConfig.getEntityManager();
	    EntityTransaction trans = em.getTransaction();
	    try {
	        trans.begin();
	        em.persist(user);   // lưu user mới
	        trans.commit();
	        return true;        // thành công
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        if (trans.isActive()) trans.rollback();
	        return false;       // thất bại
	    } finally {
	        if (em.isOpen()) em.close();
	    }
	}

    // Đăng nhập
    @Override
	public User login(String username, String password) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            String jpql = "SELECT u FROM User u WHERE u.userName = :username AND u.passWord = :password";
            TypedQuery<User> query = em.createQuery(jpql, User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            List<User> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    @Override
	public void update(User user) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(user);
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
	public void delete(int id) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            User user = em.find(User.class, id);
            if (user != null) {
                em.remove(user);
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
	public User findById(int id) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    @Override
	public List<User> findAll() {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
            return query.getResultList();
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    @Override
	public User findByUserName(String userName) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            String jpql = "SELECT u FROM User u WHERE u.userName = :userName";
            TypedQuery<User> query = em.createQuery(jpql, User.class);
            query.setParameter("userName", userName);
            List<User> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } finally {
            if (em.isOpen()) em.close();
        }
    }
    @Override
    public boolean checkExistEmail(String email) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            Long count = em.createQuery(
                "SELECT COUNT(u) FROM User u WHERE u.email = :email", Long.class)
                .setParameter("email", email)
                .getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean checkExistUsername(String userName) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            Long count = em.createQuery(
                "SELECT COUNT(u) FROM User u WHERE u.userName = :userName", Long.class)
                .setParameter("userName", userName)
                .getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }
}
