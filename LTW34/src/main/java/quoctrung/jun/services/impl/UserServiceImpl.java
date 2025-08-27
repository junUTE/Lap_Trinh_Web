package quoctrung.jun.services.impl;

import quoctrung.jun.dao.impl.UserDaoImpl;
import quoctrung.jun.moleds.UserModel;
import quoctrung.jun.services.UserService;
import quoctrung.jun.dao.UserDao;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel findByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
