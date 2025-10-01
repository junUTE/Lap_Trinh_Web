package jun.vn.dao;

import jun.vn.entities.User;
import java.util.List;

public interface IUserDAO {
	void save(User user);              // dùng cho đăng ký hoặc thêm user
    void update(User user);            // cập nhật thông tin user
    void delete(int id);               // xóa user nếu cần
    User findById(int id);             // tìm theo id
    User findByEmail(String email);    // hỗ trợ login, đăng ký (check tồn tại)
    User findByEmailAndPassword(String email, String passwd); // hỗ trợ login
    List<User> findAll();  
}
