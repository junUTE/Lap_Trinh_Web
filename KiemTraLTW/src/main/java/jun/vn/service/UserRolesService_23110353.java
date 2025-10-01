package jun.vn.service;

import java.util.List;
import java.util.Optional;

import jun.vn.entity.UserRoles_23110353;

public interface UserRolesService_23110353 {
    List<UserRoles_23110353> findAll();
    Optional<UserRoles_23110353> findById(int id);
    UserRoles_23110353 save(UserRoles_23110353 role);
    void deleteById(int id);

    // Nghiệp vụ thêm
    Optional<UserRoles_23110353> findByRoleName(String name);
}
