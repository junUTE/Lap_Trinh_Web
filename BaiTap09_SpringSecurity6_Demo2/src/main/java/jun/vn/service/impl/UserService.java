package jun.vn.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jun.vn.entity.UserInfo;
import jun.vn.repository.UserInfoRepository;

import org.springframework.security.crypto.password.PasswordEncoder;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserInfoRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        if (userInfo.getRoles() == null || userInfo.getRoles().isBlank()) {
            userInfo.setRoles("ROLE_USER");
        }
        repository.save(userInfo);
        return "Thêm user thành công!";
    }
}
