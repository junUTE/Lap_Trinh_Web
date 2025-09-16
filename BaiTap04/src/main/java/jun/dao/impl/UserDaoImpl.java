package jun.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jun.configs.JPAConfig;
import jun.dao.UserDao;
import jun.entities.User;


public class UserDaoImpl implements UserDao {

	@Override
	public void insert(User user) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public boolean checkExistEmail(String email) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			String jpql = "SELECT COUNT(u) FROM User u WHERE u.email = :email";
			Long count = em.createQuery(jpql, Long.class).setParameter("email", email).getSingleResult();
			return count > 0;
		} finally {
			em.close();
		}
	}

	@Override
	public boolean checkExistUsername(String username) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			String jpql = "SELECT COUNT(u) FROM User u WHERE u.userName = :username";
			Long count = em.createQuery(jpql, Long.class).setParameter("username", username).getSingleResult();
			return count > 0;
		} finally {
			em.close();
		}
	}

	@Override
	public boolean checkExistPhone(String phone) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			String jpql = "SELECT COUNT(u) FROM User u WHERE u.sdt = :phone";
			Long count = em.createQuery(jpql, Long.class).setParameter("phone", phone).getSingleResult();
			return count > 0;
		} finally {
			em.close();
		}
	}

	@Override
	public User login(String username, String password) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			String jpql = "SELECT u FROM User u WHERE u.userName = :username AND u.passWord = :password";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public boolean updatePasswordByEmail(String email, String newPassword) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			em.getTransaction().begin();
			String jpql = "UPDATE User u SET u.passWord = :newPassword WHERE u.email = :email";
			int updated = em.createQuery(jpql).setParameter("newPassword", newPassword).setParameter("email", email)
					.executeUpdate();
			em.getTransaction().commit();
			return updated > 0;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	@Override
	public boolean update(User user) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			em.getTransaction().begin();
			User existing = em.find(User.class, user.getId());
			if (existing != null) {
				existing.setUserName(user.getUserName());
				existing.setFullName(user.getFullName());
				existing.setEmail(user.getEmail());
				existing.setSdt(user.getSdt());
				existing.setPassWord(user.getPassWord());
				existing.setAvatar(user.getAvatar());
				em.merge(existing);
				em.getTransaction().commit();
				return true;
			}
			return false;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	@Override
	public User findByEmail(String email) {
		EntityManager enma = JPAConfig.getEntityManager();
		try {
			TypedQuery<User> query = enma.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
			query.setParameter("email", email);
			List<User> results = query.getResultList();
			return results.isEmpty() ? null : results.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			enma.close();
		}
	}

	@Override
	public User findById(int id) {
		EntityManager enma = JPAConfig.getEntityManager();
		try {
			return enma.find(User.class, id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			enma.close();
		}
	}
}
