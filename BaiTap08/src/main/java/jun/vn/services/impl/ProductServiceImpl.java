package jun.vn.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import jun.vn.entities.Product;
import jun.vn.repositories.ProductRepository;
import jun.vn.services.IProductService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void delete(Product entity) {
		productRepository.delete(entity);

	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);

	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();

	}

	@Override
	public long count() {
		return productRepository.count();
	}

	@Override
	public List<Product> findAll() {

		return productRepository.findAll();
	}

	@Override
	public List<Product> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return productRepository.findAllById(ids);
	}

	@Override
	public List<Product> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return productRepository.findAll(sort);
	}

	@Override
	public Optional<Product> findById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return productRepository.findAll(pageable);
	}

	@Override
	public <S extends Product> S save(S entity) {
		// TODO Auto-generated method stub
		return productRepository.save(entity);
	}

	@Override
	public List<Product> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return productRepository.findByProductNameContaining(name);
	}

	@Override
	public Optional<Product> findByCreateDate(Timestamp timestamp) {
		// TODO Auto-generated method stub
		return productRepository.findByCreateDate(timestamp);
	}

	@Override
	public Optional<Product> findByProductName(String productName) {
		// TODO Auto-generated method stub
		return productRepository.findByProductName(productName);
	}

	@Override
	public Page<Product> findByNameContaining(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return productRepository.findByProductNameContaining(name, pageable);
	}

	@Override
	public List<Product> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return productRepository.findByCategoryCategoryId(categoryId);
	}

}
