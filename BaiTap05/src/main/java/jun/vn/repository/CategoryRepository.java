package jun.vn.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jun.vn.entities.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	List<CategoryEntity> findByNameContainingIgnoreCase(String name);

	Page<CategoryEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
