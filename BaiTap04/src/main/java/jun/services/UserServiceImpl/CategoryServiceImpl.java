package jun.services.UserServiceImpl;

import java.util.List;

import jun.dao.CategoryDAO;
import jun.dao.impl.CategoryDAOImpl;
import jun.entities.Category;
import jun.services.CategoryService;

public class CategoryServiceImpl implements CategoryService{

	CategoryDAO cateDao = new CategoryDAOImpl();
	
	@Override
	public void insert(Category category) {
		cateDao.create(category);
	}

	@Override
	public void edit(Category category) {
		cateDao.update(category);		
	}

	@Override
	public void delete(int id) {
		cateDao.remove(id);		
	}

	@Override
	public Category getIdCategory(int id) {
		return cateDao.findById(id);
	}

	@Override
	public Category getNameCategory(String name) {
		return cateDao.findByName(name);
	}

	@Override
	public List<Category> getAll() {
		return cateDao.findAll();
	}

	@Override
	public List<Category> search(String keyword) {
		return cateDao.search(keyword);
	}

}
