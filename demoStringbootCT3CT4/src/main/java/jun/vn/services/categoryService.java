package jun.vn.services;

import java.util.List;
import java.util.Optional;


import jun.vn.entities.category;

public interface categoryService {
	// Lấy tất cả user
    List<category> findAll();

    // Lấy user theo ID
    Optional<category> findById(Integer id);

    // Thêm hoặc cập nhật user
    category save(category Category);

    // Xoá user theo ID
    void deleteById(Integer id);

	List<category> findByCategoryNameContaining(String name);
}
