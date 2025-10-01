package jun.vn.service;

import java.util.List;
import java.util.Optional;

import jun.vn.entity.CartItem_23110353;

public interface CartItemService_23110353 {
    List<CartItem_23110353> findAll();
    Optional<CartItem_23110353> findById(String id);
    CartItem_23110353 save(CartItem_23110353 cartItem);
    void deleteById(String id);

    // Nghiệp vụ thêm
    List<CartItem_23110353> findByCart(String cartId);
    List<CartItem_23110353> findByProduct(int productId);
}

