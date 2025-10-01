package jun.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jun.vn.entity.CartItem_23110353;

import java.util.List;

public interface CartItemRepository_23110353 extends JpaRepository<CartItem_23110353, String> {

    // Tìm theo Cart
    List<CartItem_23110353> findByCart_CartId(String cartId);

    // Tìm theo Product
    List<CartItem_23110353> findByProduct_ProductId(int productId);
}
