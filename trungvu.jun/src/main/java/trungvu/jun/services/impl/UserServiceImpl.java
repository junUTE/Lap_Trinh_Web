package trungvu.jun.services.impl;

import quoctrung.jun.dao.UserDao;
import quoctrung.jun.dao.impl.UserDaoImpl;
import trungvu.jun.services.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao userdao = new UserDaoImpl();
}
