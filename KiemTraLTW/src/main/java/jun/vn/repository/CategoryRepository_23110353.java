package jun.vn.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import jun.vn.entity.Category_23110353;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository_23110353 extends JpaRepository<Category_23110353, Integer> {

    // Tìm kiếm theo tên chứa chuỗi
    List<Category_23110353> findByCategoryNameContaining(String name);

    // Tìm kiếm + phân trang
    Page<Category_23110353> findByCategoryNameContaining(String name, Pageable pageable);

    // Tìm chính xác theo tên
    Optional<Category_23110353> findByCategoryName(String name);

    // Lọc theo trạng thái
    List<Category_23110353> findByStatus(Integer status);
}
