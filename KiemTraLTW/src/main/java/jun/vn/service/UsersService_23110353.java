package jun.vn.service;

import java.util.List;
import java.util.Optional;

import jun.vn.entity.UserRoles_23110353;
import jun.vn.entity.User_23110353;

public interface UsersService_23110353 {
    // CRUD cơ bản
    List<User_23110353> findAll();

    Optional<User_23110353> findById(Integer id);

    User_23110353 save(User_23110353 user);

    void deleteById(Integer id);

    // Nghiệp vụ
    Optional<User_23110353> findByUsername(String username);

    Optional<User_23110353> findByEmail(String email);

    // Tìm theo trạng thái (0 = inactive, 1 = active)
    List<User_23110353> findByStatus(Integer status);

    // Tìm theo cờ isSeller
    List<User_23110353> findByIsSeller(Boolean isSeller);

    // ---- Đăng ký & Đăng nhập ----
    User_23110353 register(User_23110353 user, String roleName);

    Optional<User_23110353> login(String username, String password);

    UserRoles_23110353 findRoleById(int roleId);

	Object findAllRoles();
}
