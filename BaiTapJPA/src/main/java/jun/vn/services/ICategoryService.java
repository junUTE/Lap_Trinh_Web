package jun.vn.services;

import java.util.List;

import jun.vn.entity.Category;

public interface ICategoryService {
	int count();

	List<Category> findAll(int page, int pageSize);

	List<Category> findByCategoryname(String catname);

	List<Category> findAll();

	Category findById(int cateId);

	void delete(int cateiId);

	void update(Category category);

	void insert(Category category);

	Category getId(int id);
}
