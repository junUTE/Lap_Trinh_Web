package jun.vn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jun.vn.entity.UserRoles_23110353;
import jun.vn.repository.UserRolesRepository_23110353;
import jun.vn.service.UserRolesService_23110353;

import java.util.List;
import java.util.Optional;

@Service
public class UserRolesServiceImpl_23110353 implements UserRolesService_23110353 {

    @Autowired
    private UserRolesRepository_23110353 repo;

    @Override
    public List<UserRoles_23110353> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<UserRoles_23110353> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public UserRoles_23110353 save(UserRoles_23110353 role) {
        return repo.save(role);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<UserRoles_23110353> findByRoleName(String name) {
        return repo.findByRoleName(name);
    }
}

