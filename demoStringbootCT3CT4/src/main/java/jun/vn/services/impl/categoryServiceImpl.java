package jun.vn.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jun.vn.Respository.CategoryRepository;
import jun.vn.entities.category;
import jun.vn.services.categoryService;

@Service
public class categoryServiceImpl implements categoryService {

	@Autowired
    private CategoryRepository categoryRepository;
	
	@Override
	public List<category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<category> findById(Integer id) {
		return categoryRepository.findById(id);
	}

	@Override
	public category save(category Category) {
		return categoryRepository.save(Category);
	}

	@Override
	public void deleteById(Integer id) {
		categoryRepository.deleteById(id);		
	}

	@Override
	public List<category> findByCategoryNameContaining(String name) {
		return categoryRepository.findByCategoryNameContaining(name);
	}

}
