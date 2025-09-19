package jun.vn.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jun.vn.entities.CategoryEntity;

public interface ICategoryService {

    Page<CategoryEntity> search(String keyword, Pageable pageable);

    CategoryEntity save(CategoryEntity category);

    CategoryEntity get(Long id);

    void delete(Long id);
}
