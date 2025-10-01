package jun.vn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jun.vn.entity.UserRoles_23110353;
import jun.vn.entity.User_23110353;
import jun.vn.repository.UserRolesRepository_23110353;
import jun.vn.repository.UsersRepository_23110353;
import jun.vn.service.UsersService_23110353;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsersServiceImpl_23110353 implements UsersService_23110353 {

    @Autowired
    private UsersRepository_23110353 repo;

    @Autowired
    private UserRolesRepository_23110353 roleRepo;

    @Override
    public List<User_23110353> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<User_23110353> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public User_23110353 save(User_23110353 user) {
        return repo.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<User_23110353> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public Optional<User_23110353> findByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public List<User_23110353> findByStatus(Integer status) {
        return repo.findByStatus(status);
    }

    @Override
    public List<User_23110353> findByIsSeller(Boolean isSeller) {
        return repo.findByIsSeller(isSeller);
    }

    // ===================== Đăng ký =====================
    @Override
    public User_23110353 register(User_23110353 user, String roleName) {
        if (repo.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Tên đăng nhập đã tồn tại!");
        }
        if (repo.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email đã tồn tại!");
        }
        UserRoles_23110353 role = roleRepo.findByRoleName(roleName)
                .orElseGet(() -> {
                    UserRoles_23110353 newRole = new UserRoles_23110353();
                    newRole.setRoleName(roleName);
                    return roleRepo.save(newRole);
                });
        user.setRole(role);
        user.setStatus(1);
        user.setIsSeller("ROLE_SELLER".equalsIgnoreCase(roleName));
        if (user.getCode() == null) {
            user.setCode(UUID.randomUUID().toString());
        }

        return repo.save(user);
    }

    // ===================== Đăng nhập =====================
    @Override
    public Optional<User_23110353> login(String username, String password) {
        Optional<User_23110353> userOpt = repo.findByUsername(username);

        if (userOpt.isEmpty()) {
            throw new RuntimeException("Tên đăng nhập không tồn tại!");
        }

        User_23110353 user = userOpt.get();
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Mật khẩu không chính xác!");
        }

        return Optional.of(user);
    }

	@Override
	public UserRoles_23110353 findRoleById(int roleId) {
		 return roleRepo.findById(roleId).orElse(null);
	}

	@Override
	public Object findAllRoles() {
		return roleRepo.findAll();
	}
}
