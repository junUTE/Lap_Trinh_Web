package jun.vn.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

import jun.vn.configs.JPAConfig;
import jun.vn.dao.ICategoryDao;
import jun.vn.entity.Category;

public class CategoryDao implements ICategoryDao {
	@Override
	public void insert(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(category);
			trans.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			trans.rollback();
			throw ex;
		} finally {
			enma.close();
		}
	}

	@Override
	public void update(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(category);
			trans.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			trans.rollback();
			throw ex;
		} finally {
			enma.close();
		}
	}

	@Override
	public void delete(int cateId) {
	    EntityManager enma = JPAConfig.getEntityManager();
	    EntityTransaction trans = enma.getTransaction();
	    try {
	        trans.begin();

	        Category category = enma.find(Category.class, cateId);
	        if (category != null) {
	            enma.remove(category);
	        } else {
	            throw new Exception("Category not found with id = " + cateId);
	        }

	        trans.commit();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        if (trans.isActive()) {
	            trans.rollback();
	        }
	        throw new RuntimeException(ex);
	    } finally {
	        if (enma.isOpen()) {
	            enma.close();
	        }
	    }
	}


	@Override
	public Category findById(int cateId) {
		EntityManager enma = JPAConfig.getEntityManager();
		Category category = enma.find(Category.class, cateId);
		return category;
	}
	
	@Override
	public List<Category> findAll(){
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
		return query.getResultList();
		
	}
	
	@Override
	public List<Category> findByCategoryname(String catname) {
	    EntityManager enma = JPAConfig.getEntityManager();
	    String jpql = "SELECT c FROM Category c WHERE c.catename LIKE :catename";
	    TypedQuery<Category> query = enma.createQuery(jpql, Category.class);
	    query.setParameter("catename", "%" + catname + "%");
	    return query.getResultList();
	}
	
	@Override
	public List<Category> findAll(int page, int pageSize) {
	    EntityManager enma = JPAConfig.getEntityManager();
	    TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
	    query.setFirstResult(page * pageSize);
	    query.setMaxResults(pageSize);
	    return query.getResultList();
	}
	
	@Override
	public int count() {
	    EntityManager enma = JPAConfig.getEntityManager();
	    String jpql = "SELECT COUNT(c) FROM Category c";
	    Query query = enma.createQuery(jpql);
	    Long result = (Long) query.getSingleResult();
	    return result.intValue();
	}
}
