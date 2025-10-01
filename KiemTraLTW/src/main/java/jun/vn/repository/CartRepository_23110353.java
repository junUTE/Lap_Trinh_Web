package jun.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jun.vn.entity.Cart_23110353;

import java.util.List;

public interface CartRepository_23110353 extends JpaRepository<Cart_23110353, String> {

    // Tìm tất cả giỏ hàng theo user
    List<Cart_23110353> findByUserId(int userId);

    // Lọc theo trạng thái
    List<Cart_23110353> findByStatus(Integer status);
}