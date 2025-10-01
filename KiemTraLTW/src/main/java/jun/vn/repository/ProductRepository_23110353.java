package jun.vn.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import jun.vn.entity.Product_23110353;

import java.util.List;

public interface ProductRepository_23110353 extends JpaRepository<Product_23110353, Integer> {

    // Tìm theo tên chứa chuỗi
    List<Product_23110353> findByProductNameContaining(String name);

    // Tìm kiếm + phân trang
    Page<Product_23110353> findByProductNameContaining(String name, Pageable pageable);

    // Lọc theo Category
    List<Product_23110353> findByCategory_CategoryId(int categoryId);

    // Lọc theo Seller
    List<Product_23110353> findBySeller_SellerId(int sellerId);

    // Lọc theo trạng thái
    List<Product_23110353> findByStatus(Integer status);
}
