package jun.vn.services;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import jun.vn.entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
	void deleteById(Long id);

	void delete(Category entity);

	<S extends Category> Optional<S> findOne(Example<S> example);

	long count();

	Page<Category> findAll(Pageable pageable);

	List<Category> findAllById(Iterable<Long> ids);

	Optional<Category> findById(Long id);

	Optional<Category> findByCategoryName(String name);

	List<Category> findAll();

	List<Category> findAll(Sort sort);

	Page<Category> findByCategoryNameContaining(String name, Pageable pageable);

	<S extends Category> S save(S entity);

	List<Category> findByCategoryNameContaining(String name);
}
