package jun.vn.services.impl;

import jun.vn.dao.IUserDAO;
import jun.vn.dao.impl.UserDAO;
import jun.vn.entities.User;
import jun.vn.services.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserDAO userDAO = new UserDAO();

    @Override
    public boolean register(User user) {
        // kiểm tra email đã tồn tại chưa
        if (userDAO.findByEmail(user.getEmail()) != null) {
            return false;
        }
        userDAO.save(user);
        return true;
    }

    @Override
    public User login(String email, String passwd) {
        // có thể dùng findByEmailAndPassword hoặc check thủ công
        return userDAO.findByEmailAndPassword(email, passwd);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }
}
