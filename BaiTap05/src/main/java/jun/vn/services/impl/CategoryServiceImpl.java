package jun.vn.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import jun.vn.entities.CategoryEntity;
import jun.vn.services.ICategoryService;
import jun.vn.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository repo;

    public CategoryServiceImpl(CategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public Page<CategoryEntity> search(String keyword, Pageable pageable) {
        if (keyword != null && !keyword.isBlank()) {
            return repo.findByNameContainingIgnoreCase(keyword, pageable);
        }
        return repo.findAll(pageable);
    }

    @Override
    public CategoryEntity save(CategoryEntity category) {
        return repo.save(category);
    }

    @Override
    public CategoryEntity get(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
