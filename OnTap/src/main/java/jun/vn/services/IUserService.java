package jun.vn.services;

import jun.vn.entities.User;
import java.util.List;

public interface IUserService {
    boolean register(User user);              // đăng ký
    User login(String email, String passwd);  // đăng nhập
    void update(User user);                   // cập nhật thông tin
    void delete(int id);                      // xóa user
    User findById(int id);                    
    List<User> findAll();
}
