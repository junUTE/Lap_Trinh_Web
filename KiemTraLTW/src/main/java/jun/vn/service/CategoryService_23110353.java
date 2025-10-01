package jun.vn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jun.vn.entity.Category_23110353;

import java.util.List;
import java.util.Optional;

public interface CategoryService_23110353 {
    List<Category_23110353> findAll();
    Page<Category_23110353> findAll(Pageable pageable);
    Optional<Category_23110353> findById(int id);
    Category_23110353 save(Category_23110353 category);
    void deleteById(int id);

    // Nghiệp vụ thêm
    List<Category_23110353> searchByName(String name);
    Page<Category_23110353> searchByName(String name, Pageable pageable);
    Optional<Category_23110353> findByNameExact(String name);
    List<Category_23110353> findByStatus(Integer status);
}
