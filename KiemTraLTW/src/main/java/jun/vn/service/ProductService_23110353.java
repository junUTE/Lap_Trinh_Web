package jun.vn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jun.vn.entity.Product_23110353;

import java.util.List;
import java.util.Optional;

public interface ProductService_23110353 {
    List<Product_23110353> findAll();
    Page<Product_23110353> findAll(Pageable pageable);
    Optional<Product_23110353> findById(int id);
    Product_23110353 save(Product_23110353 product);
    void deleteById(int id);

    // Nghiệp vụ thêm
    List<Product_23110353> searchByName(String name);
    Page<Product_23110353> searchByName(String name, Pageable pageable);
    List<Product_23110353> findByCategory(int categoryId);
    List<Product_23110353> findBySeller(int sellerId);
    List<Product_23110353> findByStatus(Integer status);
}

