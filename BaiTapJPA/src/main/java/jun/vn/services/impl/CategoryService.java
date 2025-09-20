package jun.vn.services.impl;

import java.util.List;

import jun.vn.dao.ICategoryDao;
import jun.vn.dao.impl.CategoryDao;
import jun.vn.entity.Category;
import jun.vn.services.ICategoryService;

public class CategoryService implements ICategoryService{

	ICategoryDao cateDao = new CategoryDao();
	@Override
	public int count() {
		return cateDao.count();
	}

	@Override
	public List<Category> findAll(int page, int pageSize) {
		return cateDao.findAll();
	}

	@Override
	public List<Category> findByCategoryname(String catname) {
		return cateDao.findByCategoryname(catname);
	}

	@Override
	public List<Category> findAll() {
		return cateDao.findAll();
	}

	@Override
	public Category findById(int cateId) {
		return findById(cateId);
	}

	@Override
	public void delete(int cateiId) {
		cateDao.delete(cateiId);		
	}

	@Override
	public void update(Category category) {
		cateDao.update(category);
	}

	@Override
	public void insert(Category category) {
		cateDao.insert(category);
	}

	@Override
	public Category getId(int id) {
		 return cateDao.findById(id);
	}
}
