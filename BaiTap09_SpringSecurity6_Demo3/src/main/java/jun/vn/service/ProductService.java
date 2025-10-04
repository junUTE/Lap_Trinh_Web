package jun.vn.service;

import java.util.List;

import jun.vn.entity.Product;

public interface ProductService {
	void delete(Long id);

	Product get(Long id);

	Product save(Product product);

	List<Product> listAll();
}
