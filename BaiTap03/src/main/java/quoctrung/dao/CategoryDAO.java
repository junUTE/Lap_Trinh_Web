package quoctrung.dao;

import java.util.List;

import quoctrung.models.Category;

public interface CategoryDAO {
	void insert(quoctrung.models.Category category);

	void edit(Category category);

	void delete(int id);

	Category get(int id);

	Category get(String name);

	List<Category> getAll();

	List<Category> search(String keyword);
}
