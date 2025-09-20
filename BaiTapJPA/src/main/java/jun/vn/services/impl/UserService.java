package jun.vn.services.impl;

import java.util.List;

import jun.vn.dao.IUserDao;
import jun.vn.dao.impl.UserDao;
import jun.vn.entity.User;
import jun.vn.services.IUserService;

public class UserService implements IUserService {

	IUserDao userDao = new UserDao();

	@Override
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public User login(String username, String password) {
		return userDao.login(username, password);
	}

	@Override
	public boolean register(User user) {
		return userDao.register(user);
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email); // ✅ gọi DAO
	}

	@Override
	public boolean checkExistUsername(String userName) {
		return userDao.checkExistUsername(userName);

	}
}
