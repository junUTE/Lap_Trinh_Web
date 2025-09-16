package jun.vn.Respository;

import jun.vn.entities.category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository; // import đúng interface này
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<category, Integer> {

    // Tìm Kiếm theo nội dung tên
    List<category> findByCategoryNameContaining(String name);

    // Tìm kiếm và Phân trang
    Page<category> findByCategoryNameContaining(String name, Pageable pageable);
}