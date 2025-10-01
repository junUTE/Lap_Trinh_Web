package jun.vn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jun.vn.entity.Seller_23110353;
import jun.vn.repository.SellerRepository_23110353;
import jun.vn.service.SellerService_23110353;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl_23110353 implements SellerService_23110353 {

    @Autowired
    private SellerRepository_23110353 repo;

    @Override
    public List<Seller_23110353> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Seller_23110353> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Seller_23110353 save(Seller_23110353 seller) {
        return repo.save(seller);
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<Seller_23110353> searchByName(String name) {
        return repo.findBySellernameContaining(name);
    }

    @Override
    public Optional<Seller_23110353> findByNameExact(String name) {
        return repo.findBySellername(name);
    }

    @Override
    public List<Seller_23110353> findByStatus(Boolean status) {
        return repo.findByStatus(status);
    }

	@Override
	public List<Seller_23110353> findAllWithProducts() {
		return repo.findAll();
	}
}

