package jun.vn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jun.vn.entity.Category_23110353;
import jun.vn.repository.CategoryRepository_23110353;
import jun.vn.service.CategoryService_23110353;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl_23110353 implements CategoryService_23110353 {

    @Autowired
    private CategoryRepository_23110353 repo;

    @Override
    public List<Category_23110353> findAll() {
        return repo.findAll();
    }

    @Override
    public Page<Category_23110353> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Optional<Category_23110353> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Category_23110353 save(Category_23110353 category) {
        return repo.save(category);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<Category_23110353> searchByName(String name) {
        return repo.findByCategoryNameContaining(name);
    }

    @Override
    public Page<Category_23110353> searchByName(String name, Pageable pageable) {
        return repo.findByCategoryNameContaining(name, pageable);
    }

    @Override
    public Optional<Category_23110353> findByNameExact(String name) {
        return repo.findByCategoryName(name);
    }

    @Override
    public List<Category_23110353> findByStatus(Integer status) {
        return repo.findByStatus(status);
    }
}
