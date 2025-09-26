package jun.vn.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import jun.vn.entities.Product;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface IProductService {
	void delete(Product entity);

	void deleteById(Long id);

	void deleteAll();

	long count();

	List<Product> findAll();

	List<Product> findAllById(Iterable<Long> ids);

	List<Product> findAll(Sort sort);

	Optional<Product> findById(Long id);

	Page<Product> findAll(Pageable pageable);

	<S extends Product> S save(S entity);

	List<Product> findByNameContaining(String name);

	Optional<Product> findByCreateDate(Timestamp timestamp);

	Optional<Product> findByProductName(String productName);

	Page<Product> findByNameContaining(String name, Pageable pageable);
	
	List<Product> findByCategoryId(Long categoryId);

}
