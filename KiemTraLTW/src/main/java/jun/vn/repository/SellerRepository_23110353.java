package jun.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jun.vn.entity.Seller_23110353;

import java.util.List;
import java.util.Optional;

public interface SellerRepository_23110353 extends JpaRepository<Seller_23110353, Integer> {

    // Tìm theo tên cửa hàng (chứa từ khóa)
    List<Seller_23110353> findBySellernameContaining(String name);

    // Tìm chính xác theo tên
    Optional<Seller_23110353> findBySellername(String name);

    // Lọc theo trạng thái (true/false)
    List<Seller_23110353> findByStatus(Boolean status);

    // Tìm seller theo userId (vì quan hệ OneToOne với User)
    Optional<Seller_23110353> findByUser_UserId(Integer userId);
}
