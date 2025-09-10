package jun.services.UserServiceImpl;

import jun.entities.User;
import jun.models.UserModel;
import jun.services.UserService;
import jun.dao.UserDao;
import jun.dao.UserDaoImpl.UserDaoImpl;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public boolean register(String userName, String fullName, String email, String phone, String password) {
        if (userDao.checkExistUsername(userName)) {
            return false;
        }
        if (userDao.checkExistEmail(email)) {
            return false;
        }
        if (userDao.checkExistPhone(phone)) {
            return false;
        }
        User user = new User();
        user.setUserName(userName);
        user.setFullName(fullName);
        user.setEmail(email);
        user.setSdt(phone);
        user.setPassWord(password);
        userDao.insert(user);
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public boolean updatePasswordByEmail(String email, String newPassword) {
        return userDao.updatePasswordByEmail(email, newPassword);
    }

}
