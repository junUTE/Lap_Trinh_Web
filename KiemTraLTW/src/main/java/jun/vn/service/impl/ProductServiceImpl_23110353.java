package jun.vn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jun.vn.entity.Product_23110353;
import jun.vn.repository.ProductRepository_23110353;
import jun.vn.service.ProductService_23110353;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl_23110353 implements ProductService_23110353 {

    @Autowired
    private ProductRepository_23110353 repo;

    @Override
    public List<Product_23110353> findAll() {
        return repo.findAll();
    }

    @Override
    public Page<Product_23110353> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Optional<Product_23110353> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Product_23110353 save(Product_23110353 product) {
        return repo.save(product);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<Product_23110353> searchByName(String name) {
        return repo.findByProductNameContaining(name);
    }

    @Override
    public Page<Product_23110353> searchByName(String name, Pageable pageable) {
        return repo.findByProductNameContaining(name, pageable);
    }

    @Override
    public List<Product_23110353> findByCategory(int categoryId) {
        return repo.findByCategory_CategoryId(categoryId);
    }

    @Override
    public List<Product_23110353> findBySeller(int sellerId) {
        return repo.findBySeller_SellerId(sellerId);
    }

    @Override
    public List<Product_23110353> findByStatus(Integer status) {
        return repo.findByStatus(status);
    }
}

