package jun.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jun.vn.entity.UserRoles_23110353;

import java.util.Optional;

public interface UserRolesRepository_23110353 extends JpaRepository<UserRoles_23110353, Integer> {

    // Tìm theo tên role
    Optional<UserRoles_23110353> findByRoleName(String roleName);
}

