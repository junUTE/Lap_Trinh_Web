package quoctrung.services.UserServiceImpl;

import java.io.File;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import quoctrung.dao.CategoryDAO;
import quoctrung.dao.UserDaoImpl.CategoryDAOImpl;
import quoctrung.models.Category;
import quoctrung.services.CategoryService;


public class CategoryServiceImpl implements CategoryService {
	
	CategoryDAO categoryDao = new CategoryDAOImpl();

	@Override
	public void insert(Category category) {
		categoryDao.insert(category);
		
	}

	@Override
	public void edit(Category category) {
		// lấy dữ liệu cũ từ DB
	    Category oldCategory = categoryDao.get(category.getCateid());
	    if (oldCategory == null) {
	        throw new IllegalArgumentException("Category not found with id = " + category.getCateid());
	    }

	    // cập nhật tên
	    oldCategory.setCatename(category.getCatename());

	    // nếu có icon mới
	    if (category.getIcon() != null) {
	        // xóa file icon cũ
	        String fileName = oldCategory.getIcon();
	        final String dir = "E:/upload";
	        File file = new File(dir + "/category/" + fileName);
	        if (file.exists()) {
	            file.delete();
	        }
	        // set icon mới
	        oldCategory.setIcon(category.getIcon());
	    }

	    // update DB
	    categoryDao.edit(oldCategory);
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);
		
	}

	@Override
	public Category get(int id) {
		return categoryDao.get(id);
	}

	@Override
	public Category get(String name) {
		return categoryDao.get(name);
	}

	@Override
	public List<Category> getAll() {
		return categoryDao.getAll();
	}

	@Override
	public List<Category> search(String keyword) {
		return categoryDao.search(keyword);
	}
}
