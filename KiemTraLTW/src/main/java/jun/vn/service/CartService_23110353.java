package jun.vn.service;

import java.util.List;
import java.util.Optional;

import jun.vn.entity.Cart_23110353;
import jun.vn.entity.Product_23110353;

public interface CartService_23110353 {
    List<Cart_23110353> findAll();
    Optional<Cart_23110353> findById(String id);
    Cart_23110353 save(Cart_23110353 cart);
    void deleteById(String id);

    // Nghiệp vụ thêm
    List<Cart_23110353> findByUserId(int userId);
    List<Cart_23110353> findByStatus(Integer status);
	Cart_23110353 getCartByUser(int userId);
	void removeItem(int userId, String itemId);
	void addToCart(int userId, Product_23110353 product, int qty);
}

