package jun.vn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jun.vn.entity.CartItem_23110353;
import jun.vn.repository.CartItemRepository_23110353;
import jun.vn.service.CartItemService_23110353;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl_23110353 implements CartItemService_23110353 {

    @Autowired
    private CartItemRepository_23110353 repo;

    @Override
    public List<CartItem_23110353> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<CartItem_23110353> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public CartItem_23110353 save(CartItem_23110353 cartItem) {
        return repo.save(cartItem);
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }

    @Override
    public List<CartItem_23110353> findByCart(String cartId) {
        return repo.findByCart_CartId(cartId);
    }

    @Override
    public List<CartItem_23110353> findByProduct(int productId) {
        return repo.findByProduct_ProductId(productId);
    }
}

