package jun.vn.service;

import java.util.List;
import java.util.Optional;

import jun.vn.entity.Seller_23110353;

public interface SellerService_23110353 {
	List<Seller_23110353> findAll();

	Optional<Seller_23110353> findById(Integer id);

	Seller_23110353 save(Seller_23110353 seller);

	void deleteById(Integer id);

	// Nghiệp vụ thêm
	List<Seller_23110353> searchByName(String name);

	Optional<Seller_23110353> findByNameExact(String name);

	List<Seller_23110353> findByStatus(Boolean status);

	// Lấy seller cùng với danh sách products
	List<Seller_23110353> findAllWithProducts();
}
