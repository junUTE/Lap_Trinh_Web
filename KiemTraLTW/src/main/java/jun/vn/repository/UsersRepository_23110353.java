package jun.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jun.vn.entity.User_23110353;

import java.util.List;
import java.util.Optional;

public interface UsersRepository_23110353 extends JpaRepository<User_23110353, Integer> {

    // Tìm theo username
    Optional<User_23110353> findByUsername(String username);

    // Tìm theo email
    Optional<User_23110353> findByEmail(String email);

    // Tìm theo trạng thái (0 = inactive, 1 = active)
    List<User_23110353> findByStatus(Integer status);

    // Tìm theo cờ isSeller
    List<User_23110353> findByIsSeller(Boolean isSeller);

    // Kiểm tra tồn tại theo username
    boolean existsByUsername(String username);

    // Kiểm tra tồn tại theo email
    boolean existsByEmail(String email);
}
