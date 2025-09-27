package jun.vn.services.impl;

import jun.vn.entities.CategoryEntity;
import jun.vn.repository.CategoryRepository;
import jun.vn.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<CategoryEntity> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public CategoryEntity save(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(CategoryEntity category) {
        categoryRepository.delete(category);
    }

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return categoryRepository.count();
	}

	@Override
	public <S extends CategoryEntity> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return categoryRepository.findOne(example);
	}

	@Override
	public List<CategoryEntity> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return categoryRepository.findAllById(ids);
	}

	@Override
	public List<CategoryEntity> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return categoryRepository.findAll(sort);
	}

	@Override
	public Page<CategoryEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return categoryRepository.findAll(pageable);
	}

	@Override
	public Optional<CategoryEntity> findByCategoryName(String name) {
		// TODO Auto-generated method stub
		return categoryRepository.findByCategoryName(name);
	}

	@Override
	public Page<CategoryEntity> findByCategoryNameContaining(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return categoryRepository.findByCategoryNameContaining(name, pageable);
	}

	@Override
	public List<CategoryEntity> findByCategoryNameContaining(String name) {
		// TODO Auto-generated method stub
		return categoryRepository.findByCategoryNameContaining(name);
	}

    
}
