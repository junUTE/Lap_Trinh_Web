package quoctrung.services.UserServiceImpl;

import quoctrung.models.UserModel;
import quoctrung.dao.UserDao;
import quoctrung.dao.UserDaoImpl.*;
import quoctrung.services.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
	}

	@Override
	public boolean register(String userName, String fullName,String email, String phone, String passWord) {
		if (userDao.checkExistUsername(userName)) {
			return false;
		}
		//long millis = System.currentTimeMillis();
		//java.sql.Date date = new java.sql.Date(millis);
		userDao.insert(new UserModel(userName, fullName,email, phone, passWord));
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
	public UserModel login(String username, String password) {
	    // gọi DAO để xác thực
	    return userDao.login(username, password);
	}

	@Override
	public boolean updatePasswordByEmail(String email, String newPassword) {
		return userDao.updatePasswordByEmail(email, newPassword);
	}
}
