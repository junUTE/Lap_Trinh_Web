package jun.vn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jun.vn.entity.Cart_23110353;
import jun.vn.entity.Product_23110353;
import jun.vn.repository.CartRepository_23110353;
import jun.vn.service.CartService_23110353;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl_23110353 implements CartService_23110353 {

    @Autowired
    private CartRepository_23110353 repo;

    @Override
    public List<Cart_23110353> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Cart_23110353> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public Cart_23110353 save(Cart_23110353 cart) {
        return repo.save(cart);
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }

    @Override
    public List<Cart_23110353> findByUserId(int userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public List<Cart_23110353> findByStatus(Integer status) {
        return repo.findByStatus(status);
    }

	@Override
	public Cart_23110353 getCartByUser(int userId) {
		
		return null;
	}

	@Override
	public void removeItem(int userId, String itemId) {
		
		
	}

	@Override
	public void addToCart(int userId, Product_23110353 product, int qty) {
	
		
	}
}

